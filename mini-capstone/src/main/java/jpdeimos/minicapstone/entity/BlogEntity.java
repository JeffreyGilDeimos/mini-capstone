package jpdeimos.minicapstone.entity;

import jpdeimos.minicapstone.config.SchemaConfiguration;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "BLOGS")
public class BlogEntity {
    @Id
    private UUID blogId;
    private String blogName;
    private String blogAuthor;
    private String imageLink;
    private String description;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BlogEntity that = (BlogEntity) o;
        return blogId != null && Objects.equals(blogId, that.blogId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
