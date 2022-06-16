package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.Producto;
import co.com.sofka.persona.identities.PersonaId;

public class ProductoDeUnaPersonaAgregado extends DomainEvent {
    private final PersonaId personaId;
    private final Producto producto;

    public ProductoDeUnaPersonaAgregado(PersonaId personaId, Producto producto) {
        super("sofka.Inventario.ProductoDeUnaPersonaAgregado");
        this.personaId = personaId;
        this.producto = producto;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Producto getProducto() {
        return producto;
    }
}
