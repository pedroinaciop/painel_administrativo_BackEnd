package com.administrative.painel.controller;

import com.administrative.painel.dto.EditCompanyDTO;
import com.administrative.painel.dto.EditProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.administrative.painel.repository.ProductRepository;
import com.administrative.painel.service.ProductService;
import org.springframework.web.bind.annotation.*;
import com.administrative.painel.dto.ProductDTO;
import com.administrative.painel.model.Product;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/produtos")
    public List<ProductDTO> findAllProducts() {
        return productService.getProducts();
    }

    @Transactional()
    @DeleteMapping("/produtos/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @PostMapping("cadastros/produtos/novo")
    public void createProduct(@RequestBody ProductDTO dados) {
        productRepository.save(new Product(dados));
    }

    @GetMapping("/editar/produtos/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return productService.getProductDTO(id);
    }

    @Transactional
    @PutMapping("/editar/produtos/{id}")
    public void editProduct(@PathVariable("id") Long id, @RequestBody EditProductDTO dto) {
        productService.editProduct(id, dto.productName(), dto.referenceCode(), dto.price(), dto.pricePromocional(), dto.provider(), dto.stockAlert(), dto.color(), dto.size(), dto.barCodeField(), dto.description(), dto.category(), dto.packagingQuantity(), dto.unity(), dto.netWeight(), dto.grossWeight(), dto.dimension(), dto.anvisaRegister(), dto.origin(), dto.stockLocation(), dto.icms(), dto.cfop(), dto.ncm(), dto.cst(), dto.image(), dto.active(), dto.sterility(), dto.freeShipping(), dto.perishable(), dto.updateDate(), dto.updateUser());
    }
}
