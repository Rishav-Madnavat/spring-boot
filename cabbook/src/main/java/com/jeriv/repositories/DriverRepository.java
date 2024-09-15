package com.jeriv.repositories;

import java.util.Map;
import java.util.HashMap;

import com.jeriv.cabbook.models.Driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRepository {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map<String, Driver> drivers = new HashMap(); 
}
