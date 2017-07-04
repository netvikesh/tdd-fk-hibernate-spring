package net.vikesh.fk.entity;

import net.vikesh.fk.entity.component.NavNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikes on 04-07-2017.
 */
public class NavNodeTest {
    @Test
    public void equalsTest() {
        NavNode navNode = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");

        NavNode navNode2 = new NavNode();
        navNode2.setHref("href2");
        navNode2.setText("text2");
        Assert.assertFalse(navNode.equals(navNode2));
    }

    @Test
    public void equalsTest_2() {
        NavNode navNode = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");
        Assert.assertFalse(navNode.equals(null));
    }

    @Test
    public void equalsTest_1() {
        NavNode navNode = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");
        Assert.assertTrue(navNode.equals(navNode));
    }

    @Test
    public void equalsTest_3() {
        NavNode navNode = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");

        NavNode navNode2 = new NavNode();
        navNode2.setHref("href1");
        navNode2.setText("text2");
        Assert.assertFalse(navNode.equals(navNode2));
    }

    @Test
    public void equalsTest_4() {
        NavNode navNode = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");

        Assert.assertFalse(navNode.equals(new Object()));
    }

    @Test
    public void hasTest() {
        NavNode navNode = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");

        NavNode navNode2 = new NavNode();
        navNode.setHref("href1");
        navNode.setText("text1");
        Assert.assertFalse(navNode.hashCode() ==  navNode2.hashCode());
    }
}
