package dyds.solid.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dyds.solid.ejA.*;


public class EjATest {
	@Before
	public void setUp() throws Exception {
		ManejadorDeChulogram.getInstance().resetSingleton();
	}

	@Test
	public void testBase() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		assertEquals(ManejadorDeChulogram.getInstance().getCantidadContenidosEnviados(), 0);
	}

	@Test
	public void testContenidoInvalidoNulo() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido(null));

		assertEquals(ManejadorDeChulogram.getInstance().getCantidadContenidosEnviados(), 0);
	}

	@Test
	public void testContenidoInvalidoVacio() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido(""));

		assertEquals(ManejadorDeChulogram.getInstance().getCantidadContenidosEnviados(), 0);
	}

	@Test
	public void test1ContenidoReposteado() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji"));

		assertEquals(ManejadorDeChulogram.getInstance().getCantidadContenidosEnviados(), 1);
	}

	@Test
	public void test1ContenidoGuardado() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji"));

		assertEquals(procesador.getRepo().getRepoSizeForTesting(), 1);
	}

	@Test
	public void test2ContenidosReposteados() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji1"));
		procesador.procesar(new Contenido("Emoji2"));

		assertEquals(ManejadorDeChulogram.getInstance().getCantidadContenidosEnviados(), 2);
	}

	@Test
	public void test2ContenidosGuardados() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji1"));
		procesador.procesar(new Contenido("Emoji2"));

		assertEquals(procesador.getRepo().getRepoSizeForTesting(), 2);
	}



}
