package tech.baseblocks.dataencryption.repository.attributeconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.baseblocks.dataencryption.encryption.Encryptor;

import javax.persistence.AttributeConverter;

@Component
public class StringAttributeConverter implements AttributeConverter<String, String> {
    @Autowired
    private Encryptor encryptor;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return encryptor.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return encryptor.decrypt(dbData);
    }
}
