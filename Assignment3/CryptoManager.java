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

public class CryptoManager 
{
	// Constant variables in regard to the lower and upper ranges 
	private static final int LOWER_RANGE = 32;
	private static final int UPPER_RANGE = 95;
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	/**
	 *  Method 1: checks if the String is within bounds 
	 * @param plainText
	 * @return A bool value stating verifying whether the String is within bounds (true)
	 * or not (false)
	 */
	public static boolean isStringInBounds (String plainText)
	{
		// for loop cycles through each individual character to check if it is within bounds (returns false if not)
		for (int i = 0; i < plainText.length(); i++)
		{
			char character = plainText.charAt(i);
			if (character < LOWER_RANGE || character > UPPER_RANGE)
				return false;
		}
		return true;
	}
	
	/**
	 * Method 2: Caesar Encryption: Encrypts a provided String using a key (integer) while also checking if the string from the previous 
	 *  method is within bounds or not
	 * @param plainText
	 * @param key
	 * @return Method returns a string that is encrypted using the Caesar Encryption/Decryption Method  
	 */
	public static String caesarEncryption (String plainText, int key)
	{
		// Bounds checking
		if (!isStringInBounds(plainText))
			return "The selected string is not in bounds, Try again.";
		
		// While loops adjusts the key to be in bounds IN CASE it is a negative integer or it's greater than the upper limit
		while (key > RANGE)
			key -= RANGE;
		
		while (key < 0)
			key += RANGE;
		
		String cipherText = "";
		
		/* Encrypts each character in plainText by shifting its ASCII value
		 * based on the key. Handles wrap-around if the new value exceeds
		 * the upper limit of the ASCII range.
		 */
		for (int i = 0; i < plainText.length(); i++)
		{
			char character = plainText.charAt(i);
			
			int newCharacter = character + key;
			
			if (newCharacter > UPPER_RANGE)
				newCharacter = LOWER_RANGE + (newCharacter - UPPER_RANGE - 1);
			
			// Adds character to new encrypted String after each cycle
			cipherText += Character.toString(newCharacter);
		}
		return cipherText;
	}
	
	/**
	 * Method 3: Caesar Decryption Method decrypts an encrypted String using a key (integer) while also
	 * checking if the String is within bounds. 
	 * @param encryptedText
	 * @param key
	 * @return Method returns a decrypted string using the Caesar Decryption method  
	 */
	public static String caesarDecryption (String encryptedText, int key)
	{
		// Bounds checking
		if (!isStringInBounds(encryptedText))
			return "The encrypted string is not in bounds.";
		
		// While loops adjusts the key to be in bounds IN CASE it is a negative integer or it's greater than the upper limit
		while (key > RANGE)
			key -= RANGE;
		
		while (key < 0)
			key += RANGE;
		
		String plainText = "";
		
		/* For loop decrypts each character in encryptedText by reversing the encryption process.
		 * It subtracts the key from each character's ASCII value. If the resulting ASCII
		 * value is below the lower limit, it wraps around within the valid ASCII range.
		 */
		for (int i = 0; i < encryptedText.length(); i++)
		{
			char encryptedCharacter = encryptedText.charAt(i);
			
			int originalCharacter = encryptedCharacter - key;
			
			// Handles Wrap-Around
			if (originalCharacter < LOWER_RANGE)
				originalCharacter = UPPER_RANGE - (LOWER_RANGE - originalCharacter - 1);
			
			plainText += Character.toString(originalCharacter);
		}
		return plainText;
	}
	
	/**
	 * Method 4: Bellaso Encryption Methods encrypts a String using a keyword bellaso string,
	 * and encrypts the plainText string by offsetting each character according to the 
	 * ASCII value of the corresponding character in the Bellaso String. 
	 * @param plainText
	 * @param bellasoStr
	 * @return Returns the encrypted String
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr)
	{
		// Bounds Checking
		if (!isStringInBounds(plainText))
			return "The String is not within bounds. Try again." ;
		
		// Initial values set + length of both parameters are initialized 
		String encrypted = "";
		int length = plainText.length();
		int bellasoLength = bellasoStr.length();
		int indexBellaso = 0;
		
		// For loop loops through every character in the plainText
		for (int i = 0; i < length; i++)
		{
			// Gets current characters at current index 
			char plainTextChar = plainText.charAt(i);
			char bellasoChar = bellasoStr.charAt(indexBellaso);
			
			// Calculates encrypted ASCII value by comverting them to int values
			int encryptedValue = (int) plainTextChar + (int) bellasoChar;
			
			// While loops for possible wrap arounds 
			while (encryptedValue > UPPER_RANGE)
				encryptedValue -= RANGE;
			
			while (encryptedValue < LOWER_RANGE)
				encryptedValue += RANGE;
			
			// Adds encrypted character to full encrypted String
			encrypted += (char) encryptedValue;
			
			// Updates bellaso index to next character, resets if index reaches length of bellaso string 
			indexBellaso++;
			
			if (indexBellaso >= bellasoLength)
				indexBellaso = 0;
		}
		return encrypted;	
	}
	
	/**
	 * Method 4: Bellaso Decryption Method Decrypts a String using 
	 * @param encryptedText
	 * @param bellasoStr
	 * @return Returns decrypted bellaso String 
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr)
	{
		// Bounds Checking
		if (!isStringInBounds(encryptedText))
			return "The String is not within bounds. Try again.";
		
		// Initial Values Set
		String decrypted = "";
		int length = encryptedText.length();
		int bellasoLength = bellasoStr.length();
		int bellasoIndex = 0;
		
		// For Loop loops through every character in the encryptedText String
		for (int i = 0; i < length; i++)
		{
			// Gets current characters at current index 
			char encryptedChar = encryptedText.charAt(i);
			char bellasoChar = bellasoStr.charAt(bellasoIndex);
			
			// Calculates decrypted ASCII value by comverting them to int values
			int decryptedValue = (int) encryptedChar - (int) bellasoChar;
			
			// While loops for possible wrap arounds
			while (decryptedValue > UPPER_RANGE)
				decryptedValue -= RANGE;
			
			while (decryptedValue < LOWER_RANGE)
				decryptedValue += RANGE;
			
			// Adds decrypted character to full decrypted String
			decrypted += (char) decryptedValue;
			
			// Updates bellaso index to next character, resets if index reaches length of bellaso string 
			bellasoIndex++;
			
			if (bellasoIndex >= bellasoLength)
				bellasoIndex = 0;
		}
		return decrypted;
	}
}
