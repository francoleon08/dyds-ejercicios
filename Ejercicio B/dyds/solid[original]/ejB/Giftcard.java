package dyds.solid.ejB;

public class Giftcard {
    int codigo;
    Usuario beneficiario;


    public Giftcard(int codigo, Usuario beneficiario) {
        this.codigo = codigo;
        this.beneficiario = beneficiario;
    }

    public int darCodigo() {
        return codigo;
    }
}
