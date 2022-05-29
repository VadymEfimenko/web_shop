package ua.com.alevel.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Album;
import ua.com.alevel.entity.User;

import java.util.List;

@Repository
public interface AlbumRepository extends BaseRepository<Album> {

}
