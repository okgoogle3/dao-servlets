package com.avtopark.Service;

import com.avtopark.Model.Dao.RouteDao;
import com.avtopark.Model.DaoFactory;
import com.avtopark.Service.Dto.RouteDto;
import com.avtopark.Service.Dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class RouteService {
    RouteDao routeDao = DaoFactory.createRouteDao();

    public List<RouteDto> getAllFreeRoutes(){
        return routeDao.findAll()
                .stream()
                .filter(route -> !route.busy())
                .map(route -> new RouteDto(route.id(), route.name()))
                .collect(Collectors.toList());
    }
}
