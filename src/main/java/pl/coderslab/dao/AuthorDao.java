package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager em;


    public void saveAuthor(Author author){
        em.persist(author);}

        public List<Author>getAllAuthors(){
            Query q = em.createQuery("SELECT a FROM Author a");
                 return   q.getResultList();
        }
}
