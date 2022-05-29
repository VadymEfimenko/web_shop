package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

    @AttributeOverride(name = "id", column = @Column(name = "user_id"))
    private String firstName;
    private String lastName;
    private Long age;
    @Column(columnDefinition = "TEXT")
    private String aboutUser;
    private String image;

    @ManyToMany(mappedBy = "users")
    private Set<Album> albums;

    public User(){
        super();
        this.albums = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
