package ua.com.alevel.view.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AlbumRequestDto extends RequestDto {

    private String title;
    private String cover;
    private String description;
    private Integer releaseDate;

}
