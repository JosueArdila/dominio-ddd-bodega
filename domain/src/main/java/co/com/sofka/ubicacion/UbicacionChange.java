package co.com.sofka.ubicacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ubicacion.events.*;

public class UbicacionChange extends EventChange {
    public UbicacionChange(Ubicacion ubicacion) {

        apply((UbicacionCreada event) -> {
            ubicacion.espacio = event.getEspacio();
            ubicacion.categoria = event.getCategoria();
        });

        apply((CategoriaCambiada event) -> {
            ubicacion.categoria = event.getCategoria();
        });

        apply((EstadoDelEspacioActualizado event) -> {
            ubicacion.espacio.estado = event.getEstado();
        });

        apply((DireccionDelEspacioCambiada event) -> {
            ubicacion.espacio.direccion = event.getDireccion();
        });

        apply((DimensionDelEspaciocambiada event) -> {
            ubicacion.espacio.dimension = event.getDimension();
        });


    }
}
