package tech.baseblocks.dataencryption.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.baseblocks.dataencryption.repository.attributeconverter.StringAttributeConverter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bb_user")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @Convert(converter = StringAttributeConverter.class)
    private String name;
    private String token;

}
