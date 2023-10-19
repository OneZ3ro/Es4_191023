package angelomoreno.entities.DAO;

import angelomoreno.entities.Partecipazione;
import angelomoreno.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartitaDiCalcioDAO {
    private final EntityManager em;
    public PartitaDiCalcioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PartitaDiCalcio partitaDiCalcio) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partitaDiCalcio);
        transaction.commit();
        System.out.println("Nuova partita di calcio creata correttamente");
    }

    public PartitaDiCalcio getById(long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public void delete(long id) {
        PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La partita di calcio è stata cancellata con successo");
        } else {
            System.err.println("La partita di calcio con id" + id + " non è stata trovata");
        }
    }

    public void refresh(long id) {
        PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("La partita di calcio è stata refreshata con successo");
        } else {
            System.err.println("La partita di calcio con id" + id + " non è stata trovata");
        }
    }

}
