import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.NoSuchPaddingException;





public class message {
	
	
	 static String cipherText;
	 static String plainText;
	

	public static String messageProcessing() throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		/*int x;
		System.out.println("Client>message : Enter your Response....\n");
		x = scanner.nextInt();
		*/
		
		int x=1;		 //This will Omit
		int requestStatus;
		switch(x)
		{
		case 1:
					
			print("##########################	DES	  ##############################");
			print("Client> message: Enter 1  for Encrypt and send");
			print("Client> message: Enter 0 for Recieve and Decrypt");
			//print("################################################################\n");
			requestStatus = scanner.nextInt();
			
			if(requestStatus != 0) {
				 print("Client(message): Give data in here....\n");	
				
				 
				 //plainText = scanner.nextLine().toString();
				 //plainText = "Shahriar Mahmud:> This message can also be"
				 	//	+ "\n \t \t taken in another read message format";
				 plainText = "Shahriar Mahmud:> This message can also be taken in another read message format. smaple text is here:"
					 		+ "***********Cryptography or cryptology is the practice and study of techniques for secure communication "
					 		+ "in the presence of third parties called adversaries";
				 print("Client1>Message: Input Text is :"+plainText+"\n" );
				 
				 int plainTextlength = plainText.length(); //Messure input String Lenght
				 print("\nClient1>Message: Input Text Size is: " + plainTextlength+" bytes" );
				 
			/*
			 * Here the input message will passed for AES encryption
			 */
				 			 
			 try {
				 cipherText =  EncryptionDES.DESencrypt(plainText);
			
			 
			 } catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				print("client>message: DES algorithm exception\n");
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				print("client>message: DES padding exception\n");

			}
			}
			 else {
				 cipherText = "Requested"; //Requested for --> Client1 requests data From Server 
				 								 
			 }
			break;
			
					
		
		
		
	}
		return cipherText;
		
			 
	
		}
		
		
	
	
	
	public static void print(Object e)
	{
		System.out.println(e);
	}

	
		
}