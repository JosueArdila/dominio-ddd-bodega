package co.com.sofka.persona.usercases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.persona.Persona;
import co.com.sofka.persona.commands.CrearPersona;
import co.com.sofka.persona.events.PersonaCreada;
import co.com.sofka.persona.identities.ClasificacionId;
import co.com.sofka.persona.identities.PersonaId;
import co.com.sofka.persona.values.Actividad;
import co.com.sofka.persona.values.Nombre;
import co.com.sofka.persona.values.Rol;

import java.util.List;

import static co.com.sofka.persona.values.Rol.Roles.CLIENTE;

public class CrearPersonaUseCase extends UseCase<RequestCommand<CrearPersona>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearPersona> input) {
        var command = input.getCommand();
        var persona = new Persona(new PersonaId(), command.getNombre(), command.getClasificacionId(), command.getRol(), command.getActividad());
    emit().onResponse(new ResponseEvents(persona.getUncommittedChanges()));


    }
}
