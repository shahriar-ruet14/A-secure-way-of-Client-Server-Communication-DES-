import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class EncryptionDES {
	
	
	
	static Cipher cipher;
	/*
	 * AES Encryption is done in here using library function
	 */
	
	public static String  DESencrypt(String plainText) throws Exception {
		
		print("Client1>Message>EncryptionAES> : DES Initializing....\n");		

		SecretKey secretKey = KeyStatic.key(); //Generate key for the very first time of a communication 
		
		cipher = Cipher.getInstance("DES");
		
		print(("Cilent>message>Encryption>> : Final Plain Text is:"+ plainText));
		
		long tic = System.nanoTime(); //Time Stamp 
		String cipherText = encrypt(plainText,secretKey);
		long toc = System.nanoTime(); //final time
		long elapsedTime = toc - tic;
		System.out.println("\nEnCryptionDES: Elapsed Time : "+ elapsedTime+ " ns\n \t \t \t OR " 
		+ elapsedTime/1000000000+" Seconds");
		System.out.println("\nClient1> message>EncriptionDES>> : Generated CipherText : " + cipherText);
		
		
		
		/*String decryptedText = decrypt(cipherText, secretKey);
		System.out.println("\nClient1> message>EncriptionDES>> :Encrypted Text: " + decryptedText);
		
		
		
		SecretKey secretKey23 = KeyStatic.key();
		//SecretKey secretKey2 = KeyStatic.key();	
		
		
		
		print("\n\n\n\nfor test in encryption ####################################\n");
		String decryptedText23 = decrypt(cipherText, secretKey23);
		System.out.println("EcnAES:  Decrypted Text testing : " + decryptedText23);
		
		*/
		
		return cipherText;
		
		
	}
	
	
	
	public static String encrypt(String plainText, SecretKey secretKey)
			throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE,  secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}
	
	
/*	public static String decrypt(String encryptedText, SecretKey secretKey)
			throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}
	
	*/
	
	public static void print(Object e)
	{
		System.out.println(e);
	}
	
	

}
