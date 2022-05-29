package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Album;
import ua.com.alevel.facade.AlbumFacade;
import ua.com.alevel.service.AlbumService;
import ua.com.alevel.view.dto.request.AlbumRequestDto;
import ua.com.alevel.view.dto.response.AlbumResponseDto;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumFacadeImpl implements AlbumFacade {

    private final AlbumService albumService;

    public AlbumFacadeImpl(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Override
    public void create(AlbumRequestDto albumRequestDto) {
        Album album = new Album();
        album.setTitle(albumRequestDto.getTitle());
        album.setCover(albumRequestDto.getCover());
        album.setDescription(albumRequestDto.getDescription());
        album.setReleaseDate(albumRequestDto.getReleaseDate());
        albumService.create(album);
    }

    @Override
    public void update(AlbumRequestDto albumRequestDto, Long id) {
        Album album = albumService.findById(id);
            album.setTitle(albumRequestDto.getTitle());
            album.setCover(albumRequestDto.getCover());
            album.setDescription(albumRequestDto.getDescription());
            album.setReleaseDate(albumRequestDto.getReleaseDate());
            album.setUpdated(new Timestamp(System.currentTimeMillis()));
            albumService.update(album);

    }

    @Override
    public void delete(Long id) {
        albumService.delete(id);
    }

    @Override
    public AlbumResponseDto findById(Long id) {
        return new AlbumResponseDto(albumService.findById(id));
    }

    @Override
    public List<AlbumResponseDto> findAll() {
        return albumService.findAll()
                .stream()
                .map(AlbumResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Long, String> findAllUsersByAlbumId(Long albumId) {
        return albumService.findAllUsersByAlbumId(albumId);
    }
}
