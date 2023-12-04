package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Animal animal1;
    private Animal animal2;
    private Farm testFarm;

    @Before
    public void setUp() {
        animal1 = new Animal("lion", 10);
        animal2 = new Animal("chicken", 50);
        testFarm = new Farm("lala", 15);
    }

    @Test
    public void testShouldCreateFarmSuccessfully() {
        Farm farm = new Farm("lala", 15);
        Assert.assertEquals("lala", farm.getName());
        Assert.assertEquals(15, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForNullName() {
        new Farm(null, 15);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForEmptyName() {
        new Farm("", 15);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionForWhitespaceName() {
        new Farm("   ", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNegativeCapacity() {
        new Farm("lala", -14);
    }

    @Test
    public void testAddShouldBeSuccessfull() {
        testFarm.add(animal1);
        Assert.assertEquals(1, testFarm.getCount());


        testFarm.add(animal2);
        Assert.assertEquals(2, testFarm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowExceptionForNoCapacity() {
        Farm farm = new Farm("lala", 1);
        farm.add(animal1);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowExceptionForExistingAnimal() {
        Farm farm = new Farm("lala", 12);
        farm.add(animal1);
        farm.add(animal1);
    }

    @Test
    public void testRemoveIsSuccessful() {
        testFarm.add(animal1);
        testFarm.add(animal2);
        Assert.assertTrue(testFarm.remove(animal1.getType()));
        Assert.assertEquals(1, testFarm.getCount());
    }

    @Test
    public void testNotRemove() {
        testFarm.add(animal1);
        testFarm.add(animal2);
        Assert.assertTrue(testFarm.remove(animal2.getType()));
        Assert.assertEquals(1, testFarm.getCount());
    }
}
