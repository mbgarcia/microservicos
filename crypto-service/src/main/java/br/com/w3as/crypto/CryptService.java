package br.com.w3as.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.w3as.crypto.util.AsymmetricCryptography;
import br.com.w3as.crypto.util.ServiceProperties;

@RestController
@RequestMapping(value="v1")
public class CryptService {
	private static final Logger logger = LoggerFactory.getLogger(CryptService.class); 
	
	@Autowired
	ServiceProperties properties;
	
	@RequestMapping(value="/encrypt/{password}",method = RequestMethod.GET)
	public String encrypt(@PathVariable("password") String password){
		try {
			AsymmetricCryptography crypt = new AsymmetricCryptography(properties.getPublicKey());
			
			return crypt.encryptText(password);			
		} catch (Exception e) {
			logger.error("Erro ao criptografar senha", e);
			return e.getMessage();
		}

	}
}
