package dyds.solid.ejB;

public class PremiosPorCompras {

    private ManejadorGiftCards manejadorGiftCards;

    public PremiosPorCompras(ManejadorGiftCards manejadorGiftCards) {
        this.manejadorGiftCards = manejadorGiftCards;
    }

    public void controlarCompra(Compra compra) {
        Usuario usuario = compra.darComprador();

        if(usuarioPremiado(usuario, compra)) {
            Giftcard nuevaGiftcard = manejadorGiftCards.generarGiftCard(usuario);
            ManejadorMensajes.enviarMensaje(usuario, nuevaGiftcard);
        }
    }

    private boolean usuarioPremiado(Usuario usuario, Compra compra) {
        return usuario.isGold() && compra.importe() > 50000;
    }
}