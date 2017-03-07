import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class MainServer {
	
	
	
public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	DatagramSocket serverSocket = new DatagramSocket(9876);
	
    
    InetAddress ipArray[] = new InetAddress[100];
    int portArray[] = new int[100];
    int counter = 0;
    boolean addIP = true;
    boolean sendMessage = true;
	
	 while(true)
     {
		 byte[] receiveData = new byte[1024];
		 byte[] sendData = new byte[1024];
		 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         String sentence = new String(receivePacket.getData());
         
         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();
         for(int i = 0; i < counter; i++){
        	 if(ipArray[i].equals(IPAddress)){
        		 if(portArray[i] == port){
        			 addIP = false; 
        		 }
             }
         }
         
         if(addIP){
        	 ipArray[counter] = IPAddress;
             portArray[counter] = port;
             counter ++;
         }
         
         sendData = sentence.getBytes();
        System.out.println("\n");
         for(int i = 0; i < counter; i++){
        	 if(!(ipArray[i].equals(IPAddress)) || (ipArray[i].equals(IPAddress) && portArray[i] != port)){
        		 if(portArray[i] != port){
        			 System.out.println("Senden an: "+ipArray[i]+" Port: "+portArray[i]);
        			 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipArray[i], portArray[i]);
                     serverSocket.send(sendPacket);
        		 }
             }
            
         } 
      }
      
     }
		
}


