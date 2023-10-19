package angelomoreno.entities.DAO;

import angelomoreno.entities.Concerto;
import angelomoreno.entities.Evento;
import angelomoreno.entities.GaraDiAtletica;
import angelomoreno.entities.PartitaDiCalcio;
import angelomoreno.entities.enums.GenereConcerto;

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

    public List<Concerto> getConcertiInStreaming(boolean booleano) {
        TypedQuery<Concerto> getConcertiInStreamingQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :booleano", Concerto.class);
        getConcertiInStreamingQuery.setParameter("booleano", booleano);
        return getConcertiInStreamingQuery.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genereConcerto) {
        TypedQuery<Concerto> getConcertiPerGenereQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.genere_concerto=:genere", Concerto.class);
        getConcertiPerGenereQuery.setParameter("genere", genereConcerto);
        return getConcertiPerGenereQuery.getResultList();
    }

    public List<PartitaDiCalcio> getPartitaDiCalcioList() {
        TypedQuery<PartitaDiCalcio> getPartitaDiCalcioListQuery = em.createQuery("SELECT p FROM PartitaDiCalcio p", PartitaDiCalcio.class);
        return getPartitaDiCalcioListQuery.getResultList();
    }

    public List<GaraDiAtletica> getGaraDiAtleticaList() {
        TypedQuery<GaraDiAtletica> getGaraDiAtleticaListQuery = em.createQuery("SELECT g FROM GaraDiAtletica g", GaraDiAtletica.class);
        return getGaraDiAtleticaListQuery.getResultList();
    }

    public List<Concerto> getConcertoList() {
        TypedQuery<Concerto> getConcertoListQuery = em.createQuery("SELECT c FROM Concerto c", Concerto.class);
        return getConcertoListQuery.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraDiCasa = p.squadraVincente", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.squadraOspite = p.squadraVincente", PartitaDiCalcio.class).getResultList();
    }
}
