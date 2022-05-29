package ua.com.alevel.service;

import ua.com.alevel.entity.Album;
import ua.com.alevel.entity.User;

import java.util.List;
import java.util.Map;

public interface AlbumService extends BaseService<Album> {

    Map<Long, String> findAllUsersByAlbumId(Long albumId);
}
