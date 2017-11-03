import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket listener = new ServerSocket(4444);
            System.out.println("Listener started successfully! Waiting for client...\n");

            Socket socket = listener.accept();
            System.out.println("Client connected\n");

            InputStream in = socket.getInputStream();
            DataInputStream data_in = new DataInputStream(in);

            String line = "";
            while (true){
                line = data_in.readUTF();
                System.out.println("We have a message: " + line);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
