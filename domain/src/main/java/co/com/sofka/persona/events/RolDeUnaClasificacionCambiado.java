package co.com.sofka.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.values.Rol;

public class RolDeUnaClasificacionCambiado extends DomainEvent {
    private final ClasificacionId clasificacionId;
    private final Rol rol;

    public RolDeUnaClasificacionCambiado(ClasificacionId clasificacionId, Rol rol) {
        super("sofka.persona.RolDeUnaClasificacionCambiado");
        this.clasificacionId = clasificacionId;
        this.rol = rol;
    }

    public ClasificacionId getClasificacionId() {
        return clasificacionId;
    }

    public Rol getRol() {
        return rol;
    }
}
