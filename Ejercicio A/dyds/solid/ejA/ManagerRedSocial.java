package dyds.solid.ejA;

public abstract class ManagerRedSocial {
    int cantidadContenidosEnviados = 0;


    public abstract void postearContenido(Contenido contenido);

    public int getCantidadContenidosEnviados() {
        return cantidadContenidosEnviados;
    }

    public void resetContenido() {
        cantidadContenidosEnviados = 0;
    }
}
