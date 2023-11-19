package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {3, 4, 5, 8, 9, 10};

    @Before
    public void prepareDataBase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreatesCorrectObject() throws OperationNotSupportedException {

        Integer[] databaseElements = database.getElements();
        Assert.assertArrayEquals("Arrays are not the same!", NUMBERS, databaseElements);
        Assert.assertEquals("Count of elements is incorrect!", database.getElementsCount(), NUMBERS.length);
        Assert.assertEquals("Index is incorrect!", NUMBERS.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionLessThanOneElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionForNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {

        Integer[] elementsBefore = database.getElements();

        database.add(64);
        Integer[] elementsAfter = database.getElements();

        Assert.assertEquals("Invalid add operation!", elementsBefore.length + 1, elementsAfter.length);

        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(64));
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Integer[] elementsBefore = database.getElements();
        database.remove();

        Integer[] elementsAfter = database.getElements();

        Assert.assertEquals("Invalid remove operation!" ,elementsBefore.length - 1, elementsAfter.length);
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(9));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowsExceptionWhenInvalidIndex() throws OperationNotSupportedException {
//        database = new Database(new Integer[0]);
//        database.remove();
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

}
