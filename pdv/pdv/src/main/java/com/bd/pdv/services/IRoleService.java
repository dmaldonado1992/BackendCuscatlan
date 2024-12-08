package com.bd.pdv.services;

import com.bd.pdv.models.entity.Role;

import java.util.Optional;

public interface IRoleService {
    public Optional<Role> getByName(String name);
}
