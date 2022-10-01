import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main ( String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader= null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null; //waits for the request and connect to port number

        serverSocket = new ServerSocket(1234);

        while (true) {
            try{

                socket = serverSocket.accept();

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                while (true) {
                    String messageFromTheClient = bufferedReader.readLine();
                    System.out.println("Client: " + messageFromTheClient);
                    bufferedWriter.write("Message received!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (messageFromTheClient.equalsIgnoreCase("Bye"))
                        break;
                }
                //if the client says bye. We need to close all the resources the client was using
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
