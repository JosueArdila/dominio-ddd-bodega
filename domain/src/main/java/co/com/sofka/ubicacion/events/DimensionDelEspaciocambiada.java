package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.ubicacion.identities.EspacioId;

public class DimensionDelEspaciocambiada extends DomainEvent {
    private final EspacioId espacioId;
    private final Dimension dimension;

    public DimensionDelEspaciocambiada(EspacioId espacioId, Dimension dimension) {
        super("bodega.ubicacion.dimensiondelespaciocambiada");
        this.espacioId = espacioId;
        this.dimension = dimension;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
