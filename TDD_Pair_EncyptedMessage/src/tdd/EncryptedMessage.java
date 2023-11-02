/**
 * 
 */
package tdd;

import java.util.ArrayList;

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
		encryptMessage(message, key);
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

	/**
	 * A helper method that encrypts a message with a key, using Vigenere Cipher
	 * 
	 * @param message
	 * @param key
	 */
	private void encryptMessage(String message, String key)  {
		//set to upper (case is lost)
	  message = message.toUpperCase();
		
	  //break message and key into arraylists of characters
	  ArrayList<Character> messageChars = new ArrayList<Character>();
	  ArrayList<Character> keyChars = new ArrayList<Character>();
	  
	  //remove number and special characters from message
	  for (int i = 0; i < messageChars.size(); i++) {
	    if ((int)messageChars.get(i) < 65 || (int)messageChars.get(i) > 90) {
	      messageChars.remove(i);
	    }
	  }
	  
	  //remove number and special characters from message
	  for (int i = 0; i < keyChars.size(); i++) {
      if ((int)keyChars.get(i) < 65 || (int)keyChars.get(i) > 90) {
        keyChars.remove(i);
      }
    }
	  
	  //extend key to match message length if shorter than message
	  if (messageChars.size() > keyChars.size()) {
	    int i = 0;
	    while (messageChars.size() - keyChars.size() > 0) {
	      keyChars.add(keyChars.get(i));
	      i++;
	    }
	  }
	  
	  //loop through the key and message one by one
	  for (int i = 0; i < messageChars.size(); i++) {
	    //update each letter in the message by adding the ascii value of char from letter in message plus difference of letter from key minus 65 (A)
	    int temp = messageChars.get(i);
	    temp += ((int)keyChars.get(i) - 65);
	    messageChars.set(i, (char)temp);
	  }
	  
	  //condense encrypted message to string and return
	  for (char c : messageChars) {
	    mEncryptedMessage += c;
	  }

	}
}
