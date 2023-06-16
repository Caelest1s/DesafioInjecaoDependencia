package dev.superior.desafio.injecaodependencia.entities;

public class Order {

    //Atributes
    //code item
    private int code;
    //value item
    private double basic;
    //value discount
    private double discount;
    
    //Constructor's
    public Order(){

    }

    public Order(int code, double basic, double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }
    
    //Getters and Setters
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public double getBasic() {
        return basic;
    }
    public void setBasic(double basic) {
        this.basic = basic;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //informações
    public void getOrder(){
        
        System.out.println("\nCodigo do produto: " + this.getCode());
        System.out.println("Valor do item R$: " + this.getBasic());
        System.out.println("Valor do desconto: " +  this.getDiscount() + "%");
    }
    
}
