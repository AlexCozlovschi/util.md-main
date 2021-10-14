package com.util.md.data.generator;

import com.util.md.data.UserStatus;

import com.util.md.data.entity.Addresses;
import com.util.md.data.entity.Data;
import com.util.md.data.service.repository.AddressRepository;
import com.util.md.data.service.repository.DataRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;

import com.util.md.data.service.repository.UserRepository;
import com.util.md.data.entity.Users;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.util.md.data.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UserRepository userRepository, DataRepository dataRepository, AddressRepository addressRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 2 Users entities...");

            //Adding admin
            Data data = new Data();
            Addresses addresses = new Addresses();

            long millis=System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);


            data.setPicture("https://picsum.photos/300/300");
            dataRepository.save(data);

            addresses.setLocation("Admin_ad");



            Users user = new Users();
            user.setBirthDate(date);
            user.setEmail("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRole(Collections.singleton(Role.ADMIN));
            user.setStatus(Collections.singleton(UserStatus.UNVERIFIED));
            user.setName("Admin");
            user.setSurename("Admin");
            user.setDataByDataId(data);
            //user.setAddressesByAddressId(addresses);
            addresses.setDataByUsersId(user);

            userRepository.save(user);

            addressRepository.save(addresses);


            //Adding user
            Data data2 = new Data();
            Addresses addresses2 = new Addresses();


            data2.setPicture("https://picsum.photos/300/300");
            dataRepository.save(data2);

            addresses2.setLocation("User_ad");



            Users user2 = new Users();
            user2.setBirthDate(date);
            user2.setEmail("user");
            user2.setPassword(passwordEncoder.encode("user"));
            user2.setRole(Collections.singleton(Role.USER));
            user2.setStatus(Collections.singleton(UserStatus.UNVERIFIED));
            user2.setName("User");
            user2.setSurename("User");
            user2.setDataByDataId(data2);
            //user2.setAddressesByAddressId(addresses2);
            addresses2.setDataByUsersId(user2);
            userRepository.save(user2);
            addressRepository.save(addresses2);



            logger.info("Generated demo data");
        };
    }

}