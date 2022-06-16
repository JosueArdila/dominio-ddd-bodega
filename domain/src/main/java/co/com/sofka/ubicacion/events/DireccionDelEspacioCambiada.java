package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ubicacion.values.Direccion;

public class DireccionDelEspacioCambiada extends DomainEvent {
    private final Direccion direccion;

    public DireccionDelEspacioCambiada(Direccion direccion) {
        super("bodega.ubicacion.direcciondelespaciocambiada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
