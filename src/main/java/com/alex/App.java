package com.alex;

import com.alex.Config.AppConfig;
import com.alex.interfaces.Messenger;
import com.alex.interfaces.WriteToFile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Messenger messenger=context.getBean(Messenger.class);
        WriteToFile writeToFile=context.getBean(WriteToFile.class);

        int i = 0;
        while (i < 5){
            writeToFile.write(messenger.getMessage());
            i++;
        }

        for (String name:context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        context.close();
    }



}
