import java.io.PrintWriter;
import java.net.*;

public class SimpleServer {

    public static void main(String[] args) {
        try {
            // Sets up a new server socket on an available port
            ServerSocket ss = new ServerSocket(0);

            // Infinite loop to get connections from clients
            while (true) {
                int port = ss.getLocalPort();

                System.out.println("Listening on port " + port);

                Socket s = ss.accept();

                String name = s.getInetAddress().getHostName();
                String address = s.getInetAddress().getHostAddress();

                // Print writer to send output to client
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

                pw.println("Hello, " + name + ".");
                pw.println("Your IP address is " + address);
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
