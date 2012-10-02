package com.uct.cs.wsintelliauction.utility;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Security implementation for 64bit encryption and decryption.
 *
 */
public class Security {

	private static SecretKeySpec key;
	private static IvParameterSpec ivSpec;
	private static Cipher cipher;

	static {
		byte[] keyBytes = { '2', '9', 'n', '6', 'h', 'c', 'w', 'G' };
		byte[] ivBytes = { 'f', '7', 'E', 'f', '8', '3', 'X', 'q' };
		key = new SecretKeySpec(keyBytes, "DES");
		ivSpec = new IvParameterSpec(ivBytes);

		try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String input) throws Exception{
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		byte[] encypted = new byte[cipher.getOutputSize(input.length())];
		int enc_len = cipher.update(input.getBytes(), 0, input.length(), encypted, 0);
		enc_len += cipher.doFinal(encypted, enc_len);
		return new String(encypted);
	}

	public static String decrypt(String encrypted) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		byte[] decrypted = new byte[cipher.getOutputSize(encrypted.length())];
		int dec_len = cipher.update(encrypted.getBytes(), 0, encrypted.length(), decrypted, 0);
		dec_len += cipher.doFinal(decrypted, dec_len);
		return new String(decrypted);
	}

}
