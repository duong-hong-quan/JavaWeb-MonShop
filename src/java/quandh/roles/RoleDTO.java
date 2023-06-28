/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.roles;

import java.io.Serializable;

/**
 * @author PC_HONGQUAN
 */
public class RoleDTO implements Serializable {

    private int id;
    private String role;

    public RoleDTO(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleDTO(int id) {
        this.id = id;
    }

    public RoleDTO(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleDTO{" + "id=" + id + ", role=" + role + '}';
    }


}
