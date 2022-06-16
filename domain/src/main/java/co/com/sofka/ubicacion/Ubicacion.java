package co.com.sofka.ubicacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.ubicacion.events.*;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.values.Direccion;
import co.com.sofka.ubicacion.values.Estado;
import co.com.sofka.ubicacion.identities.UbicacionId;

import java.util.List;

public class Ubicacion extends AggregateEvent<UbicacionId> {

    protected Espacio espacio;
    protected Categoria categoria;

    public Ubicacion(UbicacionId id, Espacio espacio, Categoria categoria) {
        super(id);
        appendChange(new UbicacionCreada(espacio, categoria)).apply();
    }

    private Ubicacion(UbicacionId id) {
        super(id);
        subscribe(new UbicacionChange(this));
    }

    public static Ubicacion from(UbicacionId ubicacionId, List<DomainEvent> events) {
        var ubicacion = new Ubicacion(ubicacionId);
        events.forEach(ubicacion::applyEvent);
        return ubicacion;
    }

    public void cambiarCategoria(Categoria categoria) {
        appendChange(new CategoriaCambiada(categoria)).apply();
    }

    public void actualizarEstadoDelEspacio(EspacioId espacioId, Estado estado) {
        appendChange(new EstadoDelEspacioActualizado(espacioId, estado)).apply();
    }

    public void cambiarDimensionDelEspacio(EspacioId espacioId, Dimension dimension) {
        appendChange(new DimensionDelEspaciocambiada(espacioId, dimension)).apply();
    }

    public void cambiarDireccionDelEspacio(EspacioId espacioId, Direccion direccion) {
        appendChange(new DireccionDelEspacioCambiada(espacioId, direccion)).apply();
    }
}
