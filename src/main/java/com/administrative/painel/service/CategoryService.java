package com.administrative.painel.service;

import com.administrative.painel.dto.CategoryDTO;
import com.administrative.painel.model.Category;
import com.administrative.painel.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories() {
        return(convertDataList(categoryRepository.findAll()));
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
    }

    public CategoryDTO getCategoryDTO(Long id) {
        return(convertData(categoryRepository.findById(id)));
    }

    public void editCategoryByID(Long id, String categoryName, Date date, String updateUser) {
        Category category = getCategoryById(id);

        category.setCategoryName(categoryName);
        category.setUpdateDate(date);
        category.setUpdateUser(updateUser);

        categoryRepository.save(category);
    }

    public CategoryDTO convertData(Optional<Category> category) {
        return category
                .map(c -> new CategoryDTO(c.getCategory_id(), c.getCategoryName(), c.getUpdateDate(), c.getUpdateUser()))
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada!"));
    }

    public List<CategoryDTO> convertDataList(List<Category> categories) {
        return categories
                .stream()
                .map(c -> new CategoryDTO(c.getCategory_id(), c.getCategoryName(), c.getUpdateDate(), c.getUpdateUser()))
                .collect(Collectors.toList());
    }
}
