package co.com.sofka.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.ubicacion.values.Categoria;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class CambiarCategoria extends Command {

    private final UbicacionId ubicacionId;
    private final Categoria categoria;

    public CambiarCategoria(UbicacionId ubicacionId, Categoria categoria) {
        this.ubicacionId = ubicacionId;
        this.categoria = categoria;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
