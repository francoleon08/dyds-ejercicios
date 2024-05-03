package dyds.act2.parte1;

import dyds.act2.parte1.service.ServiceProvider;
import dyds.act2.parte1.utils.JsonResultProcessor;
import dyds.act2.parte1.utils.URLBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class SearchRequestHandler {

	private ServiceProvider serviceProvider;

	public SearchRequestHandler(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String[] executeHttpRequest(SearchQuery searchQuery) {
        String url = URLBuilder.buildUrl(searchQuery);
		String jsonResponse = sendHttpRequest(url);
		return JsonResultProcessor.processJsonResult(jsonResponse);
	}

	private String sendHttpRequest(String url) {
		String json = null;
		try {
			json = serviceProvider.resolveCall(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return json;
	}
}
