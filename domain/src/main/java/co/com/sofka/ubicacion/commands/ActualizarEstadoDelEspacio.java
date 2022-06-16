package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ubicacion.values.Estado;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class ActualizarEstadoDelEspacio extends Command {

    private final UbicacionId ubicacionId;
    private final Estado estado;

    public ActualizarEstadoDelEspacio(UbicacionId ubicacionId, Estado estado) {
        this.ubicacionId = ubicacionId;
        this.estado = estado;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Estado getEstado() {
        return estado;
    }
}
