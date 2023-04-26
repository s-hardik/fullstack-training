package com.hardik.shah;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       Doctor doctor =   context.getBean(Doctor.class);
       doctor.assist();
       doctor.setQualification("MBBS");
       System.out.println(doctor.getQualification());

       Doctor doctor1 = context.getBean(Doctor.class);
       doctor1.setQualification("Tooth");
        System.out.printf(doctor1.getQualification());
    }
}
