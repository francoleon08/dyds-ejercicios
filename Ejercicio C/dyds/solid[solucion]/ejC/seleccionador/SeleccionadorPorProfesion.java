package dyds.solid.ejC.seleccionador;

import dyds.solid.ejC.Personaje;
import dyds.solid.ejC.Profesion;

public class SeleccionadorPorProfesion implements Seleccionador {
    private Profesion profesion;

    public SeleccionadorPorProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    @Override
    public boolean seleccionar(Personaje personaje) {
        return personaje.getRubro() == profesion;
    }
}
