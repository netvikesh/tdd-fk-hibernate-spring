package net.vikesh.fk.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by vikes on 04-07-2017.
 */
public class GenericItemTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void equalsTest_1() {
        GenericItem item = new ConcreteClassItem();
        Assert.assertTrue(item.equals(item));
    }

    @Test
    public void equalsTest_2() {
        ConcreteClassItem item = new ConcreteClassItem();
        Assert.assertFalse(item.equals(null));
    }


    @Test
    public void equalsTest_3() {
        ConcreteClassItem item = new ConcreteClassItem();
        Assert.assertFalse(item.equals(new Object()));
    }

    @Test
    public void equalsTest_4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GenericItem item = new GenericItem() {
        };
        Method beforeCreate = GenericItem.class.getDeclaredMethod("onCreate");
        beforeCreate.setAccessible(true);
        beforeCreate.invoke(item);

        GenericItem item2 = new GenericItem() {
        };

        Method beforeCreate2 = GenericItem.class.getDeclaredMethod("onCreate");
        beforeCreate2.setAccessible(true);
        beforeCreate2.invoke(item);
        Assert.assertFalse(item.equals(item2));
    }

    @Test
    public void equalsTest_5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GenericItem item = new GenericItem() {
        };
        Method beforeCreate = GenericItem.class.getDeclaredMethod("onCreate");
        beforeCreate.setAccessible(true);
        beforeCreate.invoke(item);
        GenericItem item2 = new GenericItem() {
        };
        Assert.assertFalse(item.equals(item2));
    }

    @Test
    public void equalsTest_6() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GenericItem item = new ConcreteClassItem();
        GenericItem item2 = new ConcreteClassItem();
        Method beforeCreate = GenericItem.class.getDeclaredMethod("onCreate");
        beforeCreate.setAccessible(true);
        beforeCreate.invoke(item2);
        Assert.assertFalse(item.equals(item2));
    }

    @Test
    public void equalsTest_7() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ConcreteClassItem item = new ConcreteClassItem();
        ConcreteClassItem item2 = new ConcreteClassItem();
        Assert.assertTrue(item.equals(item2));
    }

    @Test
    public void equalsTest_8() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        GenericItem item = new ConcreteClassItem();
        GenericItem item2 = new ConcreteClassItem();
        Field uuid = GenericItem.class.getDeclaredField("uuid");
        uuid.setAccessible(true);
        uuid.set(item, "1234");
        uuid.set(item2, "1234");
        Assert.assertTrue(item.equals(item2));
    }

    @Test
    public void hasCode_2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GenericItem item = new GenericItem() {
        };
        Method beforeCreate = GenericItem.class.getDeclaredMethod("onCreate");
        beforeCreate.setAccessible(true);
        beforeCreate.invoke(item);
        Assert.assertNotNull(item.hashCode());
    }

    @Test
    public void hasTest_1() {
        ConcreteClassItem item = new ConcreteClassItem();
        Assert.assertTrue(item.hashCode() == 0);
    }
}

class ConcreteClassItem extends GenericItem {

}
