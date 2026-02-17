package com.krishna.product.test_learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApp {

    private final MyTestComponent myTestComponent;

    /*
        Constructor Injection

        Note: If we have a single argument, then we don't need to write @Autowire but if there are multiple arguments then we do need to write autowire
     */

    @Autowired
    public MyApp(MyTestComponent myTestComponent){
        System.out.println("Inside constructor of MyApp. This constructor is called after it's dependencies are already created (for eg. MyTestComponent) ");

        this.myTestComponent = myTestComponent;
    }

    public void run(){
        myTestComponent.getMessage();
    }
}
