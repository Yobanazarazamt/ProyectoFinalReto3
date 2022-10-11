package com.cabin.cabin.Reto3.Service;

import com.cabin.cabin.Reto3.Interfaz.Cabin;
import com.cabin.cabin.Reto3.Repository.CabinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CabinService {

    @Autowired
    private CabinRepository CabinRepository;

    public List<Cabin> getCabins(){
        return CabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id){
        return CabinRepository.getCabin(id);
    }
    
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return CabinRepository.save(cabin);
        }else{
            Optional<Cabin> e = CabinRepository.getCabin(cabin.getId());
            if(e.isPresent()){
                return cabin;
            }else{
                return CabinRepository.save(cabin);
            }
        }
    }
}
