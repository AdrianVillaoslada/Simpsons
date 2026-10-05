package es.daw.simpsons.servicio;

import es.daw.simpsons.model.Personaje;
import es.daw.simpsons.repository.PersonajeRepository;

import java.util.List;

public class PersonajeServicio {
    private final PersonajeRepository repository = new PersonajeRepository();
/*
    public List<Personaje> buscar(String lugar, Integer edadMax, String ordenarPor, boolean descendente, Integer limite //perndiente) {



        return repository.findAll().stream().filter(p -> lugar == null || lugar.isBlank()) || p.lugar().)
    }*/

    /**
     *
     * @param lugar
     * @param edadMax
     * @param ordenarPor
     * @param descendente
     * @param limite
     * @return
     */

    List<Personaje> personajes = repository.findAll();

    public List<Personaje> buscar(String lugar, Integer edadMax, String ordenarPor, boolean descendente, Integer limite){
        return repository.findAll().stream().filter( p -> lugar == null || lugar.isBlank() || p.lugar().equalsIgnoreCase(lugar))
                .filter(p -> edadMax == null || p.edad() > edadMax)
                .sorted( (p1, p2) -> p1.nombre().compareTo(p2.nombre()))
                .limit(limite == null ? Integer.MAX_VALUE : limite)
                .toList();
    }


    /**
     *
     * @return
     */

    public List<String> lugaresDisponibles(){
        return repository.findAll().stream()
                .map(Personaje::lugar)
                .distinct()
                .sorted()
                .toList();
    }

}
