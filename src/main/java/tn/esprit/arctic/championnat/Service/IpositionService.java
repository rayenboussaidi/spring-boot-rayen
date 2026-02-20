package tn.esprit.arctic.championnat.Service;

import tn.esprit.arctic.championnat.entity.Position;

import java.util.List;

public interface IpositionService {
    Position ajouterPosition(Position position);
    Position modifierPosition(Position position);
    void supprimerPosition(Long idPosition);
    List<Position> listPositions();
    Position recupererPosition(Long idPosition);
}
