import java.io.*;
import java.net.*;

class EchoServer {
    public static void main(String args[]) throws Exception {
        // declare variable and initialize socket
        String echoin;
        ServerSocket svrsoc;
        Socket soc;
        BufferedReader br;
        // start server and wait for connection
        try {
            svrsoc = new ServerSocket(2000);
            soc = svrsoc.accept();
            System.out.println("Server Started");
            System.out.println("Waiting for a client....");
            // takes input from client socket
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintStream ps = new PrintStream(soc.getOutputStream());
            System.out.println("Connected for echo:");
            // reads message from client until "end" is sent
            while ((echoin = br.readLine()) != null) {
                if (echoin.equals("end")) {
                    // close connection
                    System.out.println("Client disconnected");
                    br.close();
                    break;
                } else
                    ps.println(echoin);
            }
        } catch (UnknownHostException e) {
            System.out.println(e.toString());
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}