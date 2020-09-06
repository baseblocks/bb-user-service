package tech.baseblocks.dataencryption.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Configuration
public class ApplicationConfiguration {

    @Value("${encryption.key}")
    private String encryptionKey;

    @Bean
    public SecretKeySpec secretKey() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] keyBytes = encryptionKey.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keyBytes = sha.digest(keyBytes);
        keyBytes = Arrays.copyOf(keyBytes, 16);
        return new SecretKeySpec(keyBytes, "AES");
    }
}
