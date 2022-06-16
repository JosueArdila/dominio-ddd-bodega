package co.com.sofka.persona.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.values.Nombre;
import co.com.sofka.persona.values.Rol;

public class CrearPersona extends Command {
    private final Nombre nombre;
    private final ClasificacionId clasificacionId;
    private final Rol rol;
    private final Actividad actividad;

    public CrearPersona(Nombre nombre, ClasificacionId clasificacionId, Rol rol, Actividad actividad) {
        this.nombre = nombre;
        this.clasificacionId = clasificacionId;
        this.rol = rol;
        this.actividad = actividad;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public ClasificacionId getClasificacionId() {
        return clasificacionId;
    }

    public Rol getRol() {
        return rol;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
