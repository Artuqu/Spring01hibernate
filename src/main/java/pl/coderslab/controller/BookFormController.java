package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bookform")
public class BookFormController {

    private PublisherDao publisherDao;
    private BookDao bookDao;
    private AuthorDao authorDao;

    @Autowired //adnotacja, która wskazuje, że w tym miejscu dokonujemy wstrzyknięcia
    public BookFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }


    @GetMapping("/addform")
    public String addForm(Model m){
        m.addAttribute("book", new Book());
        return "book/add-form";
    }

    @PostMapping("/addform")
    public String addFormPost(@ModelAttribute ("book") @Valid Book book, BindingResult result, Model m){
       if (result.hasErrors()){
           return "book/add-form";
       }
        this.bookDao.saveBook(book);
        m.addAttribute("book", book);

        return "redirect:list";
    }

@GetMapping("/list")
public String list(){
        return "book/list";
}

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.findAll();
    }

    @ModelAttribute("books")
    public List<Book> books(){
        return bookDao.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.getAllAuthors();
    }
}
