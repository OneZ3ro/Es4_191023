package angelomoreno.entities;

import angelomoreno.entities.enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue
    private long evento_id;
    private String titolo;
    private LocalDate dataEvento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany (mappedBy = "evento")
    private Set<Partecipazione> partecipazione;

    public Evento(){};

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public long getEvento_id() {
        return evento_id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Set<Partecipazione> getPartecipazione() {
        return partecipazione;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "evento_id=" + evento_id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
//                ", location=" + location +
//                ", partecipazione=" + partecipazione +
                '}';
    }
}
