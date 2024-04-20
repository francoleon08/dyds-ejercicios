package dyds.solid.ejC;

import java.util.ArrayList;
import java.util.List;

public class FiltrosPersonaje {

	public List<Personaje> filtradoPorProfesion(List<Personaje> personajes, Profesion profesion) {
		List<Personaje> filteredList = new ArrayList<Personaje>();
		for (Personaje personaje : personajes) {
			if (personaje.getRubro() == profesion) {
				filteredList.add(personaje);
			}
		}
		return filteredList;
	}

	public List<Personaje> filtroContieneNombre(List<Personaje> personajes, String parteNombre) {
		List<Personaje> filteredList = new ArrayList<Personaje>();
		for (Personaje personaje : personajes) {
			if (personaje.getNombre().contains(parteNombre)) {
				filteredList.add(personaje);
			}
		}
		return filteredList;
	}

	public List<Personaje> filtroSuperaNivel(List<Personaje> personajes, int nivel) {
		List<Personaje> filteredList = new ArrayList<Personaje>();
		for (Personaje personaje : personajes) {
			if (personaje.getNivel() > nivel) {
				filteredList.add(personaje);
			}
		}
		return filteredList;
	}
}
