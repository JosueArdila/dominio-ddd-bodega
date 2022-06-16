package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.values.Periocidad;
import co.com.sofka.persona.identities.PersonaId;

import java.util.Set;

public class CrearInventario extends Command {

    private final Periocidad periocidad;
    private final Set<PersonaId> personaIds;

    public CrearInventario(Periocidad periocidad, Set<PersonaId> personaIds) {
        this.periocidad = periocidad;
        this.personaIds = personaIds;
    }

    public Periocidad getPeriocidad() {
        return periocidad;
    }

    public Set<PersonaId> getPersonaIds() {
        return personaIds;
    }
}
