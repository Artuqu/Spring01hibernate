package pl.coderslab.entity;


import org.hibernate.annotations.Generated;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "books")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;
    @Min(1)
    private int pages;




    @ManyToOne(cascade = {CascadeType.ALL})
    @NotNull
    private Publisher publisher;

    @ManyToOne(cascade = {CascadeType.ALL})
    @NotNull
    private Author author;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Category category;

    @ManyToMany
    private List<Author> authors; //tworzenie kolekcji przy relacji wiele do wiele



    public Book(){
    }

//    public Book(long id, String title, int rating, String description, Publisher publisher, Author author) {
//        this.id = id;
//        this.title = title;
//        this.rating = rating;
//        this.description = description;
//        this.publisher = publisher;
//        this.author = author;
//    }

    public long getId() {
        return id;
    }

    public Book setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Book setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", publisher=" + publisher +
                ", author=" + author +
                ", category=" + category +
                '}';
    }
}
