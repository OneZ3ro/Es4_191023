package angelomoreno.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    private long location_id;
    private String nome;
    private String city;
    @OneToMany (mappedBy = "location")
    private List<Evento> eventi;

    public Location(){};

    public Location(String nome, String city) {
        this.nome = nome;
        this.city = city;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getLocation_id() {
        return location_id;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", nome='" + nome + '\'' +
                ", city='" + city + '\'' +
                ", eventi=" + eventi +
                '}';
    }
}
