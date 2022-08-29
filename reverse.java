import java.net.*;

public class reverse {

    public static void main(String[] args) {
        // Prints error if user does not specify any ip addresses
        if (args.length < 1) {
            System.err.println("Usage: reverse <ip1> <ip2> ... <ipN>");
            return;
        }

        // Current address being processed during the loop
        InetAddress ia;

        // Loops through all addresses and writes the host name to console
        for (String s : args) {
            try {
                ia = InetAddress.getByName(s);

                String ip = ia.getHostName();

                // Checks if a DNS name exists for the given address
                if (s.compareTo(ip) != 0) {
                    System.out.println(s + " : " + ip);
                }
                else {
                    System.out.println(s + " : no name");
                }
            }
            // Writes unknown host to console if host server name can not be resolved
            catch (UnknownHostException e) {
                System.out.println(s + " : " + "unknown host");
            }
        }
    }
}