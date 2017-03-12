package com.alex;

import com.alex.interfaces.Messenger;
import com.alex.interfaces.WriteToFile;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

public class AppXML {


    private WriteToFile writer;
    private Messenger messenger;

    public AppXML(WriteToFile writer, Messenger messenger) {
        this.writer = writer;
        this.messenger = messenger;
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        AppXML app = (AppXML) ctx.getBean("app");
        int i = 0;
        while (i < 5){
            String message = app.messenger.getMessage();
            app.writer.write(message);
            i++;
        }

        ctx.close();
    }



}

