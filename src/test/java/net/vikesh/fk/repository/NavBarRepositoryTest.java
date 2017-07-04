package net.vikesh.fk.repository;

import net.vikesh.fk.config.ApplicationConfig;
import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.entity.component.NavNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by vikes on 04-07-2017.
 */
@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NavBarRepositoryTest {

    @Resource
    private NavBarRepository navBarRepository;

    @Resource
    private NavNodeRepository navNodeRepository;

    @Test
    public void navBarWithoutNodes() {
        NavBar bar = new NavBar();
        NavBar save = navBarRepository.save(bar);
        Assert.assertNotNull(save.getUuid());
    }

    @Test
    public void navBarWithNodes() {
        NavBar bar = new NavBar();
        List<NavNode> nodes = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            nodes.add(new NavNode());
        }
        bar.setNavNodes(nodes);
        for (NavNode node : nodes) {
            node.setHref(UUID.randomUUID().toString());
            node.setText(UUID.randomUUID().toString());
            node.setNavNodes(new ArrayList<>());
            Random random = new Random();
            for (int i = 0; i < (1 + random.nextInt(10)); i++) {
                node.getNavNodes().add(new NavNode());
            }
            node.getNavNodes().forEach(navNode -> {
                navNode.setHref(UUID.randomUUID().toString());
                navNode.setText(UUID.randomUUID().toString());
                navNodeRepository.save(navNode);
            });
            navNodeRepository.save(node);
        }
        navNodeRepository.save(nodes);


        navBarRepository.save(bar);
        bar.getNavNodes().forEach(node -> {
            Assert.assertNotNull(node.getHref());
            Assert.assertNotNull(node.getText());
            Assert.assertNotNull(node.getUuid());
            Assert.assertNotNull(node.getKey());
            if (!CollectionUtils.isEmpty(node.getNavNodes())) {
                node.getNavNodes().forEach(navNode -> {
                    Assert.assertNotNull(navNode.getHref());
                    Assert.assertNotNull(navNode.getText());
                    Assert.assertNotNull(navNode.getKey());
                    Assert.assertNotNull(navNode.getUuid());
                });
            }
        });


    }


    @Test
    public void testAdditionRemoval() {
        List<NavNode> nodes = new ArrayList<>();
        NavNode addedNode = new NavNode();
        addedNode.setText(UUID.randomUUID().toString());
        addedNode.setHref(UUID.randomUUID().toString());
        nodes.add(addedNode);
        navNodeRepository.save(addedNode);
        navNodeRepository.save(nodes);
        Assert.assertTrue(nodes.contains(addedNode));
        nodes.remove(addedNode);
        navNodeRepository.delete(addedNode);
        navNodeRepository.save(nodes);
    }

    @Test
    public void testAdditionRemovalFromOneNode() {
        NavNode node = new NavNode();
        NavNode addedNode = new NavNode();
        addedNode.setText(UUID.randomUUID().toString());
        addedNode.setHref(UUID.randomUUID().toString());
        node.addNavNode(addedNode);
        navNodeRepository.save(addedNode);
        navNodeRepository.save(node);
        Assert.assertTrue(node.getNavNodes().get(0).equals(addedNode));
        node.remove(addedNode);
        navNodeRepository.save(node);
        Assert.assertTrue(node.getNavNodes().size() == 0);
    }

}
