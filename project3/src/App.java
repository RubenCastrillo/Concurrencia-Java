import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        int contador = 0;
        int numHilos;
        if (args.length == 1) {
            numHilos = Integer.parseInt(args[0]);
        } else {
            Scanner reader = new Scanner(System.in);
            System.out.println("introduce el numero de hilos");
            numHilos = reader.nextInt();
        }

        List<Thread> listHilos = new ArrayList<Thread>(numHilos);

        worker w = new worker();
        // Inicializa el array de hilos
        for (int i = 0; i < numHilos; i++) {
            Thread th = new Thread(w);
            listHilos.add(th);
        }
        // Inicias cada hilo
        for (int i = 0; i < numHilos; i++) {
            listHilos.get(i).start();
        }

        // interrumpimos hilos tras breve pausa
        for (int i = 0; i < numHilos; i++) {
            try {
                Thread.sleep((int) Math.rint(Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Hubo un error");
            }
            listHilos.get(i).interrupt();
        }

        // esperamos a que finalice
        for (int i = 0; i < numHilos; i++) {
            Thread h = listHilos.get(i);
            try {
                h.join(100);
            } catch (InterruptedException e) {
                System.out.println("Hubo un error");
            }
        }

        System.out.println("Programa inalizado");
    }
}
