package co.com.sofka.inventario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.events.*;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.inventario.values.Periocidad;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.ubicacion.identities.UbicacionId;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Inventario extends AggregateEvent<InventarioId> {

    protected Periocidad periocidad;
    protected Map <PersonaId, Set<Producto>> productosPersona;

    public Inventario(InventarioId entityId, Periocidad periocidad, Set<PersonaId> personaIds) {
        super(entityId);
        subscribe(new InventarioChange(this));
        appendChange(new InventarioCreado(periocidad, personaIds)).apply();
    }

    private Inventario(InventarioId entityId){
        super(entityId);
        subscribe(new InventarioChange(this));
    }

    public static Inventario from(InventarioId inventarioId, List<DomainEvent> events){
        Inventario inventario = new Inventario(inventarioId);
        events.forEach(inventario::applyEvent);
        return inventario;
    }

    public void cambiarPeriocidad(Periocidad periocidad){
        appendChange(new PeriocidadCambiada(periocidad)).apply();
    }

    public void agregarProductoAUnaPersona(PersonaId personaId, Producto producto){
        appendChange(new ProductoDeUnaPersonaAgregado(personaId, producto)).apply();
    }

    public void cambiarDescripcionDeUnProducto(PersonaId personaId, ProductoId productoId, Descripcion descripcion){
        appendChange(new DescripcionDeUnProductoCambiado(personaId, productoId, descripcion)).apply();
    }

    public void aumentarStockDeUnProducto(PersonaId personaId, ProductoId productoId, Stock stock){
        appendChange(new StockDeUnProductoAumentado(personaId, productoId, stock)).apply();
    }

    public void disminuirStockDeUnProducto(PersonaId personaId, ProductoId productoId, Stock stock){
        appendChange(new StockDeUnProductoDisminuido(personaId, productoId, stock)).apply();
    }

    public void asignarUbicacionDeUnProducto(PersonaId personaId, ProductoId productoId, UbicacionId ubicacionId){
        appendChange(new UbicacionDeUnProductoAsignado(personaId, productoId, ubicacionId)).apply();
    }

    public void darSalidaAUnProducto(PersonaId personaId, ProductoId productoId){
        appendChange(new ProductoDespachado(personaId, productoId)).apply();
    }

    public void cambiarCategoriaDeUnProducto(PersonaId personaId, ProductoId productoId,  Categoria categoria){
     appendChange(new CategoriaDeUnProductoCambiada(personaId, productoId, categoria)).apply();
    }

    public void cambiarDimensionDeUnProducto(PersonaId personaId, ProductoId productoId, Dimension dimension){
        appendChange(new DimensionDeUnProductoCambiada(personaId, productoId, dimension)).apply();
    }

    protected Optional<Producto> encontrarProductoDeLaPersona(PersonaId personaId, ProductoId productoId){

        comprobarExistenciaCliente(personaId);
        var productos= obtenerListaProductosPorPersonaId(personaId);

        return productos.stream()
                .filter(producto -> producto.identity().equals(productoId))
                .findFirst();
    }
    private void comprobarExistenciaCliente(PersonaId personaId){
        if(!productosPersona.containsKey(personaId)){
            throw new IllegalArgumentException("La persona no se encontro");
        }
    }

    protected Set<Producto> obtenerListaProductosPorPersonaId(PersonaId personaId){
        return productosPersona.get(personaId);
    }
}
