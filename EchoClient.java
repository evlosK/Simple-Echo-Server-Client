import java.io.*;
import java.net.*;

class EchoClient {
    public static void main(String args[]) throws Exception {
        // string to read message from input
        String sockin;
        //establish a connection
        try {
            Socket csock = new Socket(InetAddress.getLocalHost(), 2000);
            //takes input from terminal
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br_sock = new BufferedReader(new InputStreamReader(csock.getInputStream()));
            //sends output to socket
            PrintStream ps = new PrintStream(csock.getOutputStream());
            System.out.println("Start echoing... type 'end' to terminate");
            //keep reading until "end" is input
            while ((sockin = br.readLine()) != null) {
                ps.println(sockin);
                if (sockin.equals("end"))
                    break;
                else
                    System.out.println("Server:" + br_sock.readLine());

            }
        } catch (UnknownHostException e) {
            System.out.println(e.toString());

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}