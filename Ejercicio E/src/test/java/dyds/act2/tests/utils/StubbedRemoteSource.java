package dyds.act2.tests.utils;

import dyds.act2.parte2.Club;
import dyds.act2.parte2.ClubRemoteSource;

public class StubbedRemoteSource implements ClubRemoteSource {
    @Override
    public Club get(int id) {
        switch(id) {
            case 1 : return new Club(1, "Nariz Seniors", "Chocolatera", 1912);
            case 2 : return new Club(2, "Stream Gold", "Gran Monumento", 1911);
        }
        return null;
    }
}
