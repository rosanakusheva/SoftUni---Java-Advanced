import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class InstockTest {
    private ProductStock stock;

    @Before
    public void setUp() {
        this.stock = new Instock();
    }

    @Test
    public void testContainsAndAdd() {
        Product product = new Product("water", 1.20, 2);
        Assert.assertFalse(this.stock.contains(product));
        this.stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, this.stock.getCount());
        fillStock();
        Assert.assertEquals(3, this.stock.getCount());
    }

    @Test
    public void testFindReturnsCorrectProduct() {

        fillStock();

        Product foundProduct = this.stock.find(2);
        Assert.assertEquals(foundProduct.getLabel(), "cheese");
        Assert.assertEquals(foundProduct.getQuantity(), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowsExceptionWhenIndexGreater() {
        fillStock();
        this.stock.find(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowsExceptionWhenIndexNegative() {
        fillStock();
        this.stock.find(-1);
    }

    private void fillStock() {
        Product product = new Product("water", 1.20, 2);
        Product product1 = new Product("bread", 2.90, 3);
        Product product2 = new Product("cheese", 3.90, 4);
        stock.add(product);
        stock.add(product1);
        stock.add(product2);
    }

    @Test
    public void testChangeQuantitySuccessfulUpdate() {
        fillStock();
        Product productBread = this.stock.find(1);
        this.stock.changeQuantity("bread", 9);
        Assert.assertEquals(productBread.getQuantity(), 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowsExceptionForInvalidProduct() {
        fillStock();
        this.stock.changeQuantity("wine", 8);

    }

    @Test
    public void testFindByLabelReturnsCorrectProduct() {
        fillStock();
        Product expectedProduct = this.stock.find(0);
        Product returnedProduct = this.stock.findByLabel("water");
        Assert.assertEquals(returnedProduct.getLabel(), expectedProduct.getLabel());
        Assert.assertEquals(returnedProduct.getQuantity(), expectedProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelThrowsExceptionForInvalidProduct() {
        fillStock();
        this.stock.findByLabel("potato");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsCorrectCountProducts() {
        fillStock();
        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(2);
        int countGetProducts = 0;
        for (Product product : iterable) {
            countGetProducts++;
        }
        Assert.assertEquals(2, countGetProducts);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsCorrectSorting() {
        List<String> expectedProductLabels = new ArrayList<>();
        Product product = new Product("water", 1.20, 2);
        Product product1 = new Product("bread", 1.90, 3);
        Product product2 = new Product("cheese", 3.90, 4);

        this.stock.add(product);
        expectedProductLabels.add(product.getLabel());
        this.stock.add(product1);
        expectedProductLabels.add(product1.getLabel());
        this.stock.add(product2);
        expectedProductLabels.add(product2.getLabel());

        expectedProductLabels = expectedProductLabels.stream()
                .sorted()
                .collect(Collectors.toList());

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(3);
        List<String> returnedProductLabels = new ArrayList<>();

        for (Product productt : iterable) {
            returnedProductLabels.add(product.getLabel());
        }
        Assert.assertEquals(expectedProductLabels, returnedProductLabels);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderThrowsInvalidCount() {
        fillStock();
        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(5);
        int count = 0;
        for (Product product : iterable) {
            count++;
        }

        Assert.assertTrue(count == 0);

    }

    @Test
    public void testFindAllInPriceRange() {
        fillStock();
        Iterable<Product> returnedProducts = this.stock.findAllInRange(1.10, 3.50);
        int count = 0;
        for (Product returnedProduct : returnedProducts) {
            count++;
        }
        Assert.assertEquals(2, count);
    }

    @Test
    public void testFindAllInPriceRangeReturnsCorrectOrder() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllInRange(1.10, 2.95);
        List<Product> returnedProducts = getProductsFromIterable(iterable);
        Assert.assertEquals("bread", returnedProducts.get(0).getLabel());
        Assert.assertEquals("water", returnedProducts.get(1).getLabel());
    }

    @Test
    public void testFindAllInPriceRangeReturnsNoMatch() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllInRange(10, 20);
        Assert.assertFalse(iterable.iterator().hasNext());

    }

    @Test
    public void testFindAllByPriceReturnsCorrectProducts() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByPrice(3.90);
        List<Product> returnedProducts = getProductsFromIterable(iterable);

        Assert.assertEquals(1, returnedProducts.size());
        Assert.assertEquals("cheese", returnedProducts.get(0).getLabel());
    }

    @Test
    public void testFindAllByPriceReturnsEmptyProducts() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByPrice(13.90);
        Assert.assertFalse(iterable.iterator().hasNext());
    }

    @Test
    public void testFindAllByQuantityReturnsCorrectProducts() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByQuantity(2);
        List<Product> returnedProducts = getProductsFromIterable(iterable);

        Assert.assertEquals(1, returnedProducts.size());
        Assert.assertEquals("water", returnedProducts.get(0).getLabel());
    }
    @Test
    public void testFindAllByQuantityReturnsEmptyProducts() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByQuantity(10);
        Assert.assertFalse(iterable.iterator().hasNext());
    }

    @Test
    public void testIterator() {
        fillStock();
        Iterator<Product> iterator = this.stock.iterator();
        List<Product> returnedProducts = new ArrayList<>();
        while (iterator.hasNext()) {
            returnedProducts.add(iterator.next());
        }
        Assert.assertEquals(3, returnedProducts.size());
    }

    private static List<Product> getProductsFromIterable(Iterable<Product> iterable) {
        List<Product> returnedProducts = new ArrayList<>();

        for (Product product : iterable) {
            returnedProducts.add(product);
        }
        return returnedProducts;
    }


}