package dyds.solid.ejC.seleccionador;

import dyds.solid.ejC.Personaje;

public class SeleccionadorPorNivelMayorA implements Seleccionador {
    private int nivel;

    public SeleccionadorPorNivelMayorA(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean seleccionar(Personaje personaje) {
        return personaje.getNivel() > nivel;
    }
}
