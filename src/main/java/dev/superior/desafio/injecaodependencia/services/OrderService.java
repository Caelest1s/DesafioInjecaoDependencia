package dev.superior.desafio.injecaodependencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.superior.desafio.injecaodependencia.entities.Order;

@Service
public class OrderService {
    
    @Autowired
    private ShippingService shippingService;

    //return value with discount and shipping, final value
    public double totalValue(Order order){
        double valueDiscount = productValue(order);
        double shipping = shippingService.shipment(valueDiscount);

        System.out.printf("\nPreço do produto R$: " + valueDiscount);
        System.out.printf("\nFrete R$: " + shipping);

        return (valueDiscount + shipping);
    }

    //return value with discount without shipping
    public double productValue(Order order){
        double value = order.getBasic() - discountValue(order.getBasic(), order.getDiscount());
        return value;
    }

    //verify discount value
    public double discountValue(double value, double discount){
        double valor = (value * discount) / 100;
        return valor;
    }
}
