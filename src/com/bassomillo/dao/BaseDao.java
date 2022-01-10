package com.bassomillo.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

    protected Connection getConn(){
        try {
            Context ctx = new InitialContext();
            DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/dataSource/mysql/prod");
            return dataSource.getConnection();
        } catch (NamingException| SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
