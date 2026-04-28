package tn.esprit.arctic.championnat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratSimpleDto {
    private Long idContrat;
    private Float montant;
    private String annee;
    private String sponsorNom;
}

