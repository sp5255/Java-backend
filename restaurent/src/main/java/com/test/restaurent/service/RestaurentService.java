package com.test.restaurent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.restaurent.model.RestaurentModal;

@Service
public class RestaurentService {
    private static List<RestaurentModal> restaurents = new ArrayList<>();            
    static {
        restaurents.add(new RestaurentModal(1, "Restaurent1", "Delhi", 200,"coffee" ));
        restaurents.add(new RestaurentModal(2, "Restaurent2", "Gurgaon", 200,"tea" ));
        restaurents.add(new RestaurentModal(3, "Restaurent3", "Noida", 200,"Soft drinks" ));
        restaurents.add(new RestaurentModal(4, "Restaurent4", "Delhi NCR", 200,"other" ));

    }

    public RestaurentModal getRestaurent(int number){
        for(RestaurentModal restaurent : restaurents){
            if(restaurent.getNumber() == number)
                return restaurent;                        
        }
        return null;
    }

    public RestaurentModal getRestaurentByName(String name){
        System.out.println("recieive name : " + name);
        for(RestaurentModal restaurent : restaurents){
            System.out.println("recieive name : " + name + " : " + restaurent.getName() + " : " +  restaurent.getName() == name);
            if(restaurent.getName().equals(name))
                return restaurent;                        
        }
        return null;
    }

    public List<RestaurentModal> getAllRestaurents() {
        return restaurents;
    }
}
