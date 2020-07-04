package ru.geekbrains.ws;

import ru.geekbrains.service.ProductServiceWs;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IProduct {
    @WebMethod
    List<ProductServiceWs> getProduct();
}