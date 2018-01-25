package disenios.multiton;

import java.util.HashMap;
import java.util.Random;

public class BackendServer {
    public static HashMap<Integer, BackendServer> serverPool =
            new HashMap<>();
    private String ServerName;
    private String IPAdress;

    private BackendServer(String serverName, String IPAdress){
        this.ServerName = serverName;
        this.IPAdress = IPAdress;
    }


    static {
        //En gerenal se usa para clases distintas pero se puede hacer para varias del mismo tipo.
        serverPool.put(1, new BackendServer("Server 1", "121.121.121.121"));
        serverPool.put(2, new BackendServer("Server 2", "121.125.129.122"));
        serverPool.put(3, new BackendServer("Server 3", "121.131.121.123"));
    }

    public void display(){
        System.out.println("Request received by backend "+ this.ServerName + " IPAdress " + this.IPAdress);
    }

    public String getServerName() {
        return ServerName;
    }

    //Recibe el nombre de la instancia que quiere.
    public static BackendServer getInstanceAvaible(String className){
        BackendServer backendServer = null;

        for (BackendServer backServer: serverPool.values()) {
            if (className.equalsIgnoreCase(backServer.getServerName())){
                backendServer = backServer;
            }
        }
        return backendServer;
    }


}
