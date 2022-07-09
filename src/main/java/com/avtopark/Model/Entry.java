package com.avtopark.Model;

import com.avtopark.Model.Dao.*;
import com.avtopark.Model.Entities.Bus;
import com.avtopark.Model.Entities.Route;
import com.avtopark.Model.Entities.User;
import com.avtopark.Model.Entities.UserRoles;

public class Entry {
    public static void main(String[] args) {
        UserDao userDao = DaoFactory.createUserDao();
        RolesDao rolesDao = DaoFactory.createRolesDao();
        BusDao busDao = DaoFactory.createBusDao();
        RouteDao routeDao = DaoFactory.createRouteDao();
        DaoEmployment daoEmployment = DaoFactory.createEmploymentDao();

        rolesDao.add(new UserRoles(4, 1));
        /*userDao.add(new User(null, "bbb", "bbb", false));
        userDao.add(new User(null, "aaa", "bbb", false));
        userDao.add(new User(null, "ccc", "ccc", false));
        userDao.add(new User(null, "fff", "fff", false));


        busDao.add(new Bus(null, 111,false));
        busDao.add(new Bus(null, 222,false));
        busDao.add(new Bus(null, 333,false));
        busDao.add(new Bus(null, 444,false));

        routeDao.add(new Route(null, "arc-fgf", false));
        routeDao.add(new Route(null, "ddd-xcb", false));
        routeDao.add(new Route(null, "arghc-ret", false));*/
    }
}
