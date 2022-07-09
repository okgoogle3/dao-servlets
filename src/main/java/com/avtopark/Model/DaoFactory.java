package com.avtopark.Model;

import com.avtopark.Model.Dao.*;

public class DaoFactory {
    public static UserDao createUserDao(){
        return new UserDao();
    }
    public static RolesDao createRolesDao(){
        return new RolesDao();
    }
    public static BusDao createBusDao(){
        return new BusDao();
    }
    public static RouteDao createRouteDao(){
        return new RouteDao();
    }
    public static DaoEmployment createEmploymentDao(){
        return new DaoEmployment();
    }
}
