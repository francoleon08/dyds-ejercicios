package dyds.solid.ejC.seleccionador;

import dyds.solid.ejC.Personaje;
import dyds.solid.ejC.Profesion;

public class SeleccionadorPorNivelYProfesion implements Seleccionador {
    private int nivel;
    private Profesion profesion;

    public SeleccionadorPorNivelYProfesion(int nivel, Profesion profesion) {
        this.nivel = nivel;
        this.profesion = profesion;
    }

    @Override
    public boolean seleccionar(Personaje personaje) {
        return personaje.getNivel() == nivel && personaje.getRubro() == profesion;
    }

}
