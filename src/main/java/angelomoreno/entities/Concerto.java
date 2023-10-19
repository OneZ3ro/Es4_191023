package angelomoreno.entities;

import angelomoreno.entities.enums.GenereConcerto;
import angelomoreno.entities.enums.TipoEvento;
import angelomoreno.entities.enums.VeroOFalso;

import java.time.LocalDate;

public class Concerto extends Evento {
    private GenereConcerto genereConcerto;
    private VeroOFalso inStreaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genereConcerto, VeroOFalso inStreaming) {
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

    public VeroOFalso getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(VeroOFalso inStreaming) {
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
