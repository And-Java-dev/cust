package com.example.customer;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductEndpoint {

    RestTemplate restTemplate = new RestTemplate();



    @GetMapping
    public List<Object> getProducts(){
        return restTemplate.getForObject("http://localhost:8080/prod/all", List.class);
    }

    @GetMapping("/{id}")
    public Object getProduct(@PathVariable("id") int id){
        return restTemplate.getForObject("http://localhost:8080/prod/" + id, Object.class);
    }
}
