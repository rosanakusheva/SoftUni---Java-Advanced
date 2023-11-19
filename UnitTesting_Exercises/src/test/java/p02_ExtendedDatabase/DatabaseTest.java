package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "Maya"),
            new Person(2, "Plamen"),
            new Person(3, "Vasil")};

    @Before
    public void prepareDataBase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorCreatesCorrectObject() throws OperationNotSupportedException {

        Person[] databaseElements = database.getElements();
        Assert.assertArrayEquals("Arrays are not the same!", PEOPLE, databaseElements);
        Assert.assertEquals("Count of elements is incorrect!", database.getElementsCount(), PEOPLE.length);
        Assert.assertEquals("Index is incorrect!", PEOPLE.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionLessThanOneElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionForNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {

        Person[] elementsBefore = database.getElements();

        database.add(new Person(4, "Hristo"));
        Person[] elementsAfter = database.getElements();

        Assert.assertEquals("Invalid add operation!", elementsBefore.length + 1, elementsAfter.length);
        Person lastPerson = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(lastPerson.getId(), 4);
        Assert.assertEquals(lastPerson.getUsername(), "Hristo");
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Person[] elementsBefore = database.getElements();
        database.remove();

        Person[] elementsAfter = database.getElements();

        Assert.assertEquals("Invalid remove operation!", elementsBefore.length - 1, elementsAfter.length);
        Person currentLast = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(currentLast.getUsername(), "Plamen");
        Assert.assertEquals(currentLast.getId(), 2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowsExceptionWhenInvalidIndex() throws OperationNotSupportedException {
//        database = new Database(new Integer[0]);
//        database.remove();
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExceptionWhenNullParam() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Plamen");

        Assert.assertEquals("Invalid ID of the taken person", person.getId(), 2);
        Assert.assertEquals("Invalid username of the taken person", person.getUsername(), "Plamen");

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4, "Vasil"));
        database.findByUsername("Vasil");

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfNoneExistingUser() throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        Person person = database.findById(3);
        Assert.assertEquals("Invalid ID of the taken person", person.getId(), 3);
        Assert.assertEquals("Invalid username of the taken person", person.getUsername(), "Vasil");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWhenMoreThanOneById() throws OperationNotSupportedException {
        database.add(new Person(3, "Ivan"));
        database.findById(3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowsExceptionWhenNonExistingId() throws OperationNotSupportedException {
        database.findById(4);
    }
}
