package ua.com.alevel.view.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.entity.Album;

import java.util.Set;

@Getter
@Setter
@ToString
public class UserRequestDto extends RequestDto {

    private String firstName;
    private String lastName;
    private Long age;
    private String aboutUser;
    private String image;
    private Set<Long> albumsId;
}
