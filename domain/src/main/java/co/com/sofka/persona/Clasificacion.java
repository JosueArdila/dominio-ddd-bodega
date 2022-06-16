package co.com.sofka.persona;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.values.Rol;

import java.util.Objects;

public class Clasificacion extends Entity<ClasificacionId> {
    private Rol rol;
    private Actividad actividad;

    public Clasificacion(ClasificacionId clasificacionId, Rol rol, Actividad actividad) {
        super(clasificacionId);
        this.rol = rol;
        this.actividad = actividad;
    }

    public void actualizarRol(Rol rol) {
        this.rol = Objects.requireNonNull(rol);
    }

    public void actualizarActividad(Actividad actividad) {
        this.actividad = Objects.requireNonNull(actividad);
    }
}
