package com.accountservice.accountservice;




import account.service.dao.Group;
import account.service.dao.GroupRepository;
import account.service.dao.User;
import account.service.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseConnectionTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void getUserById() {
        User user = userRepository.getUserById(3);
        Assert.assertNotNull(user);
        Assert.assertEquals("User Name","3",user.getLogin());
    }

    @Test
    public void getUserByLogin() {
        User user = userRepository.getUserByLogin("3");
        Assert.assertNotNull(user);
    }
    @Test
    public void getGroupsById() {
        List<Group> groups = groupRepository.getGroupsByUser_idAndCreator_id(3);
        Assert.assertNotNull(groups);
        Assert.assertEquals("List length equal 2",2, groups.size());
        groups.forEach(group -> {
            System.out.println(group.getName());
        });
    }

}
