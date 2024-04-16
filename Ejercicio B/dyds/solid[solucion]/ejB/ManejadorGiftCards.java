package dyds.solid.ejB;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase para manejar las giftcards 
*/

public class ManejadorGiftCards {

	private int ultimoCodigo;
    private ArrayList<Giftcard> listaGiftcardsOtorgadas;

    public ManejadorGiftCards() {
        listaGiftcardsOtorgadas = new ArrayList<>();
        ultimoCodigo = 1000;
    }

    public Giftcard generarGiftCard(Usuario usuario) {
        Giftcard nuevaGiftcard = new Giftcard(generarCodigo(), usuario);
        listaGiftcardsOtorgadas.add(nuevaGiftcard);
        return nuevaGiftcard;
    }

    private int generarCodigo() {
        ultimoCodigo++;
        return (new Random().nextInt(9000) + 1000)*10000 + ultimoCodigo;
    }
}