package pl.coderslab.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(long categoryId);

    List<Book> findBooksByCategoryName(String name);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByPublisher(Publisher publisher);

    List<Book> findBookByRating(String rating);

    Book findFirstBookByCategoryAndOrderByTitle(Category category);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findMyFavouriteBooksByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.category = :cat")
    List<Book> findAllBooksBelongToCategory(@Param("cat") Category category);

    @Query("SELECT b FROM Book b WHERE b.rating between 3 and 5")
    List<Book> findBookByRating();


    @Query("SELECT b FROM Book b WHERE b.publisher = :pub")
    List<Book> findBookByPublisher(@Param("pub") Publisher publisher);

    @Query("SELECT b FROM Book b WHERE b.category = :cat ORDER BY b.title")
    Book findFirstBookByCatAndSortByTitle (@Param("cat") Category category);

    @Query("SELECT b FROM Book b WHERE ?1 MEMBER OF b.authors")//colection type expected
    List <Book> findAllBooksByAuthor (Author author);

//    W repozytorium dla klasy `Book` utwórz pobierające dane za pomocą zapytań `Query`:
//            - Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
//            - Listę książek dla zadanego wydawcy.
//- Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.
//




    //- Listę książek dla zadanego autora.
//- Listę książek dla zadanego wydawcy
//- Listę książek dla określonego ratingu
//- Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.

}
