package dyds.solid.ejC;

import java.util.List;

public interface Filtro {

    public List<Personaje> filtrar(List<Personaje> personajes, Object filtro);
}
