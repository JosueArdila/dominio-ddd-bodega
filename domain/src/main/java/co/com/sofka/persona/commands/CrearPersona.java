package co.com.sofka.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.persona.Clasificacion;
import co.com.sofka.persona.values.Nombre;
import co.com.sofka.persona.identities.PersonaId;

public class CrearPersona extends Command {
    private final PersonaId personaId;
    private final Nombre nombre;
    private final Clasificacion clasificacion;

    public CrearPersona(PersonaId personaId, Nombre nombre, Clasificacion clasificacion) {
        this.personaId = personaId;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
