package dyds.solid.ejA;

public class ManejadorDeChulogram extends ManagerRedSocial{
	private static ManejadorDeChulogram instance;

	private ManejadorDeChulogram() {}

	public static ManejadorDeChulogram getInstanceChulogram() {
		if(instance == null){
			instance = new ManejadorDeChulogram();
		}
		return instance;
	}

	public void postearContenido(Contenido contenido) {
		//Codigo dummy para hacer los tests
		cantidadContenidosEnviados++;
	}
}
