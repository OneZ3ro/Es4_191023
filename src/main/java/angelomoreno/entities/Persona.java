package angelomoreno.entities;

import angelomoreno.entities.enums.Sesso;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private long persona_id;

    private String nome;
    private String cognome;
    private String email;
    private Date dataDiNascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;
    @OneToMany (mappedBy = "persona")
    private List<Partecipazione> partecipazioni;

    public Persona(){};

    public Persona(String nome, String cognome, String email, Date dataDiNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public long getPersona_id() {
        return persona_id;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "persona_id=" + persona_id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
//                ", partecipazioni=" + partecipazioni +
                '}';
    }
}
