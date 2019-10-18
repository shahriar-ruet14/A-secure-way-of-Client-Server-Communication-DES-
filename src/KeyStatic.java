import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyStatic {
	static SecretKey secretKeystaticKey = null,secretKey = null;
	static int flag =0;
	public static SecretKey key () throws Exception {
		// TODO Auto-generated method stub
		
		
		if(flag ==0) {
		
			flag++;
			
			// secretKey = keyStatic();
			
			long tic = System.nanoTime(); //timestamp to measure time 
				 secretKey =KeyGenerator.getInstance("DES").generateKey();
				 //System.out.println("\n\n\nNew genrated: flag : "+flag+"\n");
			long toc = System.nanoTime(); //timestamp
			long elapsedTime = toc- tic; //Elapsed Time
			System.out.println("\nKey Generation Elapsed Time : "+ elapsedTime +" ns \n\t\t\tOR "
					+ elapsedTime/1000000000+" Seconds");
		}
		else {
			flag++;
			// System.out.println("Skipped: "+flag+"\n");

		}

	secretKeystaticKey = secretKey;
	return secretKeystaticKey;
			
	}
	

}
