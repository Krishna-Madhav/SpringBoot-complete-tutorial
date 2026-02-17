package com.krishna.product.test_learning;

//@Component
public class MyTestComponent {

    public MyTestComponent(){
        System.out.println("Inside constructor of MyTestComponent. This will be called first as object of this class will be injected to MyApp class");
    }

    public void getMessage(){
        System.out.println("Result from method getMessage");
    }
}
