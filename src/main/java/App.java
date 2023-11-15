import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Author author = new Author();
        author.setName("George Young");
        author.setCountry("USA");
        author.setBirthDate("04/02/1954");

        entityManager.persist(author);

        Publisher publisher = new Publisher();
        publisher.setAddress("Test Mahallesi");
        publisher.setName("Carrier");
        publisher.setEstablishmentDate("1999");

        entityManager.persist(publisher);

        Book book = new Book();
        book.setAuthor(author);
        book.setName("Famanas");
        book.setPublicationDate("14/12/2012");
        book.setPublisher(publisher);
        book.setStock(4);

        entityManager.persist(book);

        Book book1 = new Book();
        book1.setStock(6);
        book1.setName("Katil");
        book1.setPublisher(publisher);
        book1.setPublicationDate("04/01/2000");
        book1.setAuthor(author);

        entityManager.persist(book1);

        Category category = new Category();
        category.setDescription("Highes selling books");
        category.setName("Trends");

        entityManager.persist(category);

        Book book2 = entityManager.find(Book.class,1);
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        book2.setCategoryList(categories);

        entityManager.persist(book2);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Mike");
        bookBorrowing.setBook(book1);
        bookBorrowing.setBorrowingDate(LocalDate.now());
        bookBorrowing.setReturnDate(null);

        entityManager.persist(bookBorrowing);




        transaction.commit();



    }
}
