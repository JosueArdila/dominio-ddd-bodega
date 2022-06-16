package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class AsignarUbicacionDeUnProducto extends Command {

    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final UbicacionId ubicacionId;

    public AsignarUbicacionDeUnProducto(InventarioId inventarioId, PersonaId personaId, ProductoId productoId, UbicacionId ubicacionId) {
        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoId = productoId;
        this.ubicacionId = ubicacionId;
    }

    public InventarioId getInventarioId() {
        return inventarioId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }
}
