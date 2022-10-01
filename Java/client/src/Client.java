import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket socket = null;
        InputStreamReader inputStreamReader = null; // reads in bytes to character
        OutputStreamWriter outputStreamWriter = null; // send message to the server
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;


        // writes many things at the time

        try {
            socket = new Socket ( "localhost", 1234);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            //wrap the read and writer with buffered reader to improve efficiency
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            // use scanner to read things from the console
            Scanner scanner = new Scanner(System.in);  // system in allows take in input from the user or keyboard

            while (true) {

                String messageToSendToSever = scanner.nextLine();
                bufferedWriter.write(messageToSendToSever);
                bufferedWriter.newLine();
                bufferedWriter.flush(); // flush when a message is the buffer

                System.out.println(" Server: " + bufferedReader.readLine()); // read the response from the server

                if (messageToSendToSever.equalsIgnoreCase("BYE"))
                    break; // if the msg from server is bye, break out of the while loop

            }

        } catch (IOException e) {
            System.out.println("failed to connect");
        } finally {
            try {
                if (socket != null)
                    socket.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (outputStreamWriter != null)
                    outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}