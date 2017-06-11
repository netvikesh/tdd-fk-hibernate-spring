package net.vikesh.fk.repository;

import net.vikesh.fk.config.ApplicationConfig;
import net.vikesh.fk.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by vikes on 11-06-2017.
 */
@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Resource
    UserRepository userRepository;

    @Test
    public void shouldSaveUser() {
        User user = new User();
        user.setEmail("vikesh.kumar2@gmail.com")
                .setLastName("Kumar")
                .setFirstName("Vikesh")
                .setPassword("somepassword");

        User save = userRepository.save(user);
        Assert.assertNotNull(save.getUuid());
    }
}
