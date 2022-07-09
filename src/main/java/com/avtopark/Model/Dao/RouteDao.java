package com.avtopark.Model.Dao;

import com.avtopark.Model.Entities.Bus;
import com.avtopark.Model.Entities.Route;

import java.sql.*;
import java.util.ArrayList;

public class RouteDao implements IDao<Route> {
    final static private String SELECT = "select * from route where id = ?";
    final static private String SELECTALL = "select * from route";
    final static private String INSERT = "insert into route (name, busy) values(?, ?)";
    final static private String DELETE = "delete from route where id = ?";
    final static private String UPDATE = "update route set name = ?, busy = ? where id = ?";
    final static private String UPDATESTATUS = "update route set busy = ? where id = ?";

    @Override
    public Route findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Route(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getBoolean(3));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Route> findAll() {
        ArrayList<Route> routes = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                routes.add(new Route(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return routes;
    }

    @Override
    public void add(Route entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.name());
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
    public void update(Route entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.name());
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
