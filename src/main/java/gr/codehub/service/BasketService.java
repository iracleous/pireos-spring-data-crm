package gr.codehub.service;

import gr.codehub.dto.BasketDto;
import gr.codehub.dto.CustomerDto;

import java.util.List;

public interface BasketService {

    BasketDto createBasket(BasketDto basketDto);
    BasketDto getBasket(int id);
    List<BasketDto> getBaskets(CustomerDto customerDto);
    BasketDto addProduct(int basketId, int productId);
}
