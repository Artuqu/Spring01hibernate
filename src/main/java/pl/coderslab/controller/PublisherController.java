package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping("/publisher")
@ResponseBody
public class PublisherController {
    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/all")
    @ResponseBody
    public String getAllPublisher() {
        List<Publisher> publishers = publisherDao.getAllPublisher();
        return publishers.toString();


    }
    @GetMapping("/books/{publisherId}")
    @ResponseBody
    @Transactional
    public String getBookById(@PathVariable long publisherId){
        Publisher p = publisherDao.findById(publisherId);
        publisherDao.readBooks(p);

        return p.getBooks().toString();
    }

}
