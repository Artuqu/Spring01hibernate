package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping(path = "/validation",produces = "text/html; charset=UTF-8")
public class ValidationController {

    private Validator validator;
    private BookDao bookDao;

    @Autowired
    public ValidationController(Validator validator, BookDao bookDao) {
        this.validator = validator;
        this.bookDao = bookDao;
    }



    @GetMapping(path = "/example1" )
    @ResponseBody
    public String example1(){
        Book b = new Book();
        Set<ConstraintViolation<Book>> violations = this.validator.validate(b);

        String msg;
        if(violations.isEmpty()){
            bookDao.saveBook(b);
            msg = "Zapisano: " + b.toString();
        }
        else {
            msg = "Błędy walidacji:<br>\r\n";
            for(ConstraintViolation<Book> v : violations){
                msg += v.getPropertyPath() + " : " + v.getMessage() + "<br>\r\n";
            }
        }

        return msg;
    }


    @GetMapping(path = "/exampleV" )

    public String exampleV(Model m) {
        Book b = new Book();
        Set<ConstraintViolation<Book>> violations = this.validator.validate(b);
       m.addAttribute("violantions",violations);

return "/validation/show";

    }
}
