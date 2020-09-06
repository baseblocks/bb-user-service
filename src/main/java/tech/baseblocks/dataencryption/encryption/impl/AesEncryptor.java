package tech.baseblocks.dataencryption.encryption.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.baseblocks.dataencryption.encryption.Encryptor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class AesEncryptor implements Encryptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(AesEncryptor.class);
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String UTF_8 = "UTF-8";

    @Autowired
    private SecretKeySpec secretKey;

    @Override
    public String encrypt(String plainText) {
        LOGGER.info("Encrypted field {}", plainText);

        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] stringBytes = plainText.getBytes(UTF_8);
            return encoder.encodeToString(cipher.doFinal(stringBytes));
        } catch (Exception e) {
            throw new RuntimeException("Could not handle the encryption");
        }
    }

    @Override
    public String decrypt(String encryptedString) {
        LOGGER.info("Decrypted field {}", encryptedString);
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            Base64.Decoder decoder = Base64.getDecoder();
            return new String(cipher.doFinal(decoder.decode(encryptedString)));
        } catch (Exception e)
        {
            throw new RuntimeException("Could not handle the decryption", e);
        }
    }
}
