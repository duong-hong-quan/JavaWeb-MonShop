/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.account;

import quandh.roles.RoleDTO;

/**
 * @author PC_HONGQUAN
 */
public class AccountDTO {

    private String email;
    private String password;
    private String image;
    private String fullname;
    private String address;
    private String phonenum;
    private boolean deleted;
    private RoleDTO role;

    public AccountDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public AccountDTO(String email, String password, String fullname, String address, String phonenum, RoleDTO role) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.address = address;
        this.phonenum = phonenum;
        this.role = role;
    }

    public AccountDTO(String email, String password, String img, String fullname, String address, String phonenum, boolean deleted, RoleDTO role) {
        this.email = email;
        this.password = password;
        this.image = img;
        this.fullname = fullname;
        this.address = address;
        this.phonenum = phonenum;
        this.deleted = deleted;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "email=" + email + ", password=" + password + ", img=" + image + ", fullname=" + fullname + ", address=" + address + ", phonenum=" + phonenum + ", deleted=" + deleted + ", role=" + role + '}';
    }

}
