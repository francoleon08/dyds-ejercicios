package dyds.act2.tests.utils;

import dyds.act2.parte2.Club;
import dyds.act2.parte2.ClubLocalSource;

import java.util.HashMap;
import java.util.Map;

public class StubbedLocalSource implements ClubLocalSource {
    private Map<Integer, Club> albums =  new HashMap<Integer, Club>();
    @Override
    public void storeClub(Club a) {
        if(a != null) {
            a.setTimeStamp(System.currentTimeMillis());
            albums.put(a.getId(), a);
        }
    }

    @Override
    public Club getClub(int id) {
        return albums.get(id);
    }
}
