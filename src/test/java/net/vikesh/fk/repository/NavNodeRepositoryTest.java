package net.vikesh.fk.repository;

import net.vikesh.fk.config.ApplicationConfig;
import net.vikesh.fk.entity.component.NavNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by vikes on 04-07-2017.
 */
@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NavNodeRepositoryTest {

    @Resource
    private NavNodeRepository navNodeRepository;

    @Test
    public void navNodeEqualityTest() {
        NavNode node = new NavNode();
        node.setHref("href1");
        node.setText("text2");
        navNodeRepository.save(node);
        NavNode node2 = new NavNode();
        node.setHref("href1");
        node.setText("text2");
        Assert.assertFalse(node.equals(node2));
    }
}
