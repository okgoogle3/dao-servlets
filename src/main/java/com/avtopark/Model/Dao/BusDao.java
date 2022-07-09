package com.avtopark.Model.Dao;

import com.avtopark.Model.Entities.Bus;
import com.avtopark.Model.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class BusDao implements IDao<Bus> {
    final static private String SELECT = "select * from bus where id = ?";
    final static private String SELECTALL = "select * from bus";
    final static private String INSERT = "insert into bus (number, busy) values(?, ?)";
    final static private String DELETE = "delete from bus where id = ?";
    final static private String UPDATE = "update bus set number = ?, busy = ? where id = ?";
    final static private String UPDATESTATUS = "update bus set busy = ? where id = ?";

    @Override
    public Bus findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Bus(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getBoolean(3));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Bus> findAll() {
        ArrayList<Bus> buses = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                buses.add(new Bus(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getBoolean(3))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return buses;
    }

    @Override
    public void add(Bus entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.number());
            ps.setBoolean(2, entity.busy());
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
    public void update(Bus entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entity.number());
            ps.setBoolean(2, entity.busy());
            ps.setInt(3, entity.id());
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
