import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String address = "127.0.0.1";
        int port = 4444;

        try {

            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Trying to connect to:" + address + port + "\n");

            Socket socket = new Socket(ipAddress, port);
            System.out.println("Connected!");

            OutputStream out = socket.getOutputStream();
            DataOutputStream data_out = new DataOutputStream(out);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = "";
            System.out.println("Type your message: ");

            while (true) {
                line = keyboard.readLine();
                System.out.println("Sending to server... \n");
                data_out.writeUTF(line);
                data_out.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
