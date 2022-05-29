package ua.com.alevel.service;

import ua.com.alevel.entity.Album;
import ua.com.alevel.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService extends BaseService<User> {

    Map<Long, String> findAllAlbumsByUserId(Long userId);
}
