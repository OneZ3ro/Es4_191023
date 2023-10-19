package angelomoreno;

import angelomoreno.entities.*;
import angelomoreno.entities.DAO.EventoDAO;
import angelomoreno.entities.DAO.LocationDAO;
import angelomoreno.entities.DAO.PartecipazioneDAO;
import angelomoreno.entities.DAO.PersonaDAO;
import angelomoreno.entities.enums.GenereConcerto;
import angelomoreno.entities.enums.Sesso;
import angelomoreno.entities.enums.Stato;
import angelomoreno.entities.enums.TipoEvento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Es4_191023");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            LocationDAO ld = new LocationDAO(em);
            PartecipazioneDAO partd = new PartecipazioneDAO(em);
            PersonaDAO persd = new PersonaDAO(em);
            EventoDAO ed = new EventoDAO(em);
            Faker faker =  new Faker();

            Persona persona1 = new Persona(faker.funnyName().name(), faker.funnyName().name(), "prova1@gmail.com", faker.date().birthday(), Sesso.M);
            Persona persona2 = new Persona(faker.funnyName().name(), faker.funnyName().name(), "prova1@gmail.com", faker.date().birthday(), Sesso.F);
            Persona persona3 = new Persona(faker.funnyName().name(), faker.funnyName().name(), "prova1@gmail.com", faker.date().birthday(), Sesso.M);
            Persona persona4 = new Persona(faker.funnyName().name(), faker.funnyName().name(), "prova1@gmail.com", faker.date().birthday(), Sesso.F);
            Persona persona5 = new Persona(faker.funnyName().name(), faker.funnyName().name(), "prova1@gmail.com", faker.date().birthday(), Sesso.M);
//            persd.save(persona1);
//            persd.save(persona2);
//            persd.save(persona3);
//            persd.save(persona4);
//            persd.save(persona5);

            Set<Persona> atleti = new HashSet<>();
//            atleti.add(persona1);
//            atleti.add(persona2);
//            atleti.add(persona3);
//            atleti.add(persona4);
//            atleti.add(persona5);

            Location loc1 = new Location("Piazza Duomo", "Milano");
            Location loc2 = new Location("Piazza Leonardo", "Friuli Venezia Giulia");
            Location loc3 = new Location("Piazzale Margherita", "Puglia");
//            ld.save(loc1);
//            ld.save(loc2);
//            ld.save(loc3);

            Evento evento1 = new PartitaDiCalcio("Pigiama party", LocalDate.now(), "Per festa compleanno", TipoEvento.PRIVATO, 10, loc1, "Milan", "Juventus", "Milan", 3, 1);
            Evento evento2 = new GaraDiAtletica("Party lavoro", LocalDate.now(), "Per 40 anni dall'apertura", TipoEvento.PRIVATO, 40, loc2, atleti, persona4);
            Evento evento3 = new Concerto("Concerto Rio", LocalDate.now(), "Concerto mega", TipoEvento.PUBBLICO, 30000, loc3, GenereConcerto.POP, true);
            Evento evento4 = new Concerto("Concerto Milano", LocalDate.now(), "Concerto small", TipoEvento.PUBBLICO, 500, loc3, GenereConcerto.CLASSICO, false);
            Evento evento5 = new Concerto("Concerto Lucca", LocalDate.now(), "Concerto big", TipoEvento.PUBBLICO, 1000, loc2, GenereConcerto.ROCK, true);
//            ed.save(evento1);
//            ed.save(evento2);
//            ed.save(evento3);
//            ed.save(evento4);
//            ed.save(evento5);

            Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Stato.DA_CONFERMARE);
            Partecipazione partecipazione2 = new Partecipazione(persona2, evento1, Stato.DA_CONFERMARE);
            Partecipazione partecipazione3 = new Partecipazione(persona3, evento2, Stato.DA_CONFERMARE);
            Partecipazione partecipazione4 = new Partecipazione(persona4, evento3, Stato.CONFERMATA);
            Partecipazione partecipazione5 = new Partecipazione(persona5, evento3, Stato.CONFERMATA);
//            partd.save(partecipazione1);
//            partd.save(partecipazione2);
//            partd.save(partecipazione3);
//            partd.save(partecipazione4);
//            partd.save(partecipazione5);

            Evento eventoFromDb = ed.getById(20);
            if (eventoFromDb != null) {
                System.out.println(eventoFromDb);
            }

            Location locationFromDb = ld.getById(17);
            if (locationFromDb != null) {
                System.out.println(locationFromDb);
            }

            Persona personaFromDb = persd.getById(26);
            if (personaFromDb != null) {
                System.out.println(personaFromDb);
            }

            Partecipazione partecipazioneFromDb = partd.getById(30);
            if (partecipazioneFromDb != null) {
                System.out.println(partecipazioneFromDb);
            }

            ed.getConcertiInStreaming(true).forEach(concerto -> System.out.println(concerto));
            ed.getPartiteDiCalcio().forEach(partitaDiCalcio -> System.out.println(partitaDiCalcio));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
