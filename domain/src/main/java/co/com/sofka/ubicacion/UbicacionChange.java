package co.com.sofka.ubicacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.ubicacion.events.*;

public class UbicacionChange extends EventChange {
    public UbicacionChange(Ubicacion ubicacion) {

        apply((UbicacionCreada event) -> {
            ubicacion.espacio = new Espacio(event.getEspacioId(), event.getDimension(), event.getDireccion());
            ubicacion.categoria = event.getCategoria();
        });

        apply((CategoriaCambiada event) -> {
            ubicacion.categoria = event.getCategoria();
        });

        apply((EstadoDelEspacioActualizado event) -> {
            if(!ubicacion.espacio.identity().equals(event.getEspacioId())){
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            ubicacion.espacio.actualizarEstado(event.getEstado());
        });

        apply((DireccionDelEspacioCambiada event) -> {
            if(!ubicacion.espacio.identity().equals(event.getEspacioId())){
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            ubicacion.espacio.cambiarDireccion(event.getDireccion());
        });

        apply((DimensionDelEspaciocambiada event) -> {
            if(!ubicacion.espacio.identity().equals(event.getEspacioId())){
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            ubicacion.espacio.cambiarDimension(event.getDimension());
        });


    }
}
