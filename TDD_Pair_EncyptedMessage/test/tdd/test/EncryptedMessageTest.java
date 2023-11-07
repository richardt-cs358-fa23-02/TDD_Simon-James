/**
 * 
 */
package tdd.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import tdd.EncryptedMessage;

/**
 * 
 * Tests using isolated test cases for every case
 * 
 * @author Jocelyn Richardt
 *
 */
class EncryptedMessageTest {

	@Test
	void zeroLengthMsgEncryption() {
		String msg = "";
		String key = "A";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}
	@Test
	void oneCharLengthMsgEncryption() {
		String msg = "C";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("C", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void manyCharLengthMsgEncryption() {
		String msg = "WXYZ";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("WXYZ", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}
	/*
	 * @Test void veryLargeCharLengthMsgEncryption() {
	 * 
	 * // I run out of memory when a create max string StringBuilder msg = new
	 * StringBuilder(); for (int i = 1; i < 2147483; i++) { msg.append('B'); }
	 * String key = "A";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg.toString(), key);
	 * 
	 * // test getMessage try { assertEquals(msg.toString(),
	 * encryptedMsg.getMessage()); } catch (Exception e) {
	 * fail("Unexpected exception."); e.printStackTrace(); } }
	 * 
	 */
	@Test
	void nullMsgEncryption() {

		String msg = null;
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());
	}

	
	@Test
	void zeroLengthKeyEncryption() {
		String msg = "ABC";
		String key = "";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void oneCharLengthKeyEncryption() {
		String msg = "ABC";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BCD", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void manyCharLengthKeyEncryption() {
		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("ACE", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	/*
	 * @Test void veryLargeCharLengthKeyEncryption() {
	 * 
	 * StringBuilder key = new StringBuilder(); for (int i = 1; i < 2147483; i++) {
	 * key.append('B'); } String msg = "ABC";
	 * 
	 * EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key.toString());
	 * 
	 * // test getMessage try { assertEquals("BCD", encryptedMsg.getMessage()); }
	 * catch (Exception e) { fail("Unexpected exception."); e.printStackTrace(); } }
	 * 
	 */

	@Test
	void nullKeyEncryption() {

		String msg = "ABC";
		String key = null;

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());
	}


	@Test
	void msgLongerThanKeyEncryption() {

		String msg = "ABC";
		String key = "BD";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BED", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void msgShorterThanKeyEncryption() {

		String msg = "ABC";
		String key = "BCDEFG";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BDF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void msgKeySameLengthEncryption() {

		String msg = "ABC";
		String key = "ABC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("ACE", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}
	
	
	@Test
	void uppercaseKeyEncryption() {

		String msg = "ABC";
		String key = "BCDEFG";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BDF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void lowercaseKeyEncryption() {

		String msg = "ABC";
		String key = "b";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("BCD", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void mixedCaseKeyEncryption() {

		String msg = "ABD";
		String key = "BbC";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		
		// test getMessage
		try {
		  System.out.print(encryptedMsg.getMessage());
			assertEquals("BCF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void numberKeyEncryption() {
		String msg = "ABC";
		String key = "12";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void punctuationKeyEncryption() {
		String msg = "ABC";
		String key = "#$%^";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void spaceKeyEncryption() {
		String msg = "ABC";
		String key = "      ";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	
	@Test
	void mixedCharKeyEncryption() {
		String msg = "ABC";
		String key = "AB2 (5)";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void uppercaseMsgEncryption() {

		String msg = "BCDEFG";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void lowercaseMsgEncryption() {

		String msg = "bcdefg";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void mixedCaseMsgEncryption() {

		String msg = "BcdeFg";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void numberMsgEncryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void punctuationMsgEncryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void spaceMsgEncryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void mixedCharMsgEncryption() {
		String msg = "HE11O THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("IFPUIFSF", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}

	}

	
	@Test
	void uppercaseEncryptedMsgEncryption() {

		String msg = "CDEFGH";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals(msg, encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void lowercaseEncryptedMsgEncryption() {

		String msg = "cdefgh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	@Test
	void mixedCaseEncryptedMsgEncryption() {

		String msg = "CdefGh";
		String key = "B";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("CDEFGH", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}


	@Test
	void numberEncryptedMsgEncryption() {
		String msg = "43255";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void punctuationEncryptedMsgEncryption() {
		String msg = "#%&!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}

	@Test
	void spaceEncryptedMsgEncryption() {
		String msg = "    ";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	
	@Test
	void mixedCharEncryptedMsgEncryption() {
		String msg = "HE110 THERE!";
		String key = "B";
		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		Throwable exception = assertThrows(Exception.class, () -> encryptedMsg.getMessage());
		assertEquals("Unauthorized use.", exception.getMessage());

	}


	@Test
	void noChangeEncryption() {

		String msg = "BCDEFG";
		String key = "A";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg);

		// test getMessage
		try {
			assertEquals("BCDEFG", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}



	@Test
	void noRolloverEncryption() {

		String msg = "BCDEFG";
		String key = "C";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("DEFGHI", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}

	
	@Test
	void rolloverEncryption() {

		String msg = "XYZABC";
		String key = "CCCZZZ";

		EncryptedMessage encryptedMsg = new EncryptedMessage(msg, key);

		// test getMessage
		try {
			assertEquals("ZABZAB", encryptedMsg.getMessage());
		} catch (Exception e) {
			fail("Unexpected exception.");
			e.printStackTrace();
		}
	}
	

}
