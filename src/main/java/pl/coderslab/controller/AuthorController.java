package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorDao authorDao;

    @Autowired
    public AuthorController (AuthorDao authorDao){
        this.authorDao=authorDao;
    }

    @GetMapping("/all")
    @ResponseBody
    public String getAllAuthors() {
        List<Author> authors = authorDao.getAllAuthors();

        return authors.toString();

    }

}
