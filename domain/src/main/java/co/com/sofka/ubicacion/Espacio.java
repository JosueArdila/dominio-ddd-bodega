package co.com.sofka.ubicacion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.ubicacion.values.Direccion;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.values.Estado;

import java.util.Objects;

public class Espacio extends Entity<EspacioId> {

    private Estado estado;
    private Dimension dimension;
    private Direccion direccion;

    public Espacio(EspacioId entityId, Dimension dimension, Direccion direccion) {
        super(entityId);
        this.dimension = dimension;
        this.direccion = direccion;
    }

    public Estado estado() {
        return estado;
    }

    public Dimension dimension() {
        return dimension;
    }

    public Direccion direccion() {
        return direccion;
    }

    public void actualizarEstado(Estado estado) {
        this.estado = estado;
    }

    public void cambiarDimension(Dimension dimension) {
        this.dimension = Objects.requireNonNull(dimension);
    }

    public void cambiarDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


}
