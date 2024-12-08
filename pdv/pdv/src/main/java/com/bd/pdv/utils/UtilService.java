package com.bd.pdv.utils;

import com.bd.pdv.models.dao.IUserDao;
import com.bd.pdv.models.entity.User;
import com.bd.pdv.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UtilService {
    Logger logger = Logger.getLogger(UtilService.class.getName());

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private IUserDao userDao;


    public String jwtToUsername(String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                token = token.replace("Bearer ", "");
                if (jwtProvider.isValidToken(token)) {
                    String username = jwtProvider.getUsername(token);
                    return username;
                }
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return "";
    }

    public Long jwtToUserId(String token) {
        String username = jwtToUsername(token);
        if (!"".equals(username)) {
            Optional<User> user = userDao.findByUsername(username);
            if (user.isPresent()) {
                return user.get().getId();
            }
        }
        return null;
    }

    public Long getSessionPettyCashId(String token) {
        Long userId = jwtToUserId(token);
        if (userId != null) {
           
        }
        return null;
    }
}
