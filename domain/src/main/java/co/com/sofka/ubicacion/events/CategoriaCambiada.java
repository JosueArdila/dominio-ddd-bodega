package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ubicacion.values.Categoria;

public class CategoriaCambiada extends DomainEvent {
    private final Categoria categoria;

    public CategoriaCambiada(Categoria categoria) {
        super("bodega.ubicacion.categoriacambiada");
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
