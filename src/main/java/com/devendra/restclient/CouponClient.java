package com.devendra.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devendra.dto.Coupon;

@FeignClient("API-GATEWAY-SERVICE")
public interface CouponClient {
	
	@GetMapping("/couponapi/coupons/{couponcode}")
	public Coupon getCoupon(@PathVariable("couponcode") String couponCode);

}
