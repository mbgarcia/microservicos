package br.com.w3as.crypto.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service")
public class ServiceProperties {
	private String publicKey;

	public String getPublicKey() {
		return publicKey.replaceAll("<br>", "\n");
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

}
