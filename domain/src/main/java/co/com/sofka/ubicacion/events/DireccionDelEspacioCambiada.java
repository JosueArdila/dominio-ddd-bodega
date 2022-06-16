package co.com.sofka.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.ubicacion.identities.EspacioId;
import co.com.sofka.ubicacion.values.Direccion;

public class DireccionDelEspacioCambiada extends DomainEvent {
    private final EspacioId espacioId;
    private final Direccion direccion;

    public DireccionDelEspacioCambiada(EspacioId espacioId, Direccion direccion) {
        super("bodega.ubicacion.direcciondelespaciocambiada");
        this.espacioId = espacioId;
        this.direccion = direccion;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
