package com.avtopark.Model.Dao;

import com.avtopark.Model.Entities.User;
import com.avtopark.Model.Entities.UserRoles;

import java.sql.*;
import java.util.ArrayList;

public class RolesDao implements IDao<UserRoles> {
    final static private String SELECT = "select * from user_roles where user_id = ?";
    final static private String SELECTALL = "select * from user_roles";
    final static private String INSERT = "insert into user_roles (user_id, role_id) values(?, ?)";
    final static private String DELETE = "delete from user_roles where user_id = ?";

    @Override
    public UserRoles findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new UserRoles(
                    rs.getInt(1),
                    rs.getInt(2)
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<UserRoles> findAll() {
        ArrayList<UserRoles> userRoles = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                userRoles.add(new UserRoles(
                        rs.getInt(1),
                        rs.getInt(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public void add(UserRoles entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.user_id());
            ps.setInt(2, entity.role_id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserRoles entity) {
    }
}
