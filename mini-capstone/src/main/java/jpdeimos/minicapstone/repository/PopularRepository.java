package jpdeimos.minicapstone.repository;

import jpdeimos.minicapstone.entity.PopularEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PopularRepository extends JpaRepository<PopularEntity, BigInteger> {
}
