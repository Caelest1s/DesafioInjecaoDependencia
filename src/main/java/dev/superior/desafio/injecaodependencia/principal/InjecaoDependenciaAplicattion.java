package dev.superior.desafio.injecaodependencia.principal;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import dev.superior.desafio.injecaodependencia.entities.Order;
import dev.superior.desafio.injecaodependencia.services.OrderService;

@SpringBootApplication
@ComponentScan({"dev.superior.desafio.injecaodependencia"})
public class InjecaoDependenciaAplicattion implements CommandLineRunner{

    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(InjecaoDependenciaAplicattion.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        iniciarCompras();

    }
    
    //Responsável por inicializar o sistema de compras
    public void iniciarCompras(){
        Scanner sc = new Scanner(System.in);
        char flag = 'S';

        while(flag != 'N'){ 
            Order order = new Order();

            System.out.println("\nDados relacionado a Mercadoria: ");
            System.out.println("código do produto: ");
            order.setCode(sc.nextInt());
            System.out.println("valor: ");
            order.setBasic(sc.nextDouble());
            System.out.println("Valor do desconto (%): ");
            order.setDiscount(sc.nextDouble());
            
            
            order.getOrder();

            System.out.println("Desconto de R$: " + 
                orderService.discountValue(order.getBasic(), order.getDiscount()));

            System.out.printf("%nValor da compra: " + orderService.totalValue(order));

            do{
                System.out.println("\nDeseja adiciona outra compra? S/N ");
                flag = sc.next().charAt(0);
                flag = Character.toUpperCase(flag);
            }while(flag != 'N' && flag != 'S');

            if(flag == 'N'){
                System.out.println("Fim do Programa");
            }
        }
    }
} 