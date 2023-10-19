package angelomoreno;

import angelomoreno.entities.DAO.EventoDAO;
import angelomoreno.entities.DAO.LocationDAO;
import angelomoreno.entities.DAO.PartecipazioneDAO;
import angelomoreno.entities.DAO.PersonaDAO;
import angelomoreno.entities.Evento;
import angelomoreno.entities.Location;
import angelomoreno.entities.Partecipazione;
import angelomoreno.entities.Persona;
import angelomoreno.entities.enums.Sesso;
import angelomoreno.entities.enums.Stato;
import angelomoreno.entities.enums.TipoEvento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Es3_181023");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            LocationDAO ld = new LocationDAO(em);
            PartecipazioneDAO partd = new PartecipazioneDAO(em);
            PersonaDAO persd = new PersonaDAO(em);
            EventoDAO ed = new EventoDAO(em);
            Faker faker =  new Faker();

            Location loc1 = new Location("Piazza Duomo", "Milano");
            Location loc2 = new Location("Piazza Leonardo", "Friuli Venezia Giulia");
            Location loc3 = new Location("Piazzale Margherita", "Puglia");
//            ld.save(loc1);
//            ld.save(loc2);
//            ld.save(loc3);

            Evento evento1 = new Evento("Pigiama party", LocalDate.now(), "Per festa compleanno", TipoEvento.PRIVATO, 10, loc1);
            Evento evento2 = new Evento("Party lavoro", LocalDate.now(), "Per 40 anni dall'apertura", TipoEvento.PRIVATO, 40, loc2);
            Evento evento3 = new Evento("Comicon", LocalDate.now(), "Fiera fumetti", TipoEvento.PUBBLICO, 10000, loc3);
//            ed.save(evento1);
//            ed.save(evento2);
//            ed.save(evento3);

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

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
