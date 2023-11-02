package tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tdd.EncryptedMessage;

class DecryptionTests {
	
	@Test
	void zeroLengthMsgDecryption() {
		String msg = "";
		String key = "A";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}



	@Test
	void oneCharLengthMsgDecryption() {
		String msg = "C";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("C", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void manyCharLengthMsgDecryption() {
		String msg = "WXYZ";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("WXYZ", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	/* @Test void veryLargeCharLengthMsgDecryption() {
	 * 
	 * // I run out of memory when a create max string // char[] array = new
	 * char[2147483646];
	 * 
	 * // very large string char[] array = new char[2147483];
	 * 
	 * // assign the specified data value to each element Arrays.fill(array, 'B');
	 * // creating a constructor of the String class and parses an array into it
	 * String msg = new String(array); String key = "A";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);
	 * 
	 * // test decryption try { assertEquals(msg.toString(),
	 * encryptedMsg.decryptMessage(key)); } catch (Exception e) {
	 * fail("Unexpected exception."); e.printStackTrace(); } }
	 */
	
	@Test
	void nullMsgDecryption() {

		String msg = null;
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void zeroLengthKeyDecryption() {
		String msg = "ABC";
		String key = "";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void oneCharLengthKeyDecryption() {
		String msg = "ABC";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("ABC", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void manyCharLengthKeyDecryption() {
		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("ABC", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	 /* @Test void veryLargeCharLengthKeyDecryption() {
	 * 
	 * StringBuilder key = new StringBuilder(); for (int i = 1; i < 2147483; i++) {
	 * key.append('B'); } String msg = "ABC";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key.toString());
	 * 
	 * // test decryption try { assertEquals(msg.toString(),
	 * encryptedMsg.decryptMessage(key.toString())); } catch (Exception e) {
	 * fail("Unexpected exception."); e.printStackTrace(); } }
	 */

	
	@Test
	void nullKeyDecryption() {

		String msg = "ABC";
		String key = null;

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void msgLongerThanKeyDecryption() {

		String msg = "ABC";
		String key = "AB";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void msgShorterThanKeyDecryption() {

		String msg = "ABC";
		String key = "BCEFG";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	
	@Test
	void msgKeySameLengthDecryption() {

		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void upperCaseKeyDecryption() {

		String msg = "ABC";
		String key = "BCDEFG";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void lowercaseKeyDecryption() {

		String msg = "ABC";
		String key = "b";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void mixedCaseKeyDecryption() {

		String msg = "ABD";
		String key = "BbC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void numberKeyDecryption() {
		String msg = "ABC";
		String key = "12";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}



	@Test
	void punctuationKeyDecryption() {
		String msg = "ABC";
		String key = "#$%^";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void spaceKeyDecryption() {
		String msg = "ABC";
		String key = "      ";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void mixedCharKeyDecryption() {
		String msg = "ABC";
		String key = "AB2 (5)";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}
	


	@Test
	void upperCaseMsgDecryption() {

		String msg = "BCDEFG";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toString(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void lowercaseMsgDecryption() {

		String msg = "bcdefg";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toUpperCase(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseMsgDecryption() {

		String msg = "BcdeFg";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);

		// test decryption
		try {
			assertEquals(msg.toUpperCase(), encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void numberMsgDecryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void punctuationMsgDecryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void spaceMsgDecryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}
	

	@Test
	void mixedCharMsgDecryption() {
		String msg = "HE11O THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("HEOTHERE", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

	}


	@Test
	void upperCaseEncryptedMsgDecryption() {

		String msg = "CDEFGH";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void lowercaseEncryptedMsgDecryption() {

		String msg = "cdefgh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseEncryptedMsgDecryption() {

		String msg = "CdefGh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void numberEncryptedMsgDecryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void punctuationEncryptedMsgDecryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	@Test
	void spaceEncryptedMsgDecryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void mixedCharEncryptedMsgDecryption() {
		String msg = "HE110 THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.decryptMessage(key));
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void noChangeDecryption() {

		String msg = "BCDEFG";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void noRolloverDecryption() {

		String msg = "BCDEFG";
		String key = "C";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key.toString()));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void rolloverDecryption() {

		String msg = "XYZABC";
		String key = "CCCZZZ";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg,key);

		// test decryption
		try {
			assertEquals("XYZABC", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}
	
	
	@Test
	void decryptWithWrongKey() {

		String msg = "BCDEFG";
		String key = "CAB";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test decryption
		try {
			assertEquals("BCDEFG", encryptedMsg.decryptMessage(key));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
		
		// test wrong decryption that doesn't change
		try {
			assertEquals("DCEGFH", encryptedMsg.decryptMessage("A"));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

		// test wrong decryption that doesn't change
		try {
			assertEquals("CBDFEG", encryptedMsg.decryptMessage("B"));
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

	}
}
