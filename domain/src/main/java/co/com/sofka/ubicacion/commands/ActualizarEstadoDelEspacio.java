package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.values.Estado;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class ActualizarEstadoDelEspacio extends Command {

    private final UbicacionId ubicacionId;
    private final EspacioId espacioId;
    private final Estado estado;

    public ActualizarEstadoDelEspacio(UbicacionId ubicacionId, EspacioId espacioId,  Estado estado) {
        this.ubicacionId = ubicacionId;
        this.espacioId = espacioId;
        this.estado = estado;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Estado getEstado() {
        return estado;
    }
}
