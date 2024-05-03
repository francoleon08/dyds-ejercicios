package dyds.act2.parte1.utils;

import com.google.gson.Gson;
import dyds.act2.parte1.PagesResult;

public class JsonResultProcessor {

    public static String[] processJsonResult(String json) {
        String[] jsonResult = new String[0];
        if (json != null) {
            Gson gson = new Gson();
            PagesResult addUserPagesResult = gson.fromJson(json, PagesResult.class);
            jsonResult = addUserPagesResult.getPages();
        }
        return jsonResult;
    }
}
