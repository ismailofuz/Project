package com.example.project.controller;

import com.example.project.dto.ApiResponse;
import com.example.project.dto.ProductDTO;
import com.example.project.entity.Product;
import com.example.project.repository.DetailRepository;
import com.example.project.repository.ProductRepository;
import com.example.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;
    final ProductRepository productRepository;
    final DetailRepository detailRepository;

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.<HttpEntity<?>>map(product -> ResponseEntity.ok().body(product)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Product()));

    }

    @GetMapping("/list")
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @GetMapping("/details")
    public HttpEntity<?> getDetailsProduct(@RequestParam("product_id") Integer id) {
        //details list
        return ResponseEntity.ok().body(detailRepository.findAllByProduct_Id(id));
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDTO dto) {
        ApiResponse response = productService.add(dto);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        ApiResponse response = productService.edit(id, dto);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {

        ApiResponse response = productService.delete(id);

        return ResponseEntity.status(response.isSuccess() ? 204 : 404).body(response);
    }
}
