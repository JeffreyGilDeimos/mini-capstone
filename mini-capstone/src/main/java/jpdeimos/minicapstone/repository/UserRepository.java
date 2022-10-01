package jpdeimos.minicapstone.repository;

import jpdeimos.minicapstone.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

}
