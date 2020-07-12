package com.coderapper;

import com.coderapper.models.Client;
import com.coderapper.repositories.BookingsRepository;
import com.coderapper.repositories.ClientsRepository;
import com.coderapper.services.BookingsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SingletonVSPrototypeExample
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.coderapper");

        List<Client> db1 = context.getBean("clientDB",List.class);

        db1.add(new Client("Am I","A Singleton?",1));

        System.out.println("DB 1 contents: " + db1.toString());

        List<Client> db2 = context.getBean("clientDB",List.class);
        System.out.println("DB 2 contents: " + db2.toString() + '\n');

    }
}
