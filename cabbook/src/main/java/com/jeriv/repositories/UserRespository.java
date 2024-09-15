package com.jeriv.repositories;

import java.util.Map;
import java.util.HashMap;

import com.jeriv.cabbook.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRespository {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map<String, User> users = new HashMap();    
}
