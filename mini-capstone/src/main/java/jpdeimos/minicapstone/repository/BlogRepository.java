package jpdeimos.minicapstone.repository;

import jpdeimos.minicapstone.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, BigInteger> {
}
