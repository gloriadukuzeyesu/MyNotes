import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Networking {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        Scanner keyBoard = new Scanner(System.in);
        String Firstline = keyBoard.nextLine();
        String messageFromClient = Firstline.split(" ")[1];
        messageFromClient = messageFromClient.substring(1);
        System.out.println("messageFromClient "+ messageFromClient);
        clientSocket.close();
        serverSocket.close();
    }
}

