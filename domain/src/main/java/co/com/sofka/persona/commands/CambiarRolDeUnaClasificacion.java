package co.com.sofka.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.persona.values.Rol;

public class CambiarRolDeUnaClasificacion extends Command {
    private final PersonaId personaId;
    private final ClasificacionId clasificacionId;
    private final Rol rol;

    public CambiarRolDeUnaClasificacion(PersonaId personaId, ClasificacionId clasificacionId, Rol rol) {
        this.personaId = personaId;
        this.clasificacionId = clasificacionId;
        this.rol = rol;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ClasificacionId getClasificacionId() {
        return clasificacionId;
    }

    public Rol getRol() {
        return rol;
    }
}
