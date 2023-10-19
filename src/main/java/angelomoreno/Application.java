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
import java.util.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Es4_191023");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
            EventoDAO ed = new EventoDAO(em);
            LocationDAO ld = new LocationDAO(em);
            PartecipazioneDAO partd = new PartecipazioneDAO(em);
            PersonaDAO persd = new PersonaDAO(em);
            Faker faker = new Faker();

//            Set<Persona> personaSet = creaPersoneSet(faker, persd);
//            creaEventiLocationsPartecipazioni(faker, ed, ld, partd, personaSet);

            ed.getConcertiInStreaming(true).forEach(System.out::println);
            Evento eventoFromDB = ed.getById(22);
            System.out.println(eventoFromDB);
            ed.getConcertiPerGenere(GenereConcerto.ROCK).forEach(System.out::println);
            ed.getPartiteVinteInCasa().forEach(System.out::println);
            ed.getPartiteVinteInTrasferta().forEach(System.out::println);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
    public static Set<Persona> creaPersoneSet (Faker faker, PersonaDAO persd) {
        Random rndm = new Random();
        Set<Persona> personaSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            int n = rndm.nextInt(0, 10);
            Persona persona = new Persona(faker.funnyName().name(), faker.funnyName().name(), "prova" + i +"@gmail.com", faker.date().birthday(), n%2==0 ? Sesso.M : Sesso.F);
            persd.save(persona);
        }
        personaSet.addAll(persd.getPersonaList());
        return personaSet;
    }
    public static void creaEventiLocationsPartecipazioni(Faker faker, EventoDAO ed, LocationDAO ld, PartecipazioneDAO partd, Set<Persona> personaSet) {
        Random rndm = new Random();
        List<Persona> personas = new ArrayList<>();
        personas.addAll(personaSet);
        for (int i = 0; i < 20; i++) {
            int n = rndm.nextInt(0,100);
            int goalCasa = rndm.nextInt(0, 5);
            int goalOspiti = rndm.nextInt(0, 5);
            String squadraCasa = faker.funnyName().name();
            String squadraOspiti = faker.funnyName().name();
            Location location = new Location(faker.country().capital(), faker.country().name());
            ld.save(location);
            if (n%2==0) {
                Evento partitaDiCalcio = new PartitaDiCalcio(faker.book().title(), faker.date().birthday(), "Questa è la mia descrizione", n%2==0 ? TipoEvento.PUBBLICO : TipoEvento.PRIVATO, rndm.nextInt(50, 10000), ld.getLocationList().get(rndm.nextInt(0, ld.getLocationList().size())), squadraCasa, squadraOspiti, goalCasa >= goalOspiti ? squadraCasa : squadraOspiti, goalCasa, goalOspiti);
                ed.save(partitaDiCalcio);
                Partecipazione partecipazione = new Partecipazione(personas.get(rndm.nextInt(0, personas.size())), ed.getPartitaDiCalcioList().get(rndm.nextInt(0, ed.getPartitaDiCalcioList().size())), n%2==0 ? Stato.DA_CONFERMARE : Stato.CONFERMATA);
                partd.save(partecipazione);
            } else if (n%3==0){
                int k = rndm.nextInt(0, 1000);
                Evento concerto = new Concerto(faker.book().title(), faker.date().birthday(), "Questa è la mia descrizione", n%2==0 ? TipoEvento.PUBBLICO : TipoEvento.PRIVATO, rndm.nextInt(50, 10000), ld.getLocationList().get(rndm.nextInt(0, ld.getLocationList().size())), k%4==0 ? GenereConcerto.POP : (k%3==0 ? GenereConcerto.ROCK : GenereConcerto.CLASSICO), k%2==0 ? true : false);
                ed.save(concerto);
                Partecipazione partecipazione = new Partecipazione(personas.get(rndm.nextInt(0, personas.size())), ed.getConcertoList().get(rndm.nextInt(0, ed.getConcertoList().size())), n%2==0 ? Stato.DA_CONFERMARE : Stato.CONFERMATA);
                partd.save(partecipazione);
            } else {
                Evento garaDiAtletica = new GaraDiAtletica(faker.book().title(), faker.date().birthday(), "Questa è la mia descrizione", n%2==0 ? TipoEvento.PUBBLICO : TipoEvento.PRIVATO, rndm.nextInt(50, 10000), ld.getLocationList().get(rndm.nextInt(0, ld.getLocationList().size())), personaSet, personas.get(rndm.nextInt(0, personas.size())));
                ed.save(garaDiAtletica);
                Partecipazione partecipazione = new Partecipazione(personas.get(rndm.nextInt(0, personas.size())), ed.getGaraDiAtleticaList().get(rndm.nextInt(0, ed.getGaraDiAtleticaList().size())), n%2==0 ? Stato.DA_CONFERMARE : Stato.CONFERMATA);
                partd.save(partecipazione);
            }
        }
    }
}
