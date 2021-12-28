package com.delremi;

import com.delremi.security.CustomUserDetailsService;
import com.delremi.service.ClientService;
import com.delremi.service.CountryService;
import com.delremi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringThymeleafDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringThymeleafDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, ClientService clientService, CountryService countryService) {
        return args -> {
            userService.saveUser("del", "del");
            userService.saveUser("1", "1");
            userService.saveUser("2", "2");
            userService.saveUser("3", "3");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }
}
