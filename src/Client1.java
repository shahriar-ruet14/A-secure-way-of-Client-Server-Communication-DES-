import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;



public class Client1 {
    public static int port = 9890;
	static String cipherText;
    static String requestedCipherText;
    public static  Socket clientSocket;
	static DataInputStream dataInputStream = null;
	static DataOutputStream dataOutputStream = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			print("Client1: Response From Client1\n");
			clientSocket = new Socket("localhost", port);
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			dataInputStream = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			
			
			/*localhost = Server IP address
			 * port address  is same as in Server port Address
			 * Port Address must remain unused by the system.
			 * 
			 */
			print("Client1: Connection Established....\n");
			
			
			while(true) {
	
			String acknowledgement =dataInputStream.readUTF();
			print("Client1: Acknowledgement: "+ acknowledgement);
			
			cipherText = message.messageProcessing(); //The whole process come from here
			
			//print("Client1: Final CipherText is to send : " +cipherText+ "\n");
			dataOutputStream.writeUTF(cipherText);	// Message send to Server
			
			if(cipherText.equals("Requested") == false) {

			String processAck = dataInputStream.readUTF();
			print("Client1: "+ processAck+"-----------> After Sending CipherText\n");
			
			}
			
			
			/*
			 * Receive CipherText Form server to Decryption the Data
			 */
			else {
			requestedCipherText = dataInputStream.readUTF();
			print("Client1>: ################ For Requested Data #########################\n" );
			print("\nCilent1: Recieved CipherText is: "+requestedCipherText+"\n");
			DecryptionDES.DESdecryption(requestedCipherText);
			
			}
			}
			
			
			

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void print(Object e)
	{
		System.out.println(e);
	}

}
