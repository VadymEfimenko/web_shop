package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Album;
import ua.com.alevel.entity.User;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.service.AlbumService;
import ua.com.alevel.service.UserService;
import ua.com.alevel.view.dto.request.UserRequestDto;
import ua.com.alevel.view.dto.response.AlbumResponseDto;
import ua.com.alevel.view.dto.response.UserResponseDto;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final AlbumService albumService;

    public UserFacadeImpl(UserService userService, AlbumService albumService) {
        this.userService = userService;
        this.albumService = albumService;
    }

    @Override
    public void create(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setAge(userRequestDto.getAge());
        user.setAboutUser(userRequestDto.getAboutUser());
        user.setImage(userRequestDto.getImage());
        try{
            Set<Long> albumsId = userRequestDto.getAlbumsId();
            userService.create(user);
            for (Long id : albumsId){
                Album album = albumService.findById(id);
                album.addUser(user);
                albumService.update(album);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserRequestDto userRequestDto, Long id) {
        User user = userService.findById(id);
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setAge(userRequestDto.getAge());
        user.setAboutUser(userRequestDto.getAboutUser());
        user.setImage(userRequestDto.getImage());
        user.setUpdated(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }

    @Override
    public UserResponseDto findById(Long id) {
        return new UserResponseDto(userService.findById(id));
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userService.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Long, String> findAllAlbumsByUserId(Long userId) {
        return userService.findAllAlbumsByUserId(userId);
    }
}
