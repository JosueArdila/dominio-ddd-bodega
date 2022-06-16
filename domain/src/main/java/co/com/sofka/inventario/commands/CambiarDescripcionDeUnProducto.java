package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.inventario.values.Descripcion;
import co.com.sofka.persona.identities.PersonaId;

public class CambiarDescripcionDeUnProducto extends Command {

    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Descripcion descripcion;

    public CambiarDescripcionDeUnProducto(InventarioId inventarioId, PersonaId personaId, ProductoId productoId, Descripcion descripcion) {

        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoId = productoId;
        this.descripcion = descripcion;
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

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
