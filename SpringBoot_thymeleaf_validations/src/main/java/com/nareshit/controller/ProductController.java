package com.nareshit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nareshit.entity.ProductEntity;
import com.nareshit.repo.ProductRepository;

@Controller
public class ProductController {
  
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping(value = {"/","/add"})
	public String loadPage(Model model) {
		ProductEntity product=new ProductEntity();
		model.addAttribute("product",product);
		return "index";
	}
	
	@PostMapping("/product")
	public String saveData(@Validated @ModelAttribute("product")ProductEntity product,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "index";
		}
		product=productRepo.save(product);
	    if(product.getId()!=null) {
	    	model.addAttribute("msg","data saved");
	    }
	    return "index";
	}
	
	@GetMapping("/showProducts")
	public String showData(Model model) {
		List<ProductEntity> products=productRepo.findAll();
		model.addAttribute("allproducts", products);
		return "data";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id,Model model) {
		productRepo.deleteById(id);
		model.addAttribute("msg","product deleted");
		model.addAttribute("allproducts",productRepo.findAll());
		return "data";
	}
	@GetMapping("/edit")
	public String edit(@RequestParam("id") Integer id,Model model) {
		Optional<ProductEntity> findby=productRepo.findById(id);
		if(findby.isPresent()) {
			ProductEntity product=findby.get();
			model.addAttribute("product", product);
		}
		return "index";
	}
}
