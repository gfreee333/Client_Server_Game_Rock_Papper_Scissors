import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 7500);

        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream()); // можем отправлять строчки благодрая такой буфиризации
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //(*)
        writer.write("get info: \n");
        writer.flush(); // позволяет моментально отправлять сообщения

        // (*) считывания сообщений из сокета сервера.?
        String message = reader.readLine();
        System.out.println(message);

        clientSocket.close();
        reader.close();
        writer.close();
    }
}
