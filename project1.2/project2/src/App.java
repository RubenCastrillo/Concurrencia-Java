public class App extends Thread {
    private int id;

    public App(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Soy el hilo: " + id);
    }

    public static void main(String[] args) throws Exception {

        App[] vec = new App[5];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = new App(i);
            vec[i].start();
        }

        // La funcion join sirve para que el main espere a que acabe un hilo determinado
        try {
            // for (int i = 0; i < vec.length; i++) {
            // vec[i].join();
            // }
            vec[0].join();
        } catch (Exception ex) {

        }
        System.out.println("Soy el hilo principal");
    }
}
