package ua.com.alevel.view.dto.response;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.entity.User;

@Getter
@Setter
public class UserResponseDto extends ResponseDto {

    private String firstName;
    private String lastName;
    private Long age;
    private String aboutUser;
    private String image;
    private Integer albumsCount;

    public UserResponseDto(){

    }

    public UserResponseDto(User user){
        setId(user.getId());
        setCreated(user.getCreated());
        setUpdated(user.getUpdated());
        firstName = user.getFirstName();
        lastName = user.getFirstName();
        age = user.getAge();
        aboutUser = user.getAboutUser();
        image = user.getImage();
        albumsCount = user.getAlbums().size();
    }
}
