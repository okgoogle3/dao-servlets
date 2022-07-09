package com.avtopark.Model.Dao;

import com.avtopark.Model.Entities.Employment;
import com.avtopark.Model.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class DaoEmployment implements IDao<Employment> {
    final static private String SELECTBY = "select * from employment where user_id = ?";
    final static private String SELECTALL = "select * from employment";
    final static private String INSERT = "insert into employment (user_id, bus_id, route_id) values(?, ?, ?)";
    final static private String DELETEBY = "delete from employment where user_id = ?";

    public Employment findBy(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECTBY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Employment(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Employment findById(Integer id) {
        return null;
    }

    @Override
    public ArrayList<Employment> findAll() {
        ArrayList<Employment> employments = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                employments.add(new Employment(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return employments;
    }

    @Override
    public void add(Employment entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.user_id());
            ps.setInt(2, entity.bus_id());
            ps.setInt(3, entity.route_id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }

    public void delete(Integer id, String field) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(DELETEBY);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employment entity) {

    }
}
