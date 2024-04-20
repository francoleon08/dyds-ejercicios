package dyds.solid.ejC;

import java.util.List;

public class LogicaPersonajes {

	private Filtro filtro;
	private List<Personaje> personajes;

	public LogicaPersonajes(Filtro filtro, List<Personaje> personajes) {
		this.filtro = filtro;
		this.personajes = personajes;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

	public List<Personaje> getPersonajesConFiltro(Object filtro) {
		return this.filtro.filtrar(personajes, filtro);
	}

}
