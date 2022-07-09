package com.avtopark;

import com.avtopark.Service.EmploymentService;
import com.avtopark.Service.UserService;

public class Entry {
    public static void main(String[] args) {
        EmploymentService e = new EmploymentService();
        e.deleteEmployment(6,3,3);
    }
}
