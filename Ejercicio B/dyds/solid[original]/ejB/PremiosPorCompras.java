package dyds.solid.ejB;

import java.util.ArrayList;
import java.util.Random;

public class PremiosPorCompras {

    private int ultimoCodigo;
    private ArrayList<Giftcard> listaGiftcardsOtorgadas;

    public void controlarCompra(Compra compra) {
        Usuario usuario = compra.darComprador();
        if(compra.importe() > 50000 && usuario.isGold()) {
            ultimoCodigo++;
            int codigoGiftcard = (new Random().nextInt(9000) + 1000)*10000 + ultimoCodigo;
            Giftcard nuevaGiftcard = new Giftcard(codigoGiftcard, usuario);
            listaGiftcardsOtorgadas.add(nuevaGiftcard);
            SesionQuepasApp sesionQuepasApp =null;
            try {
				sesionQuepasApp = SesionQuepasApp.getInstance();
                String contactoUsuario = usuario.getContacto();
                String mensaje=this.componerMensajeAviso(nuevaGiftcard);
                sesionQuepasApp.enviarMensaje(new MensajeQuepasApp().to(contactoUsuario).withBody(mensaje));
            } finally {
            if(sesionQuepasApp !=null)
              sesionQuepasApp.cerrar();
            }
        }
    }
    private String componerMensajeAviso(Giftcard giftcard) {
       return "Gracias! por tu compra ganaste una Giftcard! reclamala con: " + giftcard.darCodigo();
    }
    public PremiosPorCompras() {
	    listaGiftcardsOtorgadas = new ArrayList<>();
	    ultimoCodigo = 1000;
    }
}
