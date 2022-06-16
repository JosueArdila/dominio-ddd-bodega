package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.ubicacion.Espacio;

public class UbicacionCreada extends DomainEvent {

    private final Espacio espacio;
    private final Categoria categoria;

    public UbicacionCreada(Espacio espacio, Categoria categoria) {
        super("bodega.ubicacion.ubicacioncreada");
        this.espacio = espacio;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Espacio getEspacio() {
        return espacio;
    }
}
