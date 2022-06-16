package co.com.sofka.persona.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.persona.values.Nombre;

public class NombreCambiado extends DomainEvent {

    private final Nombre nombre;

    public NombreCambiado(Nombre nombre) {
        super("sofka.persona.NombreCambiado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
