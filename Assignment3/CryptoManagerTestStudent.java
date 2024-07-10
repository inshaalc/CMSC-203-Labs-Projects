/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg 
 * Description: This assignment performs the function of decrypting and encrypting messages by utilizing two methods:
 * the Caesar Cipher method, as well as the Bellaso Encryption/Decryption method. 
 * Due: 07/09/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
 *  I have not copied the code from a student or any source. 
 *  I have not given my code to any student.
 *  Print your Name here: Inshaal Chaudhury
 */

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("ABCDEFGHIJKLMNOPQRSTUVWXYZ")); 
	    assertTrue(CryptoManager.isStringInBounds(" !\"#$%&'()*+,-./0123456789:;<=>?@[\\]^_")); 
	    assertFalse(CryptoManager.isStringInBounds("`")); 
	    assertFalse(CryptoManager.isStringInBounds("~")); 
	    assertTrue(CryptoManager.isStringInBounds(" ")); 
	    assertTrue(CryptoManager.isStringInBounds("")); 
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("BCD", CryptoManager.caesarEncryption("ABC", 1)); 
	    assertEquals("CDE", CryptoManager.caesarEncryption("ABC", 2)); 
	    assertEquals("XYZ", CryptoManager.caesarEncryption("XYZ", 0)); 
	    assertEquals("YZ[", CryptoManager.caesarEncryption("XYZ", 1));	
	    }

	@Test
	public void testDecryptCaesar() {
		assertEquals("UFTUOJH", CryptoManager.caesarDecryption("VGUVPKI", 1));
	    assertEquals("HELLO MY FRIENDS", CryptoManager.caesarDecryption("4188;L9EL2>51:0?", 300));
	    assertEquals("TESTING AGAIN", CryptoManager.caesarDecryption("N?MNCHAZ;A;CH", 250));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("!^2 RTL", CryptoManager.bellasoEncryption("TESTING", "MY_LIFE_IS_INTERESTING"));
		assertEquals("ZW!I+,#-XX", CryptoManager.bellasoEncryption("GOOD MOVIE", "SHREK_TWO"));
		assertEquals("FN^HR24W!XUR96H-VU71@", CryptoManager.bellasoEncryption("CAKE BATTER ICE CREAM", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING AGAIN", CryptoManager.bellasoDecryption("WN#\\N &)T&MX\\", "CIPHER_IS_LONGER"));
		assertEquals("EID MUBARAK", CryptoManager.bellasoDecryption("HVW#>I2D_TN", "CMSC140"));
		assertEquals("I LOVE MY CATS", CryptoManager.bellasoDecryption("L!XR+Q5 84ZPWT", "CALCULUS_TWO"));

	}

}
