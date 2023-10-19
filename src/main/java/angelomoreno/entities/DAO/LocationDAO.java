package angelomoreno.entities.DAO;

import angelomoreno.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LocationDAO {
    private final EntityManager em;
    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Nuova location creata correttamente");
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void delete(long id) {
        Location found = em.find(Location.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La location è stato cancellata con successo");
        } else {
            System.err.println("La location con id" + id + " non è stata trovata");
        }
    }

    public void refresh(long id) {
        Location found = em.find(Location.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("La location è stata refreshata con successo");
        } else {
            System.err.println("La location con id" + id + " non è stata trovata");
        }
    }

    public List<Location> getLocationList() {
        TypedQuery<Location> getLocationListQuery = em.createQuery("SELECT l FROM Location l", Location.class);
        return getLocationListQuery.getResultList();
    }
}
