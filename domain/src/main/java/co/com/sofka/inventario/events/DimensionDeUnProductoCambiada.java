package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;

public class DimensionDeUnProductoCambiada extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Dimension dimension;

    public DimensionDeUnProductoCambiada(PersonaId personaId, ProductoId productoId, Dimension dimension) {
        super("sofka.Inventario.DimensionDeUnProductoCambiada");
        this.personaId = personaId;
        this.productoId = productoId;
        this.dimension = dimension;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
