package dyds.solid.ejB;

/**
 * Clase para manejar los mensajes
 */

public class ManejadorMensajes {


	public static void enviarMensaje(Usuario usuario, Giftcard giftcard) {
    String mensaje;
    SesionQuepasApp sesionQuepasApp =null;
	  try {
      sesionQuepasApp = SesionQuepasApp.getInstance();
      mensaje = componerMensajeAviso(giftcard);
      sesionQuepasApp.enviarMensaje(new MensajeQuepasApp().to(usuario.getContacto()).withBody(mensaje));
    } finally {
      if(sesionQuepasApp != null)
      sesionQuepasApp.cerrar();
    }
	}

  private static String componerMensajeAviso(Giftcard giftcard) {
    return "Gracias! por tu compra ganaste una Giftcard! reclamala con: " + giftcard.darCodigo();
  }
}
