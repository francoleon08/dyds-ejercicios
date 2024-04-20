package dyds.solid.ejC;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroNivel implements Filtro {
    @Override
    public List<Personaje> filtrar(List<Personaje> personajes, Object filtro) {
        int nivel = (int) filtro;
        return personajes.stream().filter(personaje -> personaje.getNivel() > nivel).collect(Collectors.toList());
    }
}
