package com.test.restaurent.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.restaurent.model.RestaurentModal;
import com.test.restaurent.service.RestaurentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/v1/restaurent-app")
public class RestaurentController {

    // @Autowired
    // private RestaurentService restaurentService;
    
    private final RestaurentService restaurentService;

    RestaurentController(RestaurentService restaurentService){
        this.restaurentService = restaurentService;
    }
    
    @GetMapping("/restaurent/id/{id}")
    public RestaurentModal getRestaurent(@PathVariable int id) {
        return restaurentService.getRestaurent(id);        
    }


    @GetMapping("/restaurent/")
    public RestaurentModal getRestaurentByName(@RequestParam String name ){
        return restaurentService.getRestaurentByName(name);        
    }

    @GetMapping ("/restaurent/all")
    public List<RestaurentModal> getAllRestaurents(){
        return restaurentService.getAllRestaurents();
    }
}
