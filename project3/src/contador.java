public class contador {
    private int valor;

    public contador() {
        valor = 0;
    }

    public int getContador() {
        return valor;
    }

    public void setContador(int val) {
        this.valor = val;
    }

    public void incrementar() {
        this.valor = valor + 1;
    }

    public void decrementar() {
        this.valor = valor - 1;
    }
}
