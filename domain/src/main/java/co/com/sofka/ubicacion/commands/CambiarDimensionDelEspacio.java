package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ubicacion.identities.UbicacionId;
import co.com.sofka.ubicacion.values.Dimension;

public class CambiarDimensionDelEspacio extends Command {

    private final UbicacionId ubicacionId;
    private final Dimension dimension;


    public CambiarDimensionDelEspacio(UbicacionId ubicacionId, Dimension dimension) {
        this.ubicacionId = ubicacionId;
        this.dimension = dimension;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
