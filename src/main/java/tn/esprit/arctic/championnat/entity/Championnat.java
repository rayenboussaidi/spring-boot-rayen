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
public class Championnat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChampionnat;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    private String libelleC;

    private Integer annee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_championnat_code")
    private DetailChampionnat detailChampionnat;

    @OneToMany(mappedBy = "championnat", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> courses = new java.util.HashSet<>();
}
