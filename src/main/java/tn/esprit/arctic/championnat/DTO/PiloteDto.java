package tn.esprit.arctic.championnat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PiloteDto {
    private Long idPilote;
    private String libelleP;
    private Integer nbPointsTotal;
    private Integer classementGeneral;
    private String categorie;
    private String equipeLibelle;
}

