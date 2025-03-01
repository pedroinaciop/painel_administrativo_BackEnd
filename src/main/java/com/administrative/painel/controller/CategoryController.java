package com.administrative.painel.controller;

import com.administrative.painel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.administrative.painel.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import com.administrative.painel.dto.CategoryDTO;
import com.administrative.painel.model.Category;
import jakarta.transaction.Transactional;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorias")
    public List<CategoryDTO> findAllCategories() {
        return categoryService.getCategories();
    }

    @Transactional
    @PostMapping("/cadastros/categorias/novo")
    public void registerCategory(@RequestBody CategoryDTO dados) {
        categoryRepository.save(new Category(dados));
    }

    @Transactional
    @DeleteMapping("categorias/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
    }
}
