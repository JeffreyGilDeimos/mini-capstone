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
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "PRODUCTS")
public class ProductEntity {
    @Id
    private UUID product_id;
    private String  product_name;
    private String image_link;
    private float price;
    private float ratings;
    private String type;
    private String filter;
    private String description;
    private ZonedDateTime created_date;
    private ZonedDateTime modified_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity that = (ProductEntity) o;
        return product_id != null && Objects.equals(product_id, that.product_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

