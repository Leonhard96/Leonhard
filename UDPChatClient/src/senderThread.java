import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class senderThread implements Runnable{
	
	 DatagramSocket clientSocket;
	 InetAddress IPAddress;
	 
	public senderThread(DatagramSocket clientSocket,  InetAddress IPAddress){
		this.clientSocket = clientSocket;
		this.IPAddress = IPAddress;
	}

	@Override
	public void run() {	
		while(true){
			 BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			 try {
				String sentence = inFromUser.readLine();
				 byte[] sendData = new byte[1024];
				sendData = sentence.getBytes();
			    clientSocket.send(new DatagramPacket(sendData, sendData.length, IPAddress, 9876));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
