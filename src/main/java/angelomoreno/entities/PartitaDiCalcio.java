package angelomoreno.entities;

import angelomoreno.entities.enums.TipoEvento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "partite_di_calcio")
//@NamedQuery(name = "get_partite_vinte_in_casa", query = "SELECT p FROM partite_di_calcio p WHERE p.squadraDiCasa = p.squadraVincente")
//@NamedQuery(name = "get_partite_vinte_in_trasferta", query = "SELECT p FROM partite_di_calcio p WHERE p.squadraOspite = p.squadraVincente")
public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "goal_casa")
    private int goalCasa;
    @Column(name = "goal_ospiti")
    private int goalOspiti;

    public PartitaDiCalcio(){}
    public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int goalCasa, int goalOspiti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalCasa = goalCasa;
        this.goalOspiti = goalOspiti;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGoalCasa() {
        return goalCasa;
    }

    public void setGoalCasa(int goalCasa) {
        this.goalCasa = goalCasa;
    }

    public int getGoalOspiti() {
        return goalOspiti;
    }

    public void setGoalOspiti(int goalOspiti) {
        this.goalOspiti = goalOspiti;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", goalCasa=" + goalCasa +
                ", goalOspiti=" + goalOspiti +
                '}';
    }
}
