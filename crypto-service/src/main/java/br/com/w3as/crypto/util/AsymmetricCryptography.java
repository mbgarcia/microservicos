package br.com.w3as.crypto.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

public class AsymmetricCryptography {
	private Cipher cipher;
	
	private String publicKey;

	public AsymmetricCryptography(String publicKey) throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.publicKey = publicKey;
		this.cipher = Cipher.getInstance("RSA");
	}

	// https://docs.oracle.com/javase/8/docs/api/java/security/spec/X509EncodedKeySpec.html
	public PublicKey getPublic() throws Exception {
		PemFile pemFile = new PemFile();
		X509EncodedKeySpec spec = new X509EncodedKeySpec(pemFile.read(publicKey));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}
	
	public String encryptText(String msg) throws Exception {
		this.cipher.init(Cipher.ENCRYPT_MODE, this.getPublic());
		return Base64.encodeBase64String(cipher.doFinal(msg.getBytes("UTF-8")));
	}
}