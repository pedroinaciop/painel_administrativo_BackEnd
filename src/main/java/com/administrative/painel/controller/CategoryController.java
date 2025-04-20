package com.administrative.painel.controller;

import com.administrative.painel.dto.EditCategoryDTO;
import com.administrative.painel.repository.CategoryRepository;
import com.administrative.painel.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import com.administrative.painel.dto.CategoryDTO;
import com.administrative.painel.model.Category;
import jakarta.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

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
    @DeleteMapping("/categorias/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
    }

    @GetMapping("/editar/categorias/{id}")
    public CategoryDTO findCategoryByID(@PathVariable("id") Long id) {
        return categoryService.getCategoryDTO(id);
    }

    @Transactional
    @PutMapping("/editar/categorias/{id}")
    public void editCategoryByID(@PathVariable("id") Long id, @RequestBody EditCategoryDTO dto) {
        categoryService.editCategoryByID(id, dto.categoryName(), dto.updateDate(), dto.updateUser());
    }
}
