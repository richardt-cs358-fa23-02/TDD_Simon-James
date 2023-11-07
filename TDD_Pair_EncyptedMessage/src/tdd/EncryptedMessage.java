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

	private String mEncryptedMessage = "";
	/**
	 * @throws Exception 
	 * 
	 */
	public EncryptedMessage(String message, String key) throws Exception{
		// TODO Auto-generated constructor stub
	     if(validate(message) && validate(key)) {
		    encryptMessage(message, key);
	     } else {
	       throw new Exception("Unauthorized use.");
	     }
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
		boolean valid = false;
		int invalid = 0;
		data.toUpperCase();
	  for(int i = 0;i < data.length();i++) {
		  if(data.charAt(i) < 'A' || data.charAt(i) > 'Z') {
		    invalid++;
		  }
		}
	  if(invalid == 0) {
	    valid = true;
	  }
	  return valid;
	}

	/**
	 * A helper method that encrypts a message with a key, using Vigenere Cipher
	 * 
	 * @param message
	 * @param key
	 */
	private void encryptMessage(String message, String key)  {
		//set to upper (case is lost)
	  if (message != null) {	    
	    message = message.toUpperCase();
	    key = key.toUpperCase();
	    //break message and key into arraylists of characters
	    ArrayList<Character> messageChars = new ArrayList<Character>();
	    ArrayList<Character> keyChars = new ArrayList<Character>();
	    
	    //fill messageChars from message
	    for (int i = 0; i < message.length();i++) {
	      messageChars.add(message.charAt(i));
	    }
	    
	    //fill keyChars from key
	    for (int i = 0;i < key.length(); i++)) {
	      keyChars.add(key.charAt(i));
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
	     
	      messageChars.set(i, (char)(messageChars.get(i) + keyChars.get(i) - 'A') );
	      System.out.print(messageChars.get(i));
	    }
	    
	    //condense encrypted message to string and return
	    for (char c : messageChars) {
	      mEncryptedMessage += c;
	    }
	  }
	}
}
