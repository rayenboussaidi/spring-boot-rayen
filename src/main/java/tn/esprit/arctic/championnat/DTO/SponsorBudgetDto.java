package tn.esprit.arctic.championnat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SponsorBudgetDto {
    private Long idSponsor;
    private String nom;
    private Float budgetAnnuel;
    private Double pourcentageConsomme;
    private String message;
}

