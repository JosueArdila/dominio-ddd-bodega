package co.com.sofka.persona;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.persona.events.ActividadDeUnaClasificacionCambiado;
import co.com.sofka.persona.events.NombreCambiado;
import co.com.sofka.persona.events.PersonaCreada;
import co.com.sofka.persona.events.RolDeUnaClasificacionCambiado;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.values.Nombre;
import co.com.sofka.persona.values.Rol;

import java.util.List;
import java.util.Objects;

public class Persona extends AggregateEvent<PersonaId> {
    protected Nombre nombre;
    protected Clasificacion clasificacion;

    public Persona(PersonaId personaId, Nombre nombre, ClasificacionId clasificacionId, Rol rol, Actividad actividad) {
        super(personaId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(clasificacionId);
        Objects.requireNonNull(rol);
        Objects.requireNonNull(actividad);
        subscribe(new PersonaChange(this));
        appendChange(new PersonaCreada(nombre, clasificacionId, rol, actividad)).apply();
    }

    private Persona(PersonaId personaId) {
        super(personaId);
        subscribe(new PersonaChange(this));
    }

    public static Persona from(PersonaId personaId, List<DomainEvent> events) {
        var persona = new Persona(personaId);
        events.forEach(persona::applyEvent);
        return persona;
    }

    public void cambiarNombre(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreCambiado(nombre)).apply();
    }

    public void cambiarRolDeUnaClasificacion(ClasificacionId clasificacionId, Rol rol) {
        Objects.requireNonNull(clasificacionId);
        Objects.requireNonNull(rol);
        appendChange(new RolDeUnaClasificacionCambiado(clasificacionId, rol)).apply();
    }

    public void cambiarActividadDeUnaClasificacion(ClasificacionId clasificacionId, Actividad actividad) {
        Objects.requireNonNull(clasificacionId);
        Objects.requireNonNull(actividad);
        appendChange(new ActividadDeUnaClasificacionCambiado(clasificacionId, actividad)).apply();
    }

    public Nombre nombre() {
        return nombre;
    }

    public Clasificacion clasificacion() {
        return clasificacion;
    }
}
