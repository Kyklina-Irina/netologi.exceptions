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
    @Test
    void shouldAddNewProductSuccessfully() {
        ShopRepository repo = new ShopRepository();
        Product book = new Product(1, "Book", 500);

        repo.add(book);

        Product[] expected = {book};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldThrowAlreadyExistsExceptionWhenAddingDuplicateId() {
        ShopRepository repo = new ShopRepository();
        Product book1 = new Product(1, "Book", 500);
        Product book2 = new Product(1, "Another Book", 700); // тот же ID

        repo.add(book1);

        assertThrows(AlreadyExistsException.class, () -> repo.add(book2));
    }
}