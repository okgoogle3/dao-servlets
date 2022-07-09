package com.avtopark.Service;

import com.avtopark.Model.Dao.BusDao;
import com.avtopark.Model.DaoFactory;
import com.avtopark.Service.Dto.BusDto;
import com.avtopark.Service.Dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class BusService {
    BusDao busDao = DaoFactory.createBusDao();

    public List<BusDto> getAllFreeBuses(){
        return busDao.findAll()
                .stream()
                .filter(bus -> !bus.busy())
                .map(bus -> new BusDto(bus.id(), bus.number()))
                .collect(Collectors.toList());

    }
}
