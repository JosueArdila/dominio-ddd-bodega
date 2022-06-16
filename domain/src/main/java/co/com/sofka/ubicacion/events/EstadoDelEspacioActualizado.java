package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ubicacion.values.Estado;

public class EstadoDelEspacioActualizado extends DomainEvent {
    private final Estado estado;

    public EstadoDelEspacioActualizado(Estado estado) {
        super("bodega.ubicacion.estadodelespacioactualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
