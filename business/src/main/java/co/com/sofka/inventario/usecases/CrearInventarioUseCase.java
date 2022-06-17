package co.com.sofka.inventario.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.inventario.Inventario;
import co.com.sofka.inventario.commands.CrearInventario;
import co.com.sofka.inventario.identities.InventarioId;

public class CrearInventarioUseCase extends UseCase<RequestCommand<CrearInventario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearInventario> input) {
        var command = input.getCommand();
        var inventario = new Inventario(new InventarioId(), command.getPeriocidad(), command.getPersonaIds());
        emit().onResponse(new ResponseEvents(inventario.getUncommittedChanges()));
    }
}
