package com.devendra.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devendra.dto.Coupon;
import com.devendra.entity.Product;
import com.devendra.repository.ProductRepository;
import com.devendra.restclient.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private CouponClient couponClient;
	
	@Autowired
	private ProductRepository productRepo;
	
	@PostMapping("/product")
	
	public Product create(@RequestBody Product product) {
		
		Coupon coupon=couponClient.getCoupon(product.getCouponCode());
		System.out.println("COUPON : "+coupon.getDiscount());
		BigDecimal newPrice=product.getPrice().subtract(coupon.getDiscount());
		product.setPrice(newPrice);
		
		return productRepo.save(product);
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") String id) {
		return productRepo.findById(Long.parseLong(id)).get();
	}
}
