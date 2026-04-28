package tn.esprit.arctic.championnat.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratActifParEquipeDto {
    private String equipeLibelle;
    private List<ContratSimpleDto> contrats;
}

