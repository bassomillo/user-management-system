package com.bassomillo.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 9182508920105959879L;
    private Integer id;
    private String username;
    private String password;
    private Integer deptId;
    private String profile;
    private String deptName;

    public User() {
    }

    public User(Integer id, String username, String password, String profile, Integer deptId, String deptName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.deptId = deptId;
        this.profile = profile;
        this.deptName = deptName;
    }

    public User(Integer id, String username, String password, String profile, Integer deptId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.deptId = deptId;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deptId=" + deptId +
                ", profile='" + profile + '\'' +
                '}';
    }
}
