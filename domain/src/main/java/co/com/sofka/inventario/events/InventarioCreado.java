package co.com.sofka.inventario.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.inventario.values.Periocidad;

public class InventarioCreado extends DomainEvent {
    private final Periocidad periocidad;

    public InventarioCreado(Periocidad periocidad) {
        super("sofka.Inventario.InventarioCreado");
        this.periocidad = periocidad;
    }

    public Periocidad getPeriocidad() {
        return periocidad;
    }
}
