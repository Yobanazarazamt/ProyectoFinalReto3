package com.cabin.cabin.Reto3.Service;

import com.cabin.cabin.Reto3.Interfaz.Category;
import com.cabin.cabin.Reto3.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategorys() {
        return (List<Category>) categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category category){
        
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else {
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if (e.isPresent()){
                return category;
            }else {
                return categoryRepository.save(category);
            }
        }
    }
}
