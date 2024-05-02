package dyds.solid.ejC.seleccionador;

import dyds.solid.ejC.Personaje;

public class SeleccionadorPorNombre implements Seleccionador {
    private String nombre;

    public SeleccionadorPorNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean seleccionar(Personaje personaje) {
        return personaje.getNombre().contains(nombre);
    }
}
