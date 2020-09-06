package tech.baseblocks.dataencryption.encryption;

public interface Encryptor {

    String encrypt(String plainText);

    String decrypt(String encryptedString);
}
