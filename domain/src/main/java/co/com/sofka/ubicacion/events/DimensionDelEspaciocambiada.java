package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ubicacion.values.Dimension;

public class DimensionDelEspaciocambiada extends DomainEvent {
    private final Dimension dimension;

    public DimensionDelEspaciocambiada(Dimension dimension) {
        super("bodega.ubicacion.dimensiondelespaciocambiada");
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return dimension;
    }
}
