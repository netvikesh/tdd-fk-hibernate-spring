package net.vikesh.fk;

import net.vikesh.fk.config.ApplicationConfig;
import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.entity.component.NavNode;
import net.vikesh.fk.service.NavBarService;
import org.apache.logging.log4j.util.Strings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikes on 04-07-2017.
 */
@ContextConfiguration(classes = {ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NavBarServiceTest {

    @Resource
    NavBarService navBarService;

    @Test
    public void shouldSaveNavBarWithSingleNode(){
        NavBar navBar = new NavBar();
        NavNode node = new NavNode();
        List<NavNode> nodes = new ArrayList<>();
        nodes.add(node);
        node.setHref("/home");
        node.setText("Home");
        navBar.setNavNodes(nodes);
        navBarService.saveNavBar(navBar);
        Assert.assertTrue(Strings.isNotBlank(navBar.getUuid()));
        Assert.assertTrue(Strings.isNotBlank(node.getUuid()));
    }


    @Test
    public void shouldSaveNavBarWithMultiple(){
        NavBar navBar = new NavBar();
        NavNode node = new NavNode();
        NavNode node2 = new NavNode();
        List<NavNode> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.add(node2);


        node.setHref("/home");
        node.setText("Home");

        node2.setHref("/about");
        node2.setText("About");

        NavNode aboutChild = new NavNode();
        aboutChild.setText("/about/org");
        aboutChild.setText("About Organisation");
        List<NavNode> aboutChildren = new ArrayList<>();
        aboutChildren.add(aboutChild);
        node2.setNavNodes(aboutChildren);
        navBar.setNavNodes(nodes);
        navBarService.saveNavBar(navBar);
        Assert.assertTrue(Strings.isNotBlank(navBar.getUuid()));
        Assert.assertTrue(Strings.isNotBlank(node.getUuid()));
        Assert.assertTrue(Strings.isNotBlank(node2.getUuid()));
        Assert.assertTrue(Strings.isNotBlank(aboutChild.getUuid()));
    }
}
