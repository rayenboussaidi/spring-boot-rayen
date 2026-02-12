package tn.esprit.arctic.championnat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPilote;

    private String libelleP;

    private Integer nbPointsTotal;

    private Integer classementGeneral;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    @OneToMany(mappedBy = "pilote", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Position> positions = new java.util.HashSet<>();

    @OneToMany
    @JoinColumn(name = "pilote_id")
    private Set<Sponsor> sponsors = new java.util.HashSet<>();
}
