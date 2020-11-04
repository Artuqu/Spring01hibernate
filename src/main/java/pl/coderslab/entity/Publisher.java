package pl.coderslab.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "publisher", fetch= FetchType.EAGER)//eager ustawiamy, gdy pisze, że jest problem z sesją

    private List<Book> books = new ArrayList<>();



    public Publisher(){
    }

    public Publisher(String name) {
        this.name = name;

    }

    public List<Book> getBooks() {
        return books;
    }

    public Publisher setBooks(List<Book> books) {
        this.books = books;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
