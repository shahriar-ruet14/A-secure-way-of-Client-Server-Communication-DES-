import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
	
	
	
	public static  int port =9890;
	public static String cipherText = null;
	static DataInputStream dataInputStream = null;
	static DataOutputStream dataOutputStream = null;
	static Socket socket = null;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		/*Create Server - Client Connection
		 * 
		 */
		
		
		try {
		System.out.println("Server: Server Started....\n"
				+ "Server: Waiting for CLient....\n");
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(port);
		/* Response from Client
		 * port address is 9888 is same as in Client port Address
		 * Port Address must remain unused by the system.
		 * 
		 */
		 socket = serverSocket.accept();
		System.out.println("Server: Connenction Establish....\n");
		}
		catch (Exception e) {
			System.out.println("Server: Error in Creating Connection....\n");
		}
		//Creating 2 stream for Client Server Communication
		dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		
		
		while(true) {
		
        dataOutputStream.writeUTF("Handshahke From Server");
       
		cipherText = dataInputStream.readUTF(); //getting the cipherText from Client
		
		System.out.println("Server: Recieved Data is :  " + cipherText+ "\n");
		
		
		if(cipherText.equals("Requested") == false){
		try {
			
			File file = new File("Database.txt");
			FileWriter fileWriter = new FileWriter(file);
			print("Server: Encryptrd data size is :"+ cipherText.length()+"bytes" );
			fileWriter.write(cipherText);
			fileWriter.flush();
			fileWriter.close();
			dataOutputStream.writeUTF("Server: Message stored ");
				
			
		} catch (Exception e) {
		
			System.out.println("Server: Exception in server file creation site\n");
		}
		}
		else {
			
			
			/*
			 * To read database File
			 */
			
			InputStream is = new FileInputStream("Database.txt");
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is)); 
			String line = bufferedReader.readLine(); 
			StringBuilder stringBuilder = new StringBuilder();
			while(line != null)
			{ 
				stringBuilder.append(line);
				line = bufferedReader.readLine(); 
			} 
			String requestedCipherText = stringBuilder.toString();	
			
			System.out.println("Server: Requested CipherText is: "+requestedCipherText+"\n");
			dataOutputStream.writeUTF(requestedCipherText);
			/*
			 * Here requested message send to the Client
			 */
			
			
			
		}
		
		
		}
		
		
	}
	
	public static void print(Object e)
	{
		System.out.println(e);
	}
	
}

