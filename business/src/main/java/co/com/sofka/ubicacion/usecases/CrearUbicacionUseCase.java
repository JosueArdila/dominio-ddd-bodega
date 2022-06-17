package co.com.sofka.ubicacion.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.ubicacion.Ubicacion;
import co.com.sofka.ubicacion.commands.CrearUbicacion;
import co.com.sofka.ubicacion.identities.UbicacionId;

public class CrearUbicacionUseCase extends UseCase<RequestCommand<CrearUbicacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearUbicacion> input) {

        var command = input.getCommand();
        var ubicacion = new Ubicacion(new UbicacionId(), command.getEspacioId(), command.getEstado(),
                command.getDimension(), command.getDireccion(), command.getCategoria());
        emit().onResponse(new ResponseEvents(ubicacion.getUncommittedChanges()));
    }
}
