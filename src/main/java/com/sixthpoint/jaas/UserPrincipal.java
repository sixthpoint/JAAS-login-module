package com.sixthpoint.jaas;

import java.security.Principal;

/**
 * Holds the logged in users name
 *
 * @author sixthpoint
 */
public class UserPrincipal implements Principal {

    private String name;

    /**
     * Initializer
     *
     * @param name
     */
    public UserPrincipal(String name) {
        super();
        this.name = name;
    }

    /**
     * Set the name of the user
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the user
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }
}
