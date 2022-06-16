package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.values.Periocidad;

public class PeriocidadCambiada extends DomainEvent {
    private final Periocidad periocidad;

    public PeriocidadCambiada(Periocidad periocidad) {
        super("sofka.Inventario.PeriocidadCambiada");
        this.periocidad = periocidad;

    }

    public Periocidad getPeriocidad() {
        return periocidad;
    }
}
