import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Main {

	public static void main(String[] args) throws IOException {
			      DatagramSocket clientSocket = new DatagramSocket();
			      InetAddress IPAddress = InetAddress.getByName("localhost");
				  new Thread(new reciverThread(clientSocket, IPAddress)).start();
				  new Thread(new senderThread(clientSocket, IPAddress)).start();
			     
	}

}
