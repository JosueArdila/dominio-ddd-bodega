package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Categoria;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.inventario.identities.ProductoId;
import co.com.sofka.persona.identities.PersonaId;

public class CambiarCategoriaDeUnProducto extends Command {
    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final ProductoId productoId;
    private final Categoria categoria;

    public CambiarCategoriaDeUnProducto(InventarioId inventarioId, PersonaId personaId, ProductoId productoId, Categoria categoria) {

        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.productoId = productoId;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }
}
