package dyds.solid.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dyds.solid.ejA.*;


public class EjATest {
	private ManejadorDeChulogram manejadorChulogram;

	@Before
	public void setUp() throws Exception {
		manejadorChulogram = ManejadorDeChulogram.getInstanceChulogram();
	}

	@Test
	public void testBase() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		assertEquals(manejadorChulogram.getCantidadContenidosEnviados(), 0);
		manejadorChulogram.resetContenido();
	}

	@Test
	public void testContenidoInvalidoNulo() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido(null), manejadorChulogram);

		assertEquals(manejadorChulogram.getCantidadContenidosEnviados(), 0);
		manejadorChulogram.resetContenido();
	}

	@Test
	public void testContenidoInvalidoVacio() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido(""), manejadorChulogram);

		assertEquals(manejadorChulogram.getCantidadContenidosEnviados(), 0);
		manejadorChulogram.resetContenido();
	}

	@Test
	public void test1ContenidoReposteado() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji"), manejadorChulogram);

		assertEquals(manejadorChulogram.getCantidadContenidosEnviados(), 1);
		manejadorChulogram.resetContenido();
	}

	@Test
	public void test1ContenidoGuardado() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji"), manejadorChulogram);

		assertEquals(procesador.getRepo().getRepoSizeForTesting(), 1);
		manejadorChulogram.resetContenido();
	}

	@Test
	public void test2ContenidosReposteados() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji1"), manejadorChulogram);
		procesador.procesar(new Contenido("Emoji2"), manejadorChulogram);

		assertEquals(manejadorChulogram.getCantidadContenidosEnviados(), 2);
	}

	@Test
	public void test2ContenidosGuardados() {
		ProcesadorDeContenidosNuevos procesador =  new ProcesadorDeContenidosNuevos();
		procesador.procesar(new Contenido("Emoji1"), manejadorChulogram);
		procesador.procesar(new Contenido("Emoji2"), manejadorChulogram);

		assertEquals(procesador.getRepo().getRepoSizeForTesting(), 2);
		manejadorChulogram.resetContenido();
	}



}
