package dyds.solid.ejC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroProfesion implements Filtro {
    @Override
    public List<Personaje> filtrar(List<Personaje> personajes, Object filtro) {
        Profesion profesion = (Profesion) filtro;
        return personajes.stream().filter(personaje -> personaje.getRubro() == profesion).collect(Collectors.toList());
    }
}
