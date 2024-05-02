package dyds.solid.ejC;

import dyds.solid.ejC.seleccionador.Seleccionador;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro {

    public List<Personaje> filtrar(List<Personaje> personajes, Seleccionador seleccionador) {
        return personajes.stream().filter(seleccionador::seleccionar).collect(Collectors.toList());
    }
}
