package com.illuminator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringUpdater {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringUpdater.class, args);
        updateAndCloseApplication(context);
    }

    private static void updateAndCloseApplication(ConfigurableApplicationContext context) {
        MetrikaClient metrikaClient = new MetrikaClient();
        metrikaClient.getStatByTimeData();
        //context.close();
    }

}
