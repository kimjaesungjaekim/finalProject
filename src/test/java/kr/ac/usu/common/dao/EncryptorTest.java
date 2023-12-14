package kr.ac.usu.common.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import kr.ac.usu.AbstractRootContextTestFor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EncryptorTest extends AbstractRootContextTestFor {

	@Test
	void test() {
		String key = KeyGenerators.string().generateKey();
		String origin = "히히";
		String pass = "hoseol";
		TextEncryptor encryptor1 = Encryptors.text(key, pass);
		String encrypted = encryptor1.encrypt(origin);
		String decrypted = encryptor1.decrypt(encrypted);
		
		log.info("제네레이트 키 : {}",key);
		log.info("오리진 데이터 : {}",origin);
		log.info("암호화한 데이터 : {}",encrypted);
		log.info("복호화한 데이터 : {}",decrypted);
		String readyData = "e926584848d6f016c35eb89a1c854c40b318dc1de63c12d652af80a969ab5c4c";
		
		String secondKey = KeyGenerators.string().generateKey();
		
		TextEncryptor encryptor2 = Encryptors.text(secondKey,pass);
		log.info("원래의 키 : {}",secondKey);
		log.info("오리진 데이터 : {}",origin);
		String decrypted1 = encryptor1.decrypt(readyData);
		String decrypted2 = encryptor2.decrypt(readyData);
		log.info("첫 번째 인크립터 복호화 : {}",decrypted1);
		log.info("두 번째 인크립터 복호화 : {}",decrypted2);
	}

}
