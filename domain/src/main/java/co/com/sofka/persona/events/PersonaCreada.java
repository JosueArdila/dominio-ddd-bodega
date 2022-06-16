package co.com.sofka.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.persona.Clasificacion;
import co.com.sofka.persona.values.Nombre;

public class PersonaCreada extends DomainEvent {
    private final Nombre nombre;
    private final Clasificacion clasificacion;

    public PersonaCreada(Nombre nombre, Clasificacion clasificacion) {
        super("sofka.persona.PersonaCreada");
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }
}
