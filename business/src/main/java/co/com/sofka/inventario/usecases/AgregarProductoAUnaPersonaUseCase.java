package co.com.sofka.inventario.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.inventario.Inventario;
import co.com.sofka.inventario.commands.AgregarProductoAUnaPersona;

public class AgregarProductoAUnaPersonaUseCase extends UseCase<RequestCommand<AgregarProductoAUnaPersona>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProductoAUnaPersona> input) {
        var command = input.getCommand();
        var inventario = Inventario.from(command.getInventarioId(), repository().getEventsBy(command.getInventarioId().value()));

        inventario.agregarProductoAUnaPersona(command.getPersonaId(), command.getProductoFactory());

        emit().onResponse(new ResponseEvents(inventario.getUncommittedChanges()));
    }
}
