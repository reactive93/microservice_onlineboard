package account.service.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    Group getGroupById(long id);

    @Query(value = "select group from Group group where group.user_id =?1 or group.creator_id = ?1 and group.is_creator = true ")
    List<Group> getGroupsByUser_idAndCreator_id(long id);


}
