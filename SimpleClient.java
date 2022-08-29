import java.io.*;
import java.net.*;

public class SimpleClient {

    public static void main(String[] args) {
        // Prints error if name and port arguments exclusively are not given
        if (args.length != 2) {
            System.err.println("Usage: SimpleClient <name> <port>");
            return;
        }

        // Address of the server
        InetAddress ia;

        try {
            ia = InetAddress.getByName(args[0]);
        }
        catch (UnknownHostException e) {
            System.err.println("Unknown name for ip");
            return;
        }

        // Socket to connect to the server
        Socket s;

        try {
            s = new Socket(ia, Integer.parseInt(args[1]));

            // Buffered reader to read output from server
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String line1 = br.readLine();
            String line2 = br.readLine();

            System.out.println(line1);
            System.out.println(line2);

            s.close();
        }
        catch (IOException e) {
            System.err.println("IO Exception" + e);
        }
    }
}
