package co.com.sofka.persona;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.persona.events.ActividadDeUnaClasificacionCambiado;
import co.com.sofka.persona.events.NombreCambiado;
import co.com.sofka.persona.events.PersonaCreada;
import co.com.sofka.persona.events.RolDeUnaClasificacionCambiado;

public class PersonaChange extends EventChange {
    public PersonaChange(Persona persona) {
        apply((PersonaCreada event) -> {
            persona.nombre = event.getNombre();
            persona.clasificacion = new Clasificacion(event.getClasificacionId(), event.getRol(), event.getActividad());
        });

        apply((NombreCambiado event) -> {
            persona.nombre = event.getNombre();
        });

        apply((RolDeUnaClasificacionCambiado event) -> {
            if (!persona.clasificacion.identity().equals(event.getClasificacionId())) {
                throw new IllegalArgumentException("El id no corresponde a la entidad");
            }
            persona.clasificacion.actualizarRol(event.getRol());
        });

        apply((ActividadDeUnaClasificacionCambiado event) -> {
            if (!persona.clasificacion.identity().equals(event.getClasificacionId())) {
                throw new IllegalArgumentException("El id no corresponde a la entidad");
            }
            persona.clasificacion.actualizarActividad(event.getActividad());
        });

    }
}
