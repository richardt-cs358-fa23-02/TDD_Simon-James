/*
 * 
 */
package tdd;

import java.util.ArrayList;

/**
 * @author Simon and James
 *
 */
public class EncryptedMessage {

	private String mEncryptedMessage;
	/**
	 * @throws Exception 
	 * 
	 */
	public EncryptedMessage(String message, String key){
		// TODO Auto-generated constructor stub
	     if(validate(key)) {
		    encryptMessage(message, key);
	     }else {
	       mEncryptedMessage = null;
	     }
	}
	
	public EncryptedMessage(String encryptedMessage) {
		// TODO Auto-generated constructor stub
	  
	  mEncryptedMessage = encryptedMessage.toUpperCase();

	}
	
	public String getMessage() throws Exception {
		if(!validate(mEncryptedMessage)) {
		  throw new Exception("Unauthorized use.");
		}else {
		  return mEncryptedMessage;
		}
	};
	
	public String decryptMessage(String key) throws Exception {
		if(!validate(key) || !validate(mEncryptedMessage)) {
		  throw new Exception("Unauthorized use.");
		}
		key = key.toUpperCase();
		//string to hold the decrypted message
		String decryptedMessage = "";
	//break message and key into arraylists of characters
    ArrayList<Character> messageChars = new ArrayList<Character>();
    ArrayList<Character> keyChars = new ArrayList<Character>();
    
    //fill messageChars from mEncryptedMessage
    for (int i = 0; i < mEncryptedMessage.length();i++) {
      //skip nonalpabetic characters
      if(mEncryptedMessage.charAt(i) >= 'A' && mEncryptedMessage.charAt(i) <= 'Z') {
        messageChars.add(mEncryptedMessage.charAt(i));
      }
    }
    
    //fill keyChars from key
    for (int i = 0;i < key.length(); i++) {
      //skip nonalphabetic characters
      if(key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') {
      keyChars.add(key.charAt(i));
      }
    }
    //loop through the key and message one by one
    for (int i = 0; i < messageChars.size(); i++) {
      //update each letter in the message by adding the ascii value of char from letter in message plus difference of letter from key minus 65 (A)
     
     
      messageChars.set(i, (char)((messageChars.get(i) - (keyChars.get(i%keyChars.size()) - 'A'))) );
     //rollover
      if(messageChars.get(i) < 'A') {
        messageChars.set(i, (char)(messageChars.get(i)+26));
      }
    }
    
    //condense and save encrypted message to string
    for (char c : messageChars) {
      decryptedMessage += c;
    }
    //return the message decrypted
		return decryptedMessage;
	}
	
	private Boolean validate(String data) {
		boolean valid = false;
		int invalid = 0;
		if(data != null && data.length() != 0) {
  	  for(int i = 0;i < data.length();i++) {
  		  if(data.charAt(i) < 'A' || data.charAt(i) > 'z') {
  		    invalid++;
  		  }
  		}
  	  if(invalid == 0) {
  	    valid = true;
  	  }	
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
	  if(message != null) {
	    mEncryptedMessage = "";
	    message = message.toUpperCase();
	    key = key.toUpperCase();
	    //break message and key into arraylists of characters
	    ArrayList<Character> messageChars = new ArrayList<Character>();
	    ArrayList<Character> keyChars = new ArrayList<Character>();
	    
	    //fill messageChars from message
	    for (int i = 0; i < message.length();i++) {
	      //skip nonalpabetic characters
	      if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
	        messageChars.add(message.charAt(i));
	      }
	    }
	    
	    //fill keyChars from key
	    for (int i = 0;i < key.length(); i++) {
	      //skip nonalphabetic characters
	      if(key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') {
	      keyChars.add(key.charAt(i));
	      }
	    }
	    
	    //loop through the key and message one by one
	    for (int i = 0; i < messageChars.size(); i++) {
	      //update each letter in the message by adding the ascii value of char from letter in message plus difference of letter from key minus 65 (A)
	     
	     
	      messageChars.set(i, (char)((messageChars.get(i) + (keyChars.get(i%keyChars.size()) - 'A'))) );
	     //rollover
	      if(messageChars.get(i) > 'Z') {
	        messageChars.set(i, (char)(messageChars.get(i)-26));
	      }
	    }
	    
	    //condense and save encrypted message to string
	    for (char c : messageChars) {
	      mEncryptedMessage += c;
	    }
	  }
	}
}