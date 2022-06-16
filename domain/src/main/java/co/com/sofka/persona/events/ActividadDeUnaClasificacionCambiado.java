package co.com.sofka.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.identities.ClasificacionId;

public class ActividadDeUnaClasificacionCambiado extends DomainEvent {
    private final ClasificacionId clasificacionId;
    private final Actividad actividad;

    public ActividadDeUnaClasificacionCambiado(ClasificacionId clasificacionId, Actividad actividad) {
        super("sofka.persona.ActividadDeUnaClasificacionCambiado");
        this.clasificacionId = clasificacionId;
        this.actividad = actividad;
    }

    public ClasificacionId getClasificacionId() {
        return clasificacionId;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
