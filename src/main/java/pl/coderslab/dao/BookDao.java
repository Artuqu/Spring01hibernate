package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    //private EntityManager entityManager;
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);

    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        Query q = entityManager.createQuery("SELECT b FROM Book b");
        return q.getResultList();
    }

    public List<Book> findByRatingGT(int rating) {
        Query q = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating> :minRating");
        q.setParameter("minRating", rating);
        return q.getResultList();
    }
    public List<Book> findByPublisherId(long publisherId) {
        Query q = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher.id = :pubId");
        q.setParameter("pubId", publisherId);

        return q.getResultList();
    }


}

