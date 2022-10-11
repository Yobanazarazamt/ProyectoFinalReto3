package com.cabin.cabin.Reto3.Service;

import com.cabin.cabin.Reto3.Interfaz.Score;
import com.cabin.cabin.Reto3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(Integer id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> e = scoreRepository.getScore(score.getIdScore());
            if(e.isPresent()){
                return score;
            }else{
                return scoreRepository.save(score);
            }
        }
    }
}

