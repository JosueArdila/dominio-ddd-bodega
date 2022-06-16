package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.values.Direccion;
import co.com.sofka.ubicacion.values.Estado;

public class CrearUbicacion extends Command {

    private final EspacioId espacioId;
    private final Estado estado;
    private final Dimension dimension;
    private final Direccion direccion;
    private final Categoria categoria;

    public CrearUbicacion(EspacioId espacioId, Estado estado, Dimension dimension, Direccion direccion, Categoria categoria) {
        this.espacioId = espacioId;
        this.estado = estado;
        this.dimension = dimension;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
