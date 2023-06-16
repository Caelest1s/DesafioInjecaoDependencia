package dev.superior.desafio.injecaodependencia.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    //Variable Finais
    private static final double SEM_TAXA = 0.0d;
    private static final double TAXA_MEDIA = 12.0d;
    private static final double TAXA_ALTA = 20.0d;

    public double shipment(double totalValue){

        if (noShopping(totalValue))
            return SEM_TAXA;
        else if (mediaShipping(totalValue))
            return TAXA_MEDIA;
        else 
            return TAXA_ALTA;
    }

    //Verify type of shipping
    public boolean noShopping(double totalValue){

        boolean flag = totalValue >= 200;
        return flag;
    }

    public boolean mediaShipping(double totalValue){

        boolean flag = (totalValue >= 100) && (totalValue < 200);
        return flag;
    }
    
    //method don't used, but future update 
    public boolean highShipping(double totalValue){
        
        boolean flag = totalValue < 100;
        return flag;
    }
    
}
