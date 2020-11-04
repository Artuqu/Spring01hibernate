package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(path = "/book",produces = "text/html; charset=UTF-8")
//@Produces("text/html") adnotacja by wyświetlać text w html, gdzie ją dodać?
public class BookController {

    private final BookDao bookDao;
    private PublisherDao publisherDao;
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, BookRepository bookRepository, CategoryRepository categoryRepository, Author author, Publisher publisher) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.author = author;
        this.publisher = publisher;
    }

    @Autowired


//
//    public BookController(PublisherDao publisherDao, BookDao bookDao){
//        this.publisherDao = publisherDao;
//        this.bookDao = bookDao;
//    }


    @GetMapping(path = "/addbookwp", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String addBookWithPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.save(publisher);

        Book book = new Book()
                .setTitle("Thinking in C++")
                .setDescription("Bardzo dobra książka o programowaniu")
                .setPublisher(publisher);

                bookDao.saveBook(book);
        return "added book id= " + book.getId()
                + " with publisher id= " + publisher.getId();
    }
//
//    produces = "application/json; charset=UTF-8"
    Author author = new Author("Jacek", "Nowakowski");
    Publisher publisher = new Publisher("PWN");

    @GetMapping(value = "/add", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String addBook() {
        Book book = new Book()
        .setTitle("Thinking in Java")
        .setRating(233)
        .setDescription("About smt")
        .setAuthor(author)
        .setPublisher(publisher);

        bookDao.saveBook(book);
        return "Id dodanej książki to: "
                + book.getId();
    }

    @GetMapping(path = "/{id}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    @Transactional
    public String getBook(@PathVariable long id) {
//        Book book = bookDao.findById(id);
        Book book = bookRepository.getOne(id);
        return book.toString();
    }

    @PutMapping("/update/{id}/{title}/{rating}/{description}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title, @PathVariable int rating, @PathVariable String description) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);
        bookDao.update(book);
        return book.toString();
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }


    @GetMapping("/all")
    @ResponseBody
    @Transactional
    public String getAll() {
//        List<Book> books = bookDao.getAll();
        List <Book> books = bookRepository.findAll();
        return books.toString();

    }

    @GetMapping("/byminrating/{minRating}")
    @ResponseBody
    public String getAll(@PathVariable int minRating) {
        List<Book> books = bookDao.findByRatingGT(minRating);

        return books.toString();

    }
    @GetMapping("/bypubid/{pubId}")
    @ResponseBody
    public String getByPubId(@PathVariable long pubId){
        List<Book> books = bookDao.findByPublisherId(pubId);

        return books.toString();
    }


    @GetMapping(path = "title/{title}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    @Transactional
    public String getBook(@PathVariable String title) {
        List <Book> book = this.bookRepository.findBooksByTitle(title);
        return book.toString();
    }

    @GetMapping(path = "cat/{catName}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    @Transactional
    public String getCategory(@PathVariable String catName) {

        List <Book> book = this.bookRepository.findBooksByCategoryName(catName);
        return book.toString();
    }

    @GetMapping("/byCat/{catId}")
    @ResponseBody
    @Transactional
    public String getByCategory(@PathVariable long catId){
        Category category = this.categoryRepository.getOne(catId);

        List<Book> books = this.bookRepository.findBooksByCategory(category);

        return books.toString();
    }


    @GetMapping("/catId/{catId}")
    @ResponseBody
    @Transactional
    public String getByCategoryId(@PathVariable long catId){
        List<Book> books = this.bookRepository.findBooksByCategoryId(catId);

        return books.toString();
    }
//
//    List <Book> findBooksByCategory(Category category);
//    List <Book> findBooksByCategoryId(long categoryId);
//    List <Book> findBooksByCategoryName(String name);

}
