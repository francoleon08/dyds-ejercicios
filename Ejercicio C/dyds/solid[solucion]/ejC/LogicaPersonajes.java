package dyds.solid.ejC;

import dyds.solid.ejC.seleccionador.Seleccionador;

import java.util.List;

public class LogicaPersonajes {

	private List<Personaje> personajes;

	public LogicaPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public List<Personaje> getPersonajesConFiltro(Filtro filtro, Seleccionador seleccionador) {
		return filtro.filtrar(personajes, seleccionador);
	}
}
