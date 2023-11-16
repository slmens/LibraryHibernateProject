import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
// a

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",columnDefinition = "serial")
    private int id;

    @Column(name = "book_name",length = 100,nullable = false,unique = true)
    private String name;

    @Column(name = "publication_date")
    private String publicationDate;

    @Column(name = "stock",nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "book2categories",joinColumns = {@JoinColumn(name = "book2categories_book_id")},inverseJoinColumns = {
            @JoinColumn(name = "book2categories_category_id")
    })
    private List<Category> categoryList;

    @ManyToOne
    @JoinColumn(name = "publisher_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;

    public Book() {}

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBookBorrowingList() {
        return bookBorrowingList;
    }

    public void setBookBorrowingList(List<BookBorrowing> bookBorrowingList) {
        this.bookBorrowingList = bookBorrowingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}