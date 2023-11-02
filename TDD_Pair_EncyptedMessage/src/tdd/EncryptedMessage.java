/**
 * 
 */
package tdd;

/**
 * @author TBD
 *
 */
public class EncryptedMessage {

	private String mEncryptedMessage;
	/**
	 * @throws Exception 
	 * 
	 */
	public EncryptedMessage(String message, String key) {
		// TODO Auto-generated constructor stub
		
	}
	
	public EncryptedMessage(String encryptedMessage) {
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() throws Exception {
		//throw new Exception("Unauthorized use.");
		return mEncryptedMessage;
	};
	
	public String decryptMessage(String key) throws Exception {
		//throw new Exception("Unauthorized use.");
		return "";
	}
	
	private Boolean validate(String data) {
		return false;
	}

	private void encryptMessage(String message, String key)  {
		
	}
}
