package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.persona.identities.PersonaId;

public class DescripcionDeUnProductoCambiado extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Descripcion descripcion;

    public DescripcionDeUnProductoCambiado(PersonaId personaId, ProductoId productoId, Descripcion descripcion) {
        super("sofka.Inventario.DescripcionDeUnProductoCambiado");
        this.personaId = personaId;
        this.productoId = productoId;
        this.descripcion = descripcion;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
