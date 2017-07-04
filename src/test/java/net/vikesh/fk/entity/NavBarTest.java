package net.vikesh.fk.entity;

import net.vikesh.fk.entity.component.NavBar;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vikes on 04-07-2017.
 */
public class NavBarTest {

    @Test
    public void equalsTest_1(){
        NavBar navBar = new NavBar();
        Assert.assertTrue(navBar.equals(navBar));
    }

    @Test
    public void equalsTest_2(){
        NavBar navBar = new NavBar();
        Assert.assertFalse(navBar.equals(null));
    }

    @Test
    public void equalsTest_3(){
        NavBar navBar = new NavBar();
        NavBar navBar2 = new NavBar();
        Assert.assertTrue(navBar.equals(navBar2));
    }

    @Test
    public void hashCodeTest(){
        NavBar navBar = new NavBar();
        Assert.assertTrue(navBar.hashCode() == 0);
    }

}
