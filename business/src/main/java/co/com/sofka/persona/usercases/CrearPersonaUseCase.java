package co.com.sofka.persona.usercases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.persona.Persona;
import co.com.sofka.persona.commands.CrearPersona;
import co.com.sofka.persona.identities.PersonaId;

public class CrearPersonaUseCase extends UseCase<RequestCommand<CrearPersona>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearPersona> input) {
        var command = input.getCommand();
        var persona = new Persona(new PersonaId(), command.getNombre(), command.getClasificacionId(), command.getRol(), command.getActividad());
        emit().onResponse(new ResponseEvents(persona.getUncommittedChanges()));


    }
}
