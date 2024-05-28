package com.santander.gofTest.Beans;

import com.santander.gofTest.Models.Address.Address;
import com.santander.gofTest.Models.Users.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansFactory {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Address address() {
        return new Address();
    }
}



