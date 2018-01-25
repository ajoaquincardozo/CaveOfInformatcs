package pruebas;

import disenios.multiton.BackendServer;

import java.util.Random;

public class PruebaMultiton {
    private static final Random random = new Random();
    private static final String[] servers = {"Server 1","Server 2","Server 3"};

    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            int numberServer = random.nextInt(3);
            BackendServer backendServer = BackendServer.getInstanceAvaible(servers[numberServer]);
            backendServer.display();
        }
    }
}
