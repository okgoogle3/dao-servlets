package com.avtopark.Service;

import com.avtopark.Model.Dao.BusDao;
import com.avtopark.Model.Dao.DaoEmployment;
import com.avtopark.Model.Dao.RouteDao;
import com.avtopark.Model.Dao.UserDao;
import com.avtopark.Model.DaoFactory;
import com.avtopark.Model.Entities.Bus;
import com.avtopark.Model.Entities.Employment;
import com.avtopark.Model.Entities.Route;
import com.avtopark.Model.Entities.User;
import com.avtopark.Service.Dto.ResultField;

import java.util.ArrayList;

public class EmploymentService {
    final private DaoEmployment daoEmployment = DaoFactory.createEmploymentDao();
    final private UserDao userDao = DaoFactory.createUserDao();
    final private BusDao busDao = DaoFactory.createBusDao();
    final private RouteDao routeDao = DaoFactory.createRouteDao();

    public void employDriverOnRoute(Integer user_id, Integer bus_id, Integer route_id){
        if(!(userDao.getStatus(user_id)&&busDao.getStatus(bus_id)&&routeDao.getStatus(route_id))){
            userDao.updateStatus(user_id, true);
            busDao.updateStatus(bus_id, true);
            routeDao.updateStatus(route_id, true);
            daoEmployment.add(new Employment(null, user_id, bus_id, route_id));
        }
    }

    public void deleteEmployment(Integer user_id, Integer bus_id, Integer route_id){
        Employment employment = daoEmployment.findBy(user_id);
        if(employment == null) return;
        if(employment.bus_id().equals(bus_id)&&employment.route_id().equals(route_id)){
            userDao.updateStatus(user_id, false);
            busDao.updateStatus(bus_id, false);
            routeDao.updateStatus(route_id, false);
            daoEmployment.delete(user_id, "user_id");
        }
    }

    public ResultField selectEmployment(Integer id){
        Employment employment = daoEmployment.findBy(id);
        if(employment != null)
            return new ResultField(
                    userDao.findById(employment.user_id()).username(),
                    busDao.findById(employment.bus_id()).number(),
                    routeDao.findById(employment.route_id()).name()
            );
        else return null;
    }

    public ArrayList<ResultField> selectAllEmployments(){
        ArrayList<Employment> employments = daoEmployment.findAll();
        ArrayList<ResultField> rf = new ArrayList<>();
        for(Employment e: employments){
            rf.add(new ResultField(
                    userDao.findById(e.user_id()).username(),
                    busDao.findById(e.bus_id()).number(),
                    routeDao.findById(e.route_id()).name()
            ));
        }
        return rf;
    }
}
