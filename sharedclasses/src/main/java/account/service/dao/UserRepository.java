package account.service.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User getUserById(long id);
    User getUserByLogin(String login);
}
