package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.crud.CrudRepositoryHelper;
import ua.com.alevel.entity.Album;
import ua.com.alevel.entity.User;
import ua.com.alevel.repository.UserRepository;
import ua.com.alevel.service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final CrudRepositoryHelper<User, UserRepository> crudRepositoryHelper;
    private final UserRepository userRepository;

    public UserServiceImpl(CrudRepositoryHelper<User, UserRepository> crudRepositoryHelper, UserRepository userRepository) {
        this.crudRepositoryHelper = crudRepositoryHelper;
        this.userRepository = userRepository;
    }

    @Override
    public void create(User entity) {
        crudRepositoryHelper.create(userRepository, entity);
    }

    @Override
    public void update(User entity) {
        crudRepositoryHelper.update(userRepository, entity);
    }

    @Override
    public void delete(Long id) {
        crudRepositoryHelper.delete(userRepository, id);
    }

    @Override
    public User findById(Long id) {
        return crudRepositoryHelper.findById(userRepository, id).get();
    }

    @Override
    public List<User> findAll() {
        return crudRepositoryHelper.findAll(userRepository);
    }

    @Override
    public Map<Long, String> findAllAlbumsByUserId(Long userId) {
        Map<Long, String> allAlbums = new HashMap<>();
        Set<Album> albums = findById(userId).getAlbums();
        for (Album album : albums){
            allAlbums.put(album.getId(), album.getTitle());
        }
        return allAlbums;
    }
}
