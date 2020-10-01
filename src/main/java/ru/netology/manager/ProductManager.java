package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String search) {

        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, search) == true) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    //sfdg





    public boolean matches(Product product, String search) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}

//public class AfishaManager {
//    int movieNumber = 10;
//
//    private AfishaRepository repository;
//
//    public  AfishaManager (AfishaRepository repository) {
//        this.repository = repository;
//    }
//
//    public AfishaManager (int movieNumber) {
//        this.movieNumber = movieNumber;
//    }
//
//    public void add(MoviesList index) {
//        repository.save(index);
//    }
//
//    public MoviesList[] getAll() {
//        MoviesList[] movies = repository.findAll();
//        int length = movies.length;
//        if (length < this.movieNumber) {
//            MoviesList[] result = new MoviesList[movies.length];
//
//            // перебираем массив в прямом порядке
//            // но кладём в результаты в обратном
//            for (int i = 0; i < result.length; i++) {
//                int index = movies.length - i - 1;
//                result[i] = movies[index];
//            }
//            return result;
//        } else {
//            MoviesList[] result = new MoviesList[this.movieNumber];
//            // перебираем массив в прямом порядке
//            // но кладём в результаты в обратном
//            for (int i = 0; i < result.length; i++) {
//                int index = movies.length - i - 1;
//                result[i] = movies[index];
//            }
//            return result;
//        }
//    }
//}