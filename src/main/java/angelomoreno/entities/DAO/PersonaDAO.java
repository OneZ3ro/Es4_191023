package angelomoreno.entities.DAO;

import angelomoreno.entities.Evento;
import angelomoreno.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;
    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Nuova persona creata correttamente");
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);
    }

    public void delete(long id) {
        Persona found = em.find(Persona.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La persona è stata cancellata con successo");
        } else {
            System.err.println("La persona con id" + id + " non è stata trovata");
        }
    }

    public void refresh(long id) {
        Persona found = em.find(Persona.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("La persona è stata refreshata con successo");
        } else {
            System.err.println("La persona con id" + id + " non è stata trovata");
        }
    }

}
