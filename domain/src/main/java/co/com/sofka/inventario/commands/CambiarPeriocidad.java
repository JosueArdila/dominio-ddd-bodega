package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.values.Periocidad;

public class CambiarPeriocidad extends Command {

    private final InventarioId inventarioId;
    private final Periocidad periocidad;

    public CambiarPeriocidad(InventarioId inventarioId, Periocidad periocidad) {
        this.inventarioId = inventarioId;
        this.periocidad = periocidad;
    }

    public InventarioId getInventarioId() {
        return inventarioId;
    }

    public Periocidad getPeriocidad() {
        return periocidad;
    }
}
