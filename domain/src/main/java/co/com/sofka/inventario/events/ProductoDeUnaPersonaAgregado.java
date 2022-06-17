package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.inventario.values.FechaEntrada;
import co.com.sofka.inventario.values.Stock;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class ProductoDeUnaPersonaAgregado extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Categoria categoria;
    private final Dimension dimension;
    private final Descripcion descripcion;
    private final FechaEntrada fechaEntrada;
    private final Stock stock;
    private final UbicacionId ubicacionId;

    public ProductoDeUnaPersonaAgregado(PersonaId personaId, ProductoId productoId, Categoria categoria, Dimension dimension, Descripcion descripcion, FechaEntrada fechaEntrada, Stock stock, UbicacionId ubicacionId) {
        super("sofka.Inventario.ProductoDeUnaPersonaAgregado");
        this.personaId = personaId;
        this.productoId = productoId;
        this.categoria = categoria;
        this.dimension = dimension;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.stock = stock;
        this.ubicacionId = ubicacionId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public FechaEntrada getFechaEntrada() {
        return fechaEntrada;
    }

    public Stock getStock() {
        return stock;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }
}
