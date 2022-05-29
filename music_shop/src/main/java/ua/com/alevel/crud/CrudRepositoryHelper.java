package ua.com.alevel.crud;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface CrudRepositoryHelper <E extends BaseEntity, R extends BaseRepository<E>> {

    void create(R repository, E entity);
    void update(R repository, E entity);
    void delete(R repository, Long id);
    Optional<E> findById(R repository, Long id);
    List<E> findAll(R repository);
}
