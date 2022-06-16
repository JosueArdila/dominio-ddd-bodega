package co.com.sofka.inventario.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.inventario.Producto;
import co.com.sofka.inventario.identities.InventarioId;
import co.com.sofka.persona.identities.PersonaId;

public class AgregarProductoAUnaPersona extends Command {
    private final InventarioId inventarioId;
    private final PersonaId personaId;
    private final Producto producto;

    public AgregarProductoAUnaPersona(InventarioId inventarioId, PersonaId personaId, Producto producto) {

        this.inventarioId = inventarioId;
        this.personaId = personaId;
        this.producto = producto;
    }

    public InventarioId getInventarioId() {
        return inventarioId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Producto getProducto() {
        return producto;
    }
}
