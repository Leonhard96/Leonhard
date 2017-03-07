import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class reciverThread implements Runnable{
	
	
	
	 DatagramSocket clientSocket;
	 InetAddress IPAddress;
	 
	
	public reciverThread(DatagramSocket clientSocket,  InetAddress IPAddress){
		this.clientSocket = clientSocket;
		this.IPAddress = IPAddress;
	}

	@Override
	public void run() {
		while(true){
			 byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			try {
				clientSocket.receive(receivePacket);
				System.out.println("\nAntwort: ");
				String modifiedSentence = new String(receivePacket.getData());
				System.out.println(modifiedSentence);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		
	}

}
