package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Astronaut astronaut3;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("lolo", 12);
        this.astronaut1 = new Astronaut("Pesho", 100);
        this.astronaut2 = new Astronaut("Ivan", 90);
        this.astronaut3 = new Astronaut("Toshko", 80);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWithNegativeNumber() {
        new Spaceship("lolo", -12);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWithNull() {
        new Spaceship(null, 12);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWithEmptyString() {
        new Spaceship("   ", 12);
    }

    @Test
    public void testCreateSpaceShipShouldWork() {
        setUp();
        Assert.assertEquals("lolo", spaceship.getName());
        Assert.assertEquals(12, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWithoutCapacity() {
        Spaceship spaceship = new Spaceship("lolo", 1);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWithDuplicate() {
        setUp();
        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    @Test
    public void testAddShouldWork() {
        setUp();
        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());
        spaceship.add(astronaut2);
        Assert.assertEquals(2, spaceship.getCount());
    }
    @Test
    public void testRemoveShouldWork(){
        setUp();
        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());
        spaceship.add(astronaut2);
        spaceship.remove(astronaut1.getName());
        Assert.assertEquals(1, spaceship.getCount());
    }
    @Test()
    public void testRemoveShouldNotWork(){
        setUp();
        spaceship.add(astronaut1);
        Assert.assertEquals(1, spaceship.getCount());
        spaceship.remove("Maya");
        Assert.assertEquals(1, spaceship.getCount());
    }
    @Test
    public void testGetName(){
        setUp();
        Assert.assertEquals("lolo", spaceship.getName());
        Assert.assertEquals(12, spaceship.getCapacity());
    }


}
