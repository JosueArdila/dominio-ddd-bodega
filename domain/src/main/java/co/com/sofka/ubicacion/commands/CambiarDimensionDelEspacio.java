package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class CambiarDimensionDelEspacio extends Command {

    private final UbicacionId ubicacionId;
    private final EspacioId espacioId;
    private final Dimension dimension;


    public CambiarDimensionDelEspacio(UbicacionId ubicacionId, EspacioId espacioId, Dimension dimension) {
        this.ubicacionId = ubicacionId;
        this.espacioId = espacioId;
        this.dimension = dimension;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
