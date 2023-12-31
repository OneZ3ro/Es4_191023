package angelomoreno.entities;

import angelomoreno.entities.enums.TipoEvento;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "persona_garadiatletica", joinColumns = @JoinColumn(name = "gara_di_atletica"), inverseJoinColumns = @JoinColumn(name = "persone"))
    private Set<Persona> atleti;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona vincitore;

    public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() { return vincitore; }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
