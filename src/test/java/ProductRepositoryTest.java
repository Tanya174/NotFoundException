import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductRepositoryTest {


    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Maths", 100, "Pythagor");
        Book book2 = new Book(2, "Mathematics", 200, "Archimed");
        Book book3 = new Book(3, "Physics", 300, "Newtone");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.removeById(1);

        Product[] expected = {book2, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductNotExist() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Maths", 100, "Pythagor");
        Book book2 = new Book(2, "Mathematics", 200, "Archimed");
        Book book3 = new Book(3, "Physics", 300, "Newtone");

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }


    @Test
    public void shouldRemoveByIdSmartphone() {
        ProductRepository repository = new ProductRepository();

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 200, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Lenovo", 300, "China");

        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);
        repository.removeById(2);

        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdSmartphoneWhenProductNotExist() {
        ProductRepository repository = new ProductRepository();

        Smartphone smartphone1 = new Smartphone(1, "IPhone", 100, "USA");
        Smartphone smartphone2 = new Smartphone(2, "Samsung", 200, "Korea");
        Smartphone smartphone3 = new Smartphone(3, "Lenovo", 300, "China");

        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(66);
        });
    }
}

