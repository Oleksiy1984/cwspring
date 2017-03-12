package com.alex.Config;

import com.alex.impl.CacheWriter;
import com.alex.impl.WriterToFileImpl;
import com.alex.interfaces.Messenger;
import com.alex.interfaces.WriteToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@ComponentScan(basePackages = "com.alex.impl")
public class AppConfig {

    @Bean
    public DateFormat dateFormat() {
        return DateFormat.getDateInstance();
    }

    @Bean
    public WriteToFile cacheWriter(){
        return new CacheWriter(3,new Date(),dateFormat(),"file.txt");
    }


}
