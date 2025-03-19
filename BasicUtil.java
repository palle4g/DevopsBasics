package com.gpp_mainappproj.JustMainApp;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CryptoUtil {

	private static final String UNICODE_FORMAT = "UTF8";
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	// Donot alter this key!
	private final String myEncryptionKey = "ThisIsSecretKeyForSSNNUM";
	private String myEncryptionScheme;
	SecretKey key;
	private final byte[] arrayBytes;

	public CryptoUtil() throws Exception {
		myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
		ks = new DESedeKeySpec(arrayBytes);
		skf = SecretKeyFactory.getInstance(myEncryptionScheme);
		cipher = Cipher.getInstance(myEncryptionScheme);
		key = skf.generateSecret(ks);
	}

	public String encrypt(String unencryptedString) throws Exception {
		
		String encryptedString = null;
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
		byte[] encryptedText = cipher.doFinal(plainText);
		encryptedString = new String(Base64.encodeBase64(encryptedText));

		return encryptedString;
	}


	public String decrypt(String encryptedString) throws Exception {
		
		String decryptedText = null;
		
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] encryptedText = Base64.decodeBase64(encryptedString);
		byte[] plainText = cipher.doFinal(encryptedText);
		decryptedText = new String(plainText);

		return decryptedText;
	}

    public String maskSSN(String decryptSSN) {
        String maskedSSN = "";
        if(!(decryptSSN == null) && !(decryptSSN.equals(""))){
            maskedSSN = "*****"+ decryptSSN.substring(5);
        }
        return maskedSSN;
    }

    public boolean isEncryptedSSN(String ssn) {
        boolean isEncryptedSSN = false;
        if(!(ssn == null) && ssn.length()>9){
            isEncryptedSSN = true;
        }
        return isEncryptedSSN;
    }

    public String getValidSSN(String ssn) throws Exception {
        String validSSN = ssn;
        if(!(ssn == null) && ssn.length()>9){
            validSSN = decrypt(ssn);
        }
        return validSSN;
    }


}
