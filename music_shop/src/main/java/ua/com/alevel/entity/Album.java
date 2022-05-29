package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "albums")
@Getter
@Setter
public class Album extends BaseEntity {

    @AttributeOverride(name = "id", column = @Column(name = "album_id"))
    private String title;
    private String cover;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer releaseDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "album_user",
    joinColumns = @JoinColumn(name = "album_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    public Album(){
        super();
        this.users = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Album album = (Album) o;
        return getId() != null && Objects.equals(getId(), album.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addUser(User user){
        users.add(user);
        user.getAlbums().add(this);
    }

    public void removeUser (User user){
        user.getAlbums().remove(this);
        users.remove(user);
    }
}
