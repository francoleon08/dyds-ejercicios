package dyds.solid.tests;

import dyds.solid.ejC.*;
import dyds.solid.ejC.Filtro;
import dyds.solid.ejC.seleccionador.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EjCTest {

	Filtro filtro;
	Seleccionador seleccionador;
	LogicaPersonajes logicaPersonajes;
	List<Personaje> personajes;

	@BeforeEach
	public void setUp() throws Exception {
		filtro = new Filtro();

		personajes = new ArrayList<Personaje>();

		Personaje personajeA = new Personaje("Pungui", Profesion.Granuja, 500, 5);
		Personaje personajeB = new Personaje("Conano", Profesion.Campeon, 20, 50);
		Personaje personajeC = new Personaje("El Magias", Profesion.Mago, 200, 10);
		Personaje personajeD = new Personaje("El Raton", Profesion.Granuja, 750, 15);

		personajes.add(personajeA);
		personajes.add(personajeB);
		personajes.add(personajeC);
		personajes.add(personajeD);

		logicaPersonajes = new LogicaPersonajes(personajes);
	}

	@Test
	public void testProfesionesCant() {
		seleccionador = new SeleccionadorPorProfesion(Profesion.Granuja);
		List<Personaje> clientesBB = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);
		
		assertEquals(clientesBB.size(), 2);
	}

	@Test
	public void testProfPersonaje1() {
		seleccionador = new SeleccionadorPorProfesion(Profesion.Granuja);
		List<Personaje> clientesBB = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);

		assertEquals(clientesBB.get(0).getNombre(),"Pungui");
	}

	@Test
	public void testProfPersonaje2() {
		seleccionador = new SeleccionadorPorProfesion(Profesion.Granuja);
		List<Personaje> clientesBB = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);

		assertEquals(clientesBB.get(1).getNombre(),"El Raton");
	}

	@Test
	public void testContieneNombreCant() {
		seleccionador = new SeleccionadorPorNombre("El");
		List<Personaje> clientesB = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);

		assertEquals(clientesB.size(), 2);
	}

	@Test
	public void testContieneNombrePers1() {
		seleccionador = new SeleccionadorPorNombre("Con");
		List<Personaje> clientesB = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);

		assertEquals(clientesB.get(0).getNombre(),"Conano");
	}

	@Test
	public void testMasCarosQue() {
		seleccionador = new SeleccionadorPorNivelMayorA(50);
		List<Personaje> clientesSaldo = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);

		assertEquals(clientesSaldo.size(), 3);
	}

	@Test
	public void testNombreYProfesion() {
		seleccionador = new SeleccionadorPorNivelYProfesion(500, Profesion.Granuja);
		List<Personaje> clientesSaldo = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionador);

		assertEquals(clientesSaldo.size(), 1);
	}


}
