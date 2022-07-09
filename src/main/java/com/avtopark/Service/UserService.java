package com.avtopark.Service;

import com.avtopark.Model.Dao.RolesDao;
import com.avtopark.Model.Dao.UserDao;
import com.avtopark.Model.DaoFactory;
import com.avtopark.Model.Entities.User;
import com.avtopark.Model.Entities.UserRoles;
import com.avtopark.Service.Dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    final private UserDao userDao = DaoFactory.createUserDao();
    final private RolesDao rolesDao = DaoFactory.createRolesDao();

    public User isUserExists(String username, String password){
        ArrayList<User> users = userDao.findAll();
        for(User user: users){
            if(user.username().equals(username) && user.password().equals(password)){
                return user;
            }
        }
        return null;
    }

    public Boolean isUserAdmin(Integer id){
        UserRoles role = rolesDao.findById(id);
        if(role != null)
            if(role.role_id() == 1)
                return true;
        return false;
    }

    public List<UserDto> getAllFreeUsers(){
        return userDao.findAll()
                .stream()
                .filter(user -> !user.busy())
                .map(user -> new UserDto(user.id(), user.username()))
                .collect(Collectors.toList());

    }
}
