package ua.com.alevel.view.dto.response;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.entity.Album;
import ua.com.alevel.view.dto.request.AlbumRequestDto;

@Getter
@Setter
public class AlbumResponseDto extends ResponseDto {

    private String title;
    private String cover;
    private String description;
    private Integer releaseDate;
    private Integer usersCount;

    public AlbumResponseDto(){

    }

    public AlbumResponseDto(Album album){
        setId(album.getId());
        setCreated(album.getCreated());
        setUpdated(album.getUpdated());
        title = album.getTitle();
        cover = album.getCover();
        description = album.getDescription();
        releaseDate = album.getReleaseDate();
        usersCount = album.getUsers().size();
    }
}
