package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An {@link AuthService} implementation
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserService userService;
    private User accessingUser;

    /**
     * Sets the customer service
     *
     * @param userService the customer service to set
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * @see AuthService#authenticate(Integer,String,String)
     */
    @Override
    public boolean authenticate(Integer id, String name, String password) {

        for (User user: userService.list()) {
            if(user.getName().equals(name) && user.getPassword().equals(password)){
                accessingUser = user;
            }
        }
        //accessingUser = userService.get(id);
        return accessingUser != null;
    }

    /**
     * @see AuthService#getAccessingUser()
     */
    @Override
    public User getAccessingUser() {
        return accessingUser;
    }
}
