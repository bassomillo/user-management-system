package com.bassomillo.dao;

import com.bassomillo.entity.Dept;
import com.bassomillo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao extends BaseDao{
    public List<Dept> getAllDept() {
        String sql = "select id,name from dept";
        PreparedStatement statement = null;
        Connection conn = getConn();
        List<Dept> deptList = new ArrayList<>();
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                deptList.add(new Dept(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
            return deptList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,statement,null);
        }
        return null;
    }
}
