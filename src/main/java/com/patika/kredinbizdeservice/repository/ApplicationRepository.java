package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();

    public Application save(Application application) {
        applicationList.add(application);
        return application;
    }
   public List<Application> findByUserEmail(String email){
       List<Application> foundApplications = new ArrayList<>();
       for (Application application : applicationList) {
           if (application.getUser().getEmail().equals(email)) {
               foundApplications.add(application);
           }
       }
       return foundApplications;
   }






}
