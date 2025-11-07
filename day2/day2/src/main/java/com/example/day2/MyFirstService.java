package com.example.day2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:myProps.properties"),
        @PropertySource("classpath:anotherProp.properties")
})


public class MyFirstService {

    private final MyFirstClass myFirstClass;
    private final Environment environment;

    @Value("${password.value}")
    private String password;

    @Value("${last.password}")
    private String anotherPassword;

    @Autowired
    public MyFirstService(MyFirstClass myFirstClass, Environment environment) {
        this.myFirstClass = myFirstClass;
        this.environment = environment;
    }



    public String printService() {
        return "Hello from service " + myFirstClass.printHello() ;

    }

    public String getVersion() {
        return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String getAppName(){
        return environment.getProperty("spring.application.name");
    }
    public String getName(){
        return environment.getProperty("my.own.name");
    }

    public String getPassword() {
        return password;
    }

    public String getAnotherPassword() {
        return anotherPassword;
    }
}
