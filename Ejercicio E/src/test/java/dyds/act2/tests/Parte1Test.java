package dyds.act2.tests;

import dyds.act2.parte1.*;
import dyds.act2.parte1.service.ServiceProvider;
import dyds.act2.tests.utils.StubbedServiceProvider;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Parte1Test {

	ServiceProvider serviceProvider;

	@Before
	public void setUp() throws Exception {
		//Using the stubbed version of the ServiceProvider, this is helpfull for testing stuff
		serviceProvider =  new StubbedServiceProvider();
	}

	@Test
	public void testBien() {
		// Arrange.
		SearchRequestHandler searchRequestHandler = new SearchRequestHandler(serviceProvider);
		SearchQuery searchQueryOk =  new SearchQuery(new SearchInfo("Baldurs Gate 3", "video-games"), new BaseURL("en.wikipedia.org"));
		
		// Act.
		String[] results = searchRequestHandler.executeHttpRequest(searchQueryOk);
		
		// Assert.
		assertEquals(3, results.length);
	}

	@Test
	public void testMalSearchInfo() {
		// Arrange.
		SearchRequestHandler searchRequestHandler = new SearchRequestHandler(serviceProvider);
		SearchQuery searchQueryNotOk =  new SearchQuery(new SearchInfo("Batman", "biology"), new BaseURL("en.wikipedia.org"));

		// Act.
		String[] results = searchRequestHandler.executeHttpRequest(searchQueryNotOk);

		// Assert.
		assertEquals(0, results.length);
	}

	@Test
	public void testMalServiceURL() {
		// Arrange.
		SearchRequestHandler searchRequestHandler = new SearchRequestHandler(serviceProvider);
		SearchQuery searchQueryBadURL =  new SearchQuery(new SearchInfo("Messi", "Football"), new BaseURL("www.wikinada.com"));

		// Act.
		String[] results = searchRequestHandler.executeHttpRequest(searchQueryBadURL);

		// Assert.
		assertEquals(0, results.length);
	}


}
