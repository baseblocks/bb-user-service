package tech.baseblocks.dataencryption.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDto {
    private String name;
    private String token;
}
