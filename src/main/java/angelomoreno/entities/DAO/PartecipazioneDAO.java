package angelomoreno.entities.DAO;

import angelomoreno.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;
    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Nuova pertecipazione creata correttamente");
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(long id) {
        Partecipazione found = em.find(Partecipazione.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La partecipazione è stato cancellata con successo");
        } else {
            System.err.println("La partecipazione con id" + id + " non è stata trovata");
        }
    }

    public void refresh(long id) {
        Partecipazione found = em.find(Partecipazione.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("La partecipazione è stata refreshata con successo");
        } else {
            System.err.println("La partecipazione con id" + id + " non è stata trovata");
        }
    }

}
