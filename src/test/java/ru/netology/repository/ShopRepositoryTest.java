package ru.netology.repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    void shouldRemoveByIdWhenExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Book", 500);
        Product product2 = new Product(2, "Pen", 100);

        repo.add(product1);
        repo.add(product2);

        repo.removeById(1);

        Product[] expected = {product2};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product = new Product(1, "Book", 500);
        repo.add(product);

        assertThrows(NotFoundException.class, () -> repo.removeById(999));
    }
}