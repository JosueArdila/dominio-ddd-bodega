package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.values.Periocidad;
import co.com.sofka.persona.identities.PersonaId;

import java.util.Set;

public class InventarioCreado extends DomainEvent {
    private final Periocidad periocidad;
    private final Set<PersonaId> personaIds;

    public InventarioCreado(Periocidad periocidad, Set<PersonaId> personaIds) {
        super("sofka.Inventario.InventarioCreado");
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
