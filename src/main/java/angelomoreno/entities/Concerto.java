package angelomoreno.entities;

import angelomoreno.entities.enums.GenereConcerto;
import angelomoreno.entities.enums.TipoEvento;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {
    @Enumerated(EnumType.STRING)
    @Column(name = "genere_concerto")
    private GenereConcerto genereConcerto;
    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto(){}

    public Concerto(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genereConcerto, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genereConcerto = genereConcerto;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(GenereConcerto genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
