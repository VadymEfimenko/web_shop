package ua.com.alevel.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.crud.CrudRepositoryHelper;
import ua.com.alevel.entity.Album;
import ua.com.alevel.entity.User;
import ua.com.alevel.repository.AlbumRepository;
import ua.com.alevel.service.AlbumService;
import ua.com.alevel.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final CrudRepositoryHelper<Album, AlbumRepository> crudRepositoryHelper;

    private final AlbumRepository albumRepository;

    private final UserService userService;

    public AlbumServiceImpl(CrudRepositoryHelper<Album, AlbumRepository> crudRepositoryHelper, AlbumRepository albumRepository, UserService userService) {
        this.crudRepositoryHelper = crudRepositoryHelper;
        this.albumRepository = albumRepository;
        this.userService = userService;
    }

    @Override
    public void create(Album entity) {
        crudRepositoryHelper.create(albumRepository, entity);
    }

    @Override
    public void update(Album entity) {
        crudRepositoryHelper.update(albumRepository, entity);
    }

    @Override
    public void delete(Long id) {
        Album album = crudRepositoryHelper.findById(albumRepository, id).get();
        List<User> users = album.getUsers().stream()
                .filter(user -> userService.findAllAlbumsByUserId(user.getId()).size() == 1)
                .collect(Collectors.toList());
        album.getUsers().retainAll(users);
        crudRepositoryHelper.update(albumRepository, album);
        crudRepositoryHelper.delete(albumRepository, id);
    }

    @Override
    public Album findById(Long id) {
        return crudRepositoryHelper.findById(albumRepository, id).get();
    }

    @Override
    public List<Album> findAll() {
        return crudRepositoryHelper.findAll(albumRepository);
    }

    @Override
    public Map<Long, String> findAllUsersByAlbumId(Long albumId) {
        Map<Long, String> allUsers = new HashMap<>();
        Set<User> users = findById(albumId).getUsers();
        for (User user : users){
            allUsers.put(user.getId(), user.getFirstName() + " " + user.getLastName());
        }
        return allUsers;
    }
}
