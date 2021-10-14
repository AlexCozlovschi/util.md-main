package com.util.md.models.masterManager;

import com.util.md.data.Role;
import com.util.md.data.UserStatus;
import com.util.md.data.entity.Addresses;
import com.util.md.data.entity.Data;
import com.util.md.data.entity.Users;
import com.util.md.data.service.repository.AddressRepository;
import com.util.md.data.service.repository.DataRepository;
import com.util.md.data.service.repository.UserRepository;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
@SpringComponent
public class UserRegistrationModel {

    /*  TO DO:
        - Must generate and add profile picture path
        - Must generate and add documents path
        - Must add list of services (maybe as a list)
     */

    private String name;
    private String surename;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String password;
    private String status;
    private String documentsPath;
    private String profilePicPath;

    private Users users;
    private Data data;
    private Addresses addresses;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DataRepository dataRepository;

    public UserRegistrationModel(){}

    public void saveUser(){
        //Data entity
        data = new Data();
        users = new Users();
        users.setBirthDate(Date.valueOf(birthDate));
        moveFiles(email);
        data.setPicture(profilePicPath);
        data.setFiles(documentsPath);

        //Address entity
        addresses = new Addresses();
        addresses.setLocation(address);

        //Users entity

        users.setName(name);
        users.setSurename(surename);
        users.setEmail(email);
        users.setPassword(passwordEncoder.encode(password));
//        switch (status){
//            case "VERIFIED":
//                users.setStatus(Collections.singleton(UserStatus.VERIFIED));
//                break;
//            case "BLOCKED":
//                users.setStatus(Collections.singleton(UserStatus.BLOCKED));
//                break;
//            default: users.setStatus(Collections.singleton(UserStatus.UNVERIFIED));
//        }
        users.setRole(Collections.singleton(Role.USER));
        users.setDataByDataId(data);
        //users.setAddressesByAddressId(addresses);
        addresses.setDataByUsersId(users);



        //Saving entity

        dataRepository.save(data);
        userRepository.save(users);
        addressRepository.save(addresses);


    }

    public void moveFiles(String name){
        String path = "/Users/gabriel/Documents/Projects/Util/util.md/src/main/resources/users_data/storage/" + name;
        createFile(path);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String tpath = "/Users/gabriel/Documents/Projects/Util/util.md/src/main/resources/users_data/temp/" + authentication.getName();
        data.setFiles(path);
        try{
            Files.move(Path.of(tpath), Path.of(path), REPLACE_EXISTING);
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
    }

    public void uploadFiles(InputStream stream, String fileName){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String path = "/Users/gabriel/Documents/Projects/Util/util.md/src/main/resources/users_data/temp/" + authentication.getName();
        try{
            createFile(path);
            File file = new File(path + "/" + fileName);
            FileUtils.copyInputStreamToFile(stream,file);
        } catch (java.io.IOException e) {
            Notification.show(e.getMessage());
        }

    }

    public void uploadPicture(InputStream stream, String fileName){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String path = "/Users/gabriel/Documents/Projects/Util/util.md/src/main/resources/users_data/temp/" + authentication.getName() +"/img";

        try{
            createFile(path);
            File file = new File(path + "/" + fileName);
            FileUtils.copyInputStreamToFile(stream,file);
        } catch (java.io.IOException e) {
            Notification.show(e.getMessage());
        }
    }

    public boolean mailExists(String email){
        if(userRepository.findByEmail(email) == null)
        { return false; } else { return true; }
    }

    public void createFile(String absolutePath){
        File dir = new File(absolutePath);
        if (!dir.exists()) dir.mkdirs();
        System.out.println(absolutePath);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getSurename() {
        return surename;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDocumentsPath(String documentsPath) {
        this.documentsPath = documentsPath;
    }

    public String getDocumentsPath() {
        return documentsPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }
}

