package org.example.demo3.controller;

import org.example.demo3.model.Product;
import org.example.demo3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList", productRepository.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "/create";
    }

    @PostMapping("/add")
    public String create(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showCreateForm(@PathVariable Long id, Model model){
        model.addAttribute("pro", productRepository.findById(id).get());
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String save(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable Long id, Model model){
        model.addAttribute("pro", productRepository.findById(id).get());
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("productList", productRepository.findAllByNameContaining(name));
        return "/result";
    }
}
