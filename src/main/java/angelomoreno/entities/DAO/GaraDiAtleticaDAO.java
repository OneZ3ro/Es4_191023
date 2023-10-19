package angelomoreno.entities.DAO;

import angelomoreno.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GaraDiAtleticaDAO {
    private final EntityManager em;
    public GaraDiAtleticaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(GaraDiAtleticaDAO garaDiAtletica) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(garaDiAtletica);
        transaction.commit();
        System.out.println("Nuova gara di atletica creata correttamente");
    }

    public GaraDiAtleticaDAO getById(long id) {
        return em.find(GaraDiAtleticaDAO.class, id);
    }

    public void delete(long id) {
        GaraDiAtleticaDAO found = em.find(GaraDiAtleticaDAO.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La gara di atletica è stata cancellata con successo");
        } else {
            System.err.println("La gara di atletica con id" + id + " non è stata trovata");
        }
    }

    public void refresh(long id) {
        GaraDiAtleticaDAO found = em.find(GaraDiAtleticaDAO.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("La gara di atletica è stata refreshata con successo");
        } else {
            System.err.println("La gara di atletica con id" + id + " non è stata trovata");
        }
    }

}
