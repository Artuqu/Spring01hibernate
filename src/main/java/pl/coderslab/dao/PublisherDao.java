package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Publisher publisher){
    em.persist(publisher);}

    public Publisher findById(long id){
        return em.find(Publisher.class, id);
        }

        public List<Publisher>getAllPublisher(){
            Query query = em.createQuery("SELECT p FROM Publisher p");
            return query.getResultList();
        }
    public void readBooks(Publisher p) {
        Hibernate.initialize(p.getBooks());
    }

    public List<Publisher> findAll() {
        Query q = em.createQuery("SELECT p FROM Publisher p");
        return q.getResultList();
    }

    String joined = String.join("-", "Coders", "Lab"); //wynik: Coders-Lab
}

