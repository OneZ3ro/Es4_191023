package angelomoreno.entities.DAO;

import angelomoreno.entities.Concerto;
import angelomoreno.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {
    private final EntityManager em;
    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Nuovo evento creato correttamente");
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(long id) {
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'evento è stato cancellato con successo");
        } else {
            System.err.println("L'evento con id" + id + " non è stato trovato");
        }
    }

    public void refresh(long id) {
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.refresh(found);
            transaction.commit();
            System.out.println("L'evento è stato refreshato con successo");
        } else {
            System.err.println("L'evento con id" + id + " non è stato trovato");
        }
    }

    public List<Concerto> getConcertiInStreaming(boolean bol) {
        TypedQuery<Concerto> getConcertiInStreamingQuery = em.createQuery("SELECT x FROM Concerto x WHERE x.in_streaming = :bol", Concerto.class);
        getConcertiInStreamingQuery.setParameter("bol", bol);
        return getConcertiInStreamingQuery.getResultList();
    }

//    public List<Concerto> getConcertiInStreaming() {
//        TypedQuery<Concerto> getConcertiInStreamingQuery = em.createQuery("SELECT x FROM concerti x", Concerto.class);
//        return getConcertiInStreamingQuery.getResultList();
//    }

    public List<Concerto> getConcertiPerGenere() {
        TypedQuery<Concerto> getConcertiPerGenereQuery = em.createQuery("SELECT x FROM Concerto x ORDER BY x.genere", Concerto.class);
        return getConcertiPerGenereQuery.getResultList();
    }
}
