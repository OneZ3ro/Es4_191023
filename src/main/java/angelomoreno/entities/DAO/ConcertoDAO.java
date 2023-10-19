package angelomoreno.entities.DAO;

import angelomoreno.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ConcertoDAO {
    private final EntityManager em;
    public ConcertoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ConcertoDAO concerto) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(concerto);
        transaction.commit();
        System.out.println("Nuovo concerto creato correttamente");
    }

    public ConcertoDAO getById(long id) {
        return em.find(ConcertoDAO.class, id);
    }

    public void delete(long id) {
        ConcertoDAO found = em.find(ConcertoDAO.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'concerto è stato cancellato con successo");
        } else {
            System.err.println("L'concerto con id" + id + " non è stato trovato");
        }
    }

    public void refresh(long id) {
        ConcertoDAO found = em.find(ConcertoDAO.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("L'concerto è stato refreshato con successo");
        } else {
            System.err.println("L'concerto con id" + id + " non è stato trovato");
        }
    }

}
