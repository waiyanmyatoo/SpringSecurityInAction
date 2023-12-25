package com.example.springsecurityinaction.crypto;

import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

public class SecurityCryptoDemo {

    // String Key Generator
    StringKeyGenerator stringKeyGenerator = KeyGenerators.string();
    String stringSalt = stringKeyGenerator.generateKey();

    //Bytes Key Generator
    BytesKeyGenerator bytesKeyGenerator = KeyGenerators.secureRandom(16);
    byte[] key = bytesKeyGenerator.generateKey();
    int keyLength = bytesKeyGenerator.getKeyLength();

    BytesKeyGenerator keyGenerator = KeyGenerators.shared(16);
    byte [] key1 = keyGenerator.generateKey();
    byte [] key2 = keyGenerator.generateKey();

    /// Encryptors

    String salt = KeyGenerators.string().generateKey();
    String password = "secret";
    String valueToEncrypt = "HELLO";

    BytesEncryptor bytesEncryptor = Encryptors.standard(password, salt);
    byte[] encrypted = bytesEncryptor.encrypt(valueToEncrypt.getBytes());
    byte[] decrypted = bytesEncryptor.decrypt(encrypted);


    String salt = KeyGenerators.string().generateKey();
    String password = "secret";
    String valueToEncrypt = "HELLO";
    TextEncryptor e =  Encryptors.queryableText(password, salt);
    String encrypted1 = e.encrypt(valueToEncrypt);
    String encrypted2 = e.encrypt(valueToEncrypt);
}
