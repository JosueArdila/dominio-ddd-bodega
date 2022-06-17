package co.com.sofka.inventario;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.inventario.events.*;

import java.util.HashMap;
import java.util.HashSet;

public class InventarioChange extends EventChange {
    public InventarioChange(Inventario inventario) {
        apply((InventarioCreado event) -> {
            inventario.periocidad = event.getPeriocidad();
            inventario.productosPersona = new HashMap<>();
            event.getPersonaIds().forEach(personaId ->
                    inventario.productosPersona.put(personaId, new HashSet<>()));
        });
        apply((PeriocidadCambiada event) -> {
            inventario.periocidad = event.getPeriocidad();
        });
        apply((ProductoDeUnaPersonaAgregado event) -> {
            if (!inventario.productosPersona.containsKey(event.getPersonaId())) {
                throw new IllegalArgumentException("Persona no encontrada");
            }
            var productos = inventario.productosPersona.get(event.getPersonaId());
            productos.add(new Producto(event.getProductoId(), event.getCategoria(), event.getDimension(), event.getDescripcion(), event.getFechaEntrada(), event.getStock(), event.getUbicacionId()));

        });
        apply((DescripcionDeUnProductoCambiado event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            producto.cambiarDescripcion(event.getDescripcion());
        });
        apply((StockDeUnProductoAumentado event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            producto.aumentarStock(event.getStock());
        });
        apply((StockDeUnProductoDisminuido event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            producto.disminuirStock(event.getStock());
        });
        apply((UbicacionDeUnProductoAsignado event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            producto.asignarUbicacion(event.getUbicacionId());
        });
        apply((ProductoDespachado event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            var productos = inventario.obtenerListaProductosPorPersonaId(event.getPersonaId());
            productos.remove(producto);
        });
        apply((CategoriaDeUnProductoCambiada event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            producto.cambiarCategoria(event.getCategoria());
        });
        apply((DimensionDeUnProductoCambiada event) -> {
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
            producto.cambiarDimension(event.getDimension());
        });
    }
}
