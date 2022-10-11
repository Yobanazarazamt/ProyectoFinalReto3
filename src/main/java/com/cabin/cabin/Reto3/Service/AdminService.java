package com.cabin.cabin.Reto3.Service;

import com.cabin.cabin.Reto3.Interfaz.Admin;
import com.cabin.cabin.Reto3.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return (List<Admin>) adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> e = adminRepository.getAdmin(admin.getIdAdmin());
            if(e.isPresent()){
                return admin;
            }else{
                return adminRepository.save(admin);
            }
        }
    }
}
