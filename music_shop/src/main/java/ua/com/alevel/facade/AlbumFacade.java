package ua.com.alevel.facade;

import ua.com.alevel.view.dto.request.AlbumRequestDto;
import ua.com.alevel.view.dto.response.AlbumResponseDto;

import java.util.Map;

public interface AlbumFacade extends BaseFacade <AlbumRequestDto, AlbumResponseDto> {

    Map<Long, String> findAllUsersByAlbumId(Long albumId);
}
