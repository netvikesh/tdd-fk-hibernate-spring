package net.vikesh.fk.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikes on 04-07-2017.
 */
public class UserTest {

    @Test
    public void testEquals() {
        User user1 = new User();
        User user2 = new User();
        user1.setUserName("vikesh");
        user1.setEmail("vikesh.kumar2@gmail.com");
        user2.setUserName("vikesh");
        user2.setEmail("vikesh.kumar2@gmail.com");
        Assert.assertTrue(user1.equals(user2));
    }

    @Test
    public void testHashCode() {
        User user1 = new User();
        User user2 = new User();
        user1.setUserName("vikesh");
        user1.setEmail("vikesh.kumar2@gmail.com");
        user2.setUserName("vikesh");
        user2.setEmail("vikesh.kumar2@gmail.com");
        Assert.assertTrue(user1.hashCode() == user2.hashCode());
    }

    @Test
    public void testEuals_2() {
        User user1 = new User();
        user1.setUserName("vikesh");
        user1.setEmail("vikesh.kumar2@gmail.com");
        Assert.assertTrue(user1.equals(user1));
    }

    @Test
    public void testEquals_3() {
        User user1 = new User();
        user1.setUserName("vikesh");
        user1.setEmail("vikesh.kumar2@gmail.com");
        Assert.assertFalse(user1.equals(null));
    }

    @Test
    public void testEquals_4() {
        User user1 = new User();
        user1.setUserName("vikesh");
        user1.setEmail("vikesh.kumar2@gmail.com");
        Assert.assertFalse(user1.equals(new Object()));
    }
}
