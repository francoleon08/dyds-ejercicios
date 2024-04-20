package dyds.solid.tests;

import dyds.solid.ejC.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjCTest {

	Filtro filtroNivel;
	Filtro filtroNombre;
	Filtro filtroProfesion;
	LogicaPersonajes logicaPersonajes;
	List<Personaje> personajes;

	@BeforeEach
	public void setUp() throws Exception {
		filtroNivel = new FiltroNivel();
		filtroNombre = new FiltroNombre();
		filtroProfesion = new FiltroProfesion();

		personajes = new ArrayList<Personaje>();

		Personaje personajeA = new Personaje("Pungui", Profesion.Granuja, 500, 5);
		Personaje personajeB = new Personaje("Conano", Profesion.Campeon, 20, 50);
		Personaje personajeC = new Personaje("El Magias", Profesion.Mago, 200, 10);
		Personaje personajeD = new Personaje("El Raton", Profesion.Granuja, 750, 15);

		personajes.add(personajeA);
		personajes.add(personajeB);
		personajes.add(personajeC);
		personajes.add(personajeD);

		logicaPersonajes = new LogicaPersonajes(filtroNivel, personajes);
	}

	@Test
	public void testProfesionesCant() {
		logicaPersonajes.setFiltro(filtroProfesion);
		List<Personaje> clientesBB = logicaPersonajes.getPersonajesConFiltro(Profesion.Granuja);
		
		assertEquals(clientesBB.size(), 2);
	}

	@Test
	public void testProfPersonaje1() {
		logicaPersonajes.setFiltro(filtroProfesion);
		List<Personaje> clientesBB = logicaPersonajes.getPersonajesConFiltro(Profesion.Granuja);

		assertEquals(clientesBB.get(0).getNombre(),"Pungui");
	}

	@Test
	public void testProfPersonaje2() {
		logicaPersonajes.setFiltro(filtroProfesion);
		List<Personaje> clientesBB = logicaPersonajes.getPersonajesConFiltro(Profesion.Granuja);

		assertEquals(clientesBB.get(1).getNombre(),"El Raton");
	}

	@Test
	public void testContieneNombreCant() {
		logicaPersonajes.setFiltro(filtroNombre);
		List<Personaje> clientesB = logicaPersonajes.getPersonajesConFiltro("El");

		assertEquals(clientesB.size(), 2);
	}

	@Test
	public void testContieneNombrePers1() {
		logicaPersonajes.setFiltro(filtroNombre);
		List<Personaje> clientesB = logicaPersonajes.getPersonajesConFiltro("Con");

		assertEquals(clientesB.get(0).getNombre(),"Conano");
	}

	@Test
	public void testMasCarosQue() {
		logicaPersonajes.setFiltro(filtroNivel);
		List<Personaje> clientesSaldo = logicaPersonajes.getPersonajesConFiltro(50);

		assertEquals(clientesSaldo.size(), 3);
	}



}
