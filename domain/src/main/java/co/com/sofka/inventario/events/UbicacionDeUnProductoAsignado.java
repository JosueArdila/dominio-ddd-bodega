package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class UbicacionDeUnProductoAsignado extends DomainEvent {
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final UbicacionId ubicacionId;

    public UbicacionDeUnProductoAsignado(PersonaId personaId, ProductoId productoId, UbicacionId ubicacionId) {
        super("sofka.Inventario.UbicacionDeUnProductoAsignado");

        this.personaId = personaId;
        this.productoId = productoId;
        this.ubicacionId = ubicacionId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }
}
