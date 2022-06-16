package co.com.sofka.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.identities.PersonaId;

public class CambiarActividadDeUnaClasificacion extends Command {
    private final PersonaId personaId;
    private final ClasificacionId clasificacionId;
    private final Actividad actividad;

    public CambiarActividadDeUnaClasificacion(PersonaId personaId, ClasificacionId clasificacionId, Actividad actividad) {
        this.personaId = personaId;
        this.clasificacionId = clasificacionId;
        this.actividad = actividad;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ClasificacionId getClasificacionId() {
        return clasificacionId;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
