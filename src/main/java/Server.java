import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Properties;

public class Server {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7500);
        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client accept: " + (count++));
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream()); // можем отправлять строчки благодрая такой буфиризации
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream())); //(*)
            String request = reader.readLine();
            String response = "Считаю длину сообщения" + request.length() + "\n";
            writer.write(response);
            writer.flush(); // позволяет моментально отправлять сообщения

            writer.close();
            reader.close();
            clientSocket.close();
        }
    }
}
