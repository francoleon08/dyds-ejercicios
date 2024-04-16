package dyds.solid.ejB;

import java.util.ArrayList;
import java.util.List;



public class SesionQuepasApp {

	private static SesionQuepasApp instance;

	private SesionQuepasApp() {
	}

	public static SesionQuepasApp getInstance() {
		if (instance == null) {
			instance = new SesionQuepasApp();
		}
		return instance;
	}

	private List<MensajeQuepasApp> queue = new ArrayList<MensajeQuepasApp>();

	public void cerrar() {
		// dummy
	}

	public void enviarMensaje(MensajeQuepasApp mensajeQuepasApp) {
		queue.add(mensajeQuepasApp);
	}

	//For testing
	public List<MensajeQuepasApp> getQueue() {
		return queue;
	}
	public void resetSingleton() {
		queue.clear();
	}
}
