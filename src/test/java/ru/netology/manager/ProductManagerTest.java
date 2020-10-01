package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

    public class ProductManagerTest {

        private ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        private Book addBook1 = new Book(1, "Name1", 500, "Author1");
        private Book addBook2 = new Book(2, "Name2", 600, "Author2");
        private Book addBook3 = new Book(3, "Name3", 400, "Author3");
        private Book addBook4 = new Book(4, "Name4", 200, "Author4");
        private Book addBook5 = new Book(5, "Name5", 700, "Author5");
        private Smartphone addSmartphone1 = new Smartphone(6, "Name6", 5_000, "Producer1");
        private Smartphone addSmartphone2 = new Smartphone(7, "Name7", 10_000, "Producer2");
        private Smartphone addSmartphone3 = new Smartphone(8, "Name8", 20_000, "Producer3");
        private Smartphone addSmartphone4 = new Smartphone(9, "Name9", 30_000, "Producer4");
        private Smartphone addSmartphone5 = new Smartphone(10, "Name10", 50_000, "Producer5");


        @Test
        public void shouldEqualsAuthorBook() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Book[] expected = new Book[]{addBook1};
            Product[] actual = manager.searchBy("Author1");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldEqualsNameBook() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Book[] expected = new Book[]{addBook4};
            Product[] actual = manager.searchBy("Name4");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldEqualsProducerSmartphone() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Smartphone[] expected = new Smartphone[]{addSmartphone5};
            Product[] actual = manager.searchBy("Producer5");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldEqualsNameSmartphone() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Smartphone[] expected = new Smartphone[]{addSmartphone4};
            Product[] actual = manager.searchBy("Name9");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotEqualsNameSmartphone() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Smartphone[] expected = new Smartphone[]{};
            Product[] actual = manager.searchBy("Name999");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotEqualsProducerSmartphone() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Smartphone[] expected = new Smartphone[]{};
            Product[] actual = manager.searchBy("Producer13468");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotEqualsNameBook() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Smartphone[] expected = new Smartphone[]{};
            Product[] actual = manager.searchBy("Name999");
            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldNotEqualsAuthorBook() {
            manager.add(addBook1);
            manager.add(addBook2);
            manager.add(addBook3);
            manager.add(addBook4);
            manager.add(addBook5);
            manager.add(addSmartphone1);
            manager.add(addSmartphone2);
            manager.add(addSmartphone3);
            manager.add(addSmartphone4);
            manager.add(addSmartphone5);

            Smartphone[] expected = new Smartphone[]{};
            Product[] actual = manager.searchBy("Author13468");
            assertArrayEquals(expected, actual);
        }
    }