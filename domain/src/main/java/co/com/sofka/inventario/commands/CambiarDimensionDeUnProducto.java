package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Dimension;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;

public class CambiarDimensionDeUnProducto extends Command {
    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Dimension dimension;

    public CambiarDimensionDeUnProducto(InventarioId inventarioId, PersonaId personaId, ProductoId productoId, Dimension dimension) {

        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoId = productoId;
        this.dimension = dimension;
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

    public Dimension getDimension() {
        return dimension;
    }
}
