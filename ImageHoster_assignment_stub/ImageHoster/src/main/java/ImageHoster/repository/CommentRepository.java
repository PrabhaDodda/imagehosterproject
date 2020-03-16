package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c",Comment.class);
        List<Comment> resultList = query.getResultList();
        return resultList;
    }

    public void createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
