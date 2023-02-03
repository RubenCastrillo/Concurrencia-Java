// Para lanzar hilos se hace dsede objetos que se heredan de Thread
// start() se lanzan los hilos
// los hilos no se tienen que ejecutar cuando se lanzan
// no sabemos el orden de ejecucion de los hilos
public class App extends Thread {
    private int id;

    public App(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Soy el hilo " + id);
    }

    public static void main(String[] args) {
        App h1 = new App(1);
        App h2 = new App(2);
        App h3 = new App(3);

        h1.start();// Se crea un nuevo hilo
        h2.start();// Se crea un nuevo hilo
        h3.start();// Se crea un nuevo hilo

        System.out.println("Soy el hilo principal");
    }
}
