package com.avtopark.Model.Dao;

import com.avtopark.Model.Entities.User;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;
import java.util.ArrayList;

public class UserDao implements IDao<User> {
    final static private String SELECT = "select * from user where id = ?";
    final static private String SELECTALL = "select * from user";
    final static private String INSERT = "insert into user (username, password, busy) values(?, ?, ?)";
    final static private String DELETE = "delete from user where id = ?";
    final static private String UPDATE = "update user set username = ?, password = ?, busy = ? where id = ?";
    final static private String UPDATESTATUS = "update user set busy = ? where id = ?";


    @Override
    public User findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new User(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getBoolean(4));
        }
        catch (SQLException e){
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                    users.add(new User(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getBoolean(4))
                    );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void add(User entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.username());
            ps.setString(2, entity.password());
            ps.setBoolean(3, entity.busy());
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
    public void update(User entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.username());
            ps.setString(2, entity.password());
            ps.setBoolean(3, entity.busy());
            ps.setInt(4, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStatus(Integer id, Boolean status){
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATESTATUS);
            ps.setBoolean(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Boolean getStatus(Integer id){
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getBoolean(4);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
