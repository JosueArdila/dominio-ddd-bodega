package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ubicacion.values.Categoria;
import co.com.sofka.ubicacion.Espacio;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class CrearUbicacion extends Command {

    private final UbicacionId ubicacionId;
    private final Espacio espacio;
    private final Categoria categoria;

    public CrearUbicacion(UbicacionId ubicacionId, Espacio espacio, Categoria categoria) {
        this.ubicacionId = ubicacionId;
        this.espacio = espacio;
        this.categoria = categoria;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
