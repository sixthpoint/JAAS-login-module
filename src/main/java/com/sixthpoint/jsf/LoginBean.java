package com.sixthpoint.jsf;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Sample login bean for JSF
 * 
 * @author Brandon
 */
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    /**
     *
     * @return
     */
    public String login() {

        try {

            // Get the current servlet request from the facesContext
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();

            // Do login from the container (will call login module)
            request.login(username, password);

            return "/protected/index.xhtml?faces-redirect=true";

        } catch (ServletException ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An Error Occured: Login failed", null));
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "login.xhtml";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
