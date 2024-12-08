package com.bd.pdv.services.impl;

import com.bd.pdv.models.dao.IRoleDao;
import com.bd.pdv.models.entity.Role;
import com.bd.pdv.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    public Optional<Role> getByName(String name){
        return roleDao.findByName(name);
    }
}
