package angelomoreno.entities;

import angelomoreno.entities.enums.Stato;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long partecipazione_id;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(){};
    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getPartecipazione_id() {
        return partecipazione_id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "partecipazione_id=" + partecipazione_id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
