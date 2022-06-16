package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ubicacion.values.Direccion;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class CambiarDireccionDelEspacio extends Command {

    private final UbicacionId ubicacionId;
    private final Direccion direccion;

    public CambiarDireccionDelEspacio(UbicacionId ubicacionId, Direccion direccion) {
        this.ubicacionId = ubicacionId;
        this.direccion = direccion;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
