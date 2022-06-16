package co.com.sofka.inventario;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.inventario.events.*;

import java.util.HashMap;

public class InventarioChange extends EventChange {
    public InventarioChange(Inventario inventario) {
        apply((InventarioCreado event)->{
            inventario.periocidad=event.getPeriocidad();
            inventario.productosPersona= new HashMap<>();
            });
        apply((PeriocidadCambiada event) ->{
            inventario.periocidad=event.getPeriocidad();
        });
        apply((ProductoDeUnaPersonaAgregado event) ->{
            if(inventario.productosPersona.containsKey(event.getPersonaId())){
                var productos = inventario.productosPersona.get(event.getPersonaId());
                productos.add(event.getProducto());
            }

        });
        apply((DescripcionDeUnProductoCambiado event) ->{
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(()-> new IllegalArgumentException("Producto no encontrado"));
            producto.cambiarDescripcion(event.getDescripcion());
        });
        apply((StockDeUnProductoAumentado event)->{
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(()-> new IllegalArgumentException("Producto no encontrado"));
            producto.aumentarStock(event.getStock());
        });
        apply((StockDeUnProductoDisminuido event)->{
            var producto = inventario.encontrarProductoDeLaPersona(event.getPersonaId(), event.getProductoId())
                    .orElseThrow(()-> new IllegalArgumentException("Producto no encontrado"));
            producto.disminuirStock(event.getStock());
        });
        
    }
}
