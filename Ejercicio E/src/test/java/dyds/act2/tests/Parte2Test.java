package dyds.act2.tests;

import dyds.act2.parte2.*;
import dyds.act2.tests.utils.StubbedLocalSource;
import dyds.act2.tests.utils.StubbedRemoteSource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Parte2Test {
	ClubLocalSource localSource;
	Manager manager;

	@Before
	public void setUp() throws Exception {
		// Arrange.
		localSource = new StubbedLocalSource();
		ClubRemoteSource remoteSource = new StubbedRemoteSource();
		ClubRepository repo = new ClubRepository(localSource, remoteSource);
		manager = new Manager(repo);
	}

	@Test
	public void testNonInLocalRepo() {
		assertEquals(null, localSource.getClub(1));
	}


	@Test
	public void testLocalRepoFetchAndStore() {
		Club a =  manager.get(1);
		assertNotEquals(null, localSource.getClub(1));
	}

	@Test
	public void testObjectFetchAndStore() {
		Club a =  manager.get(1);
		assertNotEquals(null, a);
	}

	@Test
	public void testObjectFieldsFetchAndStore() {
		Club a =  manager.get(2);
		assertEquals(a.getName(), "Stream Gold");
	}

	@Test
	public void testObjectFieldsFetchAndStore2() {
		Club a =  manager.get(1);
		assertEquals(a.getName(), "Nariz Seniors");
	}

	@Test
	public void testNonExistingElement() {
		Club b = manager.get(999);
		assertEquals(null, b);
	}

	@Test
	public void testOldRefetchedCopy() {
		Club oldClub = new Club(2, "Walking Club", "El Cubo", 1900);
		localSource.storeClub(oldClub);
		oldClub.setTimeStamp(0);

		Club c =  manager.get(2);

		assertEquals("Stream Gold",c.getName());
	}





}
