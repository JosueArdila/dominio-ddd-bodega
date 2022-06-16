package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;

public class DarSalidaAUnProducto extends Command {

    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoId productoId;

    public DarSalidaAUnProducto(InventarioId inventarioId, PersonaId personaId, ProductoId productoId) {
        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoId = productoId;
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
}

