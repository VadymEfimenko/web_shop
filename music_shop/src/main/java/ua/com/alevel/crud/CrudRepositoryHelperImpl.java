package ua.com.alevel.crud;

import org.springframework.stereotype.Service;
import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CrudRepositoryHelperImpl <
        E extends BaseEntity,
        R extends BaseRepository<E>>
        implements CrudRepositoryHelper<E, R> {
    @Override
    public void create(R repository, E entity) {
        repository.save(entity);
    }

    @Override
    public void update(R repository, E entity) {
        repository.save(entity);
    }

    @Override
    public void delete(R repository, Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<E> findById(R repository, Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll(R repository) {
        return repository.findAll();
    }

    private void checkById(R repository, Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("entity not found");
        }
    }
}
