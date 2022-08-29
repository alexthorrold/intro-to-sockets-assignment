import java.net.*;

public class resolve {

    public static void main(String[] args) {
        // Prints error if user does not specify any names
        if (args.length < 1) {
            System.err.println("Usage: resolve <name1> <name2> ... <nameN>");
            return;
        }

        // Current address being processed during the loop
        InetAddress ia;

        // Loops through all names and writes the IPv4 address to console
        for (String s : args) {
            try {
                ia = InetAddress.getByName(s);

                String ip = ia.getHostAddress();
                System.out.println(s + " : " + ip);
            }
            // Writes unknown host to console if host server name can not be resolved
            catch (UnknownHostException e) {
                System.out.println(s + " : unknown host");
            }
        }
    }
}