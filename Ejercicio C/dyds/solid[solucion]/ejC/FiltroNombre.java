package dyds.solid.ejC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroNombre implements Filtro {
    @Override
    public List<Personaje> filtrar(List<Personaje> personajes, Object filtro) {
        String parteNombre = (String) filtro;
        return personajes.stream().filter(personaje -> personaje.getNombre().contains(parteNombre)).collect(Collectors.toList());
    }
}
