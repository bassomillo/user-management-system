package com.bassomillo.dao;

import com.bassomillo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao{
    public Integer save(User user) {
        String sql = "insert into user (name,password,profile)values(?,?,?)";
        PreparedStatement statement = null;
        Connection conn = getConn();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getProfile());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return -1;
    }

    public Integer select(String username){
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        Connection conn = getConn();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return -1;
    }

    public List<User> findUserByName(String username){
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        Connection conn = getConn();
        List<User> userList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                userList.add(new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("profile"),
                        resultSet.getInt("deptId")));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return null;
    }

    public List<User> findAllUsers(Integer currentPage, Integer pageSize) {
        String sql = "select u.id,u.name,u.password,u.profile,u.deptId,d.name " +
                     "from user u left join dept d on u.deptId=d.id limit ?,?";
        PreparedStatement statement = null;
        Connection conn = getConn();
        List<User> userList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1,(currentPage-1)*pageSize);
            statement.setInt(2,pageSize);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                userList.add(new User(resultSet.getInt("id"),
                        resultSet.getString("u.name"),
                        resultSet.getString("password"),
                        resultSet.getString("profile"),
                        resultSet.getInt("deptId"),
                        resultSet.getString("d.name")));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return null;
    }

    public Integer deleteById(String id) {
        String sql = "delete from user where id = ?";
        PreparedStatement statement = null;
        Connection conn = getConn();
        List<User> userList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return -1;
    }

    public User findUserById(String id) {
        String sql = "select * from user where id = ?";
        PreparedStatement statement = null;
        Connection conn = getConn();
        List<User> userList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                userList.add(new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("profile"),
                        resultSet.getInt("deptId")));
                return userList.get(0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return null;
    }

    public Integer update(User user) {
        String sql = "update user set profile = ?, deptId=? where id = ?";
        PreparedStatement statement = null;
        Connection conn = getConn();
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,user.getProfile());
            statement.setInt(2,user.getDeptId());
            statement.setInt(3,user.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return -1;
    }

    public Integer getUserTotal() {
        String sql = "select count(*) total from user";
        PreparedStatement statement = null;
        Connection conn = getConn();
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return -1;
    }
}
