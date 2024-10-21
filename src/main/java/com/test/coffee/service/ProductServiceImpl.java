package com.test.coffee.service;

import com.test.coffee.ProductRequest;
import com.test.coffee.ProductResponse;
import com.test.coffee.ProductServiceGrpc;
import com.test.coffee.entity.CoffeeBag;
import com.test.coffee.entity.Product;
import com.test.coffee.service.repositories.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CoffeeTypeRepository coffeeTypeRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CoffeeBagRepository coffeeBagRepository;

    @Override
    @Transactional
    public void production(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        try {
            Product product = new Product();
            CoffeeBag bag = coffeeBagRepository.findByBagNumber((long) request.getBagNumber());
            bag.setCurrentWeight(bag.getCurrentWeight().subtract(BigDecimal.valueOf(request.getWeightIn())));
            log.info("From bag: {} get Product: {}", bag, product);
            product.setType(coffeeTypeRepository.findByType(request.getType()));
            product.setCountry(countryRepository.findByName(request.getCountry()));
            product.setTeam(teamRepository.findByNumber((long) request.getTeam()));
            product.setWeightIn(BigDecimal.valueOf(request.getWeightIn()));
            product.setWeightOut(BigDecimal.valueOf(request.getWeightOut()));
            product.setCoffeeBag(bag);

            product.calcLosePercent();
            productRepository.save(product);
            coffeeBagRepository.save(bag);

            ProductResponse response = ProductResponse.newBuilder()
                    .setMessage("Product success save in DB")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
