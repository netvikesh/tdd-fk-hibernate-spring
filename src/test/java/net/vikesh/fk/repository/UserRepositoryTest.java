package net.vikesh.fk.repository;

import net.vikesh.fk.config.ApplicationConfig;
import net.vikesh.fk.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vikesh
 */
@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    static final Logger LOGGER = LogManager.getLogger(UserRepositoryTest.class.getName());

    @Resource
    UserRepository userRepository;

    @Before
    public void beforeEachTest() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldSaveUser() {
        User user = createDummyUser();
        User save = userRepository.save(user);
        System.out.println(save.getUuid());
        Assert.assertNotNull(save.getEmail());
        Assert.assertNotNull(save.getSalt());
        Assert.assertNotNull(save.getUserName());
        Assert.assertNotNull(save.getFirstName());
        Assert.assertNotNull(save.getLastName());
        Assert.assertNotNull(user.getCreatedAt());
        Assert.assertNotNull(user.getPassword());
        Assert.assertNotNull(user.getMiddleName());
        Assert.assertNotNull(save.getUuid());
    }

    @Test
    public void sameEmailShouldMeanSameUser() {
        User user1 = createDummyUser();
        User user2 = createDummyUser();
        Assert.assertTrue(user1.equals(user2));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveUsersWithSameEmail() {
        User user1 = createDummyUser();
        user1.setUserName("user1");
        User user2 = createDummyUser();
        user2.setUserName("user2");
        Assert.assertFalse(user1.equals(user2));
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void shouldNotSaveUsersWithSameUserName() {
        User user1 = createDummyUser();
        user1.setEmail("user1@gmail.com");
        User user2 = createDummyUser();
        user2.setEmail("user2@gmail.com");
        Assert.assertFalse(user1.equals(user2));
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test
    public void shouldDeleteUser() {
        User user = createDummyUser();
        User save = userRepository.save(user);
        System.out.println(save.getUuid());
        Assert.assertNotNull(save.getUuid());
        userRepository.delete(user);
        long count = userRepository.count();
        Assert.assertEquals(0L, count);
    }

    @Test
    public void shouldDeleteAllUser() {
        int userSize = 20;
        List<User> dummyUsers = createDummyUsers(userSize);
        dummyUsers.forEach(user -> userRepository.save(user));
        Assert.assertEquals((long) userRepository.count(), userSize);
        userRepository.deleteAll();
        Assert.assertEquals((long) userRepository.count(), 0L);
    }

    @Test
    public void shouldUpdateOneUser() {
        User user = createDummyUser();
        userRepository.save(user);
        String uuid = user.getUuid();
        User beforeUpdate = userRepository.findOne(uuid);
        beforeUpdate.setEmail("testemail@email.com");
        userRepository.save(beforeUpdate);
        User afterSave = userRepository.findOne(uuid);
        Assert.assertNotNull(afterSave.getModifiedAt());
        Assert.assertNotNull(afterSave.getCreatedAt());
        Assert.assertEquals("testemail@email.com", afterSave.getEmail());
    }

    private User createDummyUser() {
        User user = new User();
        user.setEmail("vikesh.kumar2@gmail.com")
                .setLastName("Kumar")
                .setMiddleName("None")
                .setFirstName("Vikesh")
                .setPassword("somepassword")
                .setUserName("vikeshkumar");
        return user;
    }

    @Test
    public void shouldFindUserByParameters() {
        User user = createDummyUser();
        user.setEmail("test.email@email.com");
        userRepository.save(user);
        User vikeshkumar = userRepository.findByUserName("vikeshkumar");
        User testEmail = userRepository.findByEmail("test.email@email.com");
        Assert.assertNotNull(vikeshkumar);
        Assert.assertNotNull(testEmail);
    }

    @Test
    public void userEqualityTest(){
        User user = createDummyUser();
        User user2 = createDummyUser();
        userRepository.save(user);
        Assert.assertFalse(user.equals(user2));
    }

    private List<User> createDummyUsers(int size) {
        List<User> users = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setEmail("testemail" + i + "@gmail.com")
                    .setLastName("User " + i)
                    .setFirstName("Vikesh")
                    .setPassword("somepassword" + i)
                    .setUserName("vikeshkumar" + i);
            users.add(user);
        }
        return users;
    }
}
