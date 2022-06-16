package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;

public class ProductoDespachado extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;

    public ProductoDespachado(PersonaId personaId, ProductoId productoId) {
        super("sofka.Inventario.ProductoDespachado");
        this.personaId = personaId;
        this.productoId = productoId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }
}
