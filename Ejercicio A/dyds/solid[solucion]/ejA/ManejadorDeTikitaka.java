package dyds.solid.ejA;

public class ManejadorDeTikitaka extends ManagerRedSocial {
    private static ManejadorDeTikitaka instance;
    private ManejadorDeTikitaka() {}

    public static ManejadorDeTikitaka getInstanceTikitaka() {
        if(instance == null) {
            instance = new ManejadorDeTikitaka();
        }
        return instance;
    }

    @Override
    public void postearContenido(Contenido contenido) {
        //Codigo dummy para hacer los tests
        cantidadContenidosEnviados++;
    }
}
