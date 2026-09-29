package servicio;

import model.Personaje;
import repository.PersonajeRepository;

import java.util.List;

public class PersonajeServicio {
    // En spring aprenderemos a usar inyeccion de dependencias y no usar new...
    private final PersonajeRepository personajeRepository = new PersonajeRepository();

    private List<Personaje> buscar() {

    }

}
