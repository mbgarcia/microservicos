package br.com.w3as.crypto.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import org.bouncycastle.util.io.pem.PemReader;

public class PemFile {
	
	public PemFile() {
	}
	
	public byte[] read(String pemCode) throws FileNotFoundException, IOException {
		
		PemReader pemReader = new PemReader(new StringReader(pemCode));
		try {
			return pemReader.readPemObject().getContent();
		} finally {
			pemReader.close();
		}
	}

}
