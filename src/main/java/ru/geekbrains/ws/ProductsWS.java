package ru.geekbrains.ws;

import ru.geekbrains.service.ProductServiceImpl;
import ru.geekbrains.service.ProductServiceWs;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "ru.geekbrains.ws.IProduct")
public class ProductsWS implements IProduct{

    @EJB
    private ProductServiceImpl service;

    @Override
    public List<ProductServiceWs> getProduct(){
        return service.getProductRepository().findAllProductDTO().stream().map(ProductServiceWs::new).collect(Collectors.toList());
    }
}
