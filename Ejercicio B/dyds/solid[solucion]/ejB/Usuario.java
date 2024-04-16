package dyds.solid.ejB;

public class Usuario {
    private String contacto;
    private boolean gold;

    public String getContacto() {
        return contacto;
    }

    public Usuario() {
        contacto = "dummy@quepasapp";
    }

    public Usuario(boolean gold) {
        this.gold = gold;
        contacto = "dummy@quepasapp";
    }

    public boolean isGold() {
        return gold;
    }
}
