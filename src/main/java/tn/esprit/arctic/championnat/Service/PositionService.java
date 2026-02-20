package tn.esprit.arctic.championnat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.arctic.championnat.Repository.PositionRepository;
import tn.esprit.arctic.championnat.entity.Position;

import java.util.List;

@Service
public class PositionService implements IpositionService {
    
    @Autowired
    PositionRepository positionRepository;

    @Override
    public Position ajouterPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position modifierPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public void supprimerPosition(Long idPosition) {
        positionRepository.deleteById(idPosition);
    }

    @Override
    public List<Position> listPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position recupererPosition(Long idPosition) {
        return positionRepository.findById(idPosition).orElse(null);
    }
}
