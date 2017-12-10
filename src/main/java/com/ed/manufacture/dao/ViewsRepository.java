package com.ed.manufacture.dao;

import com.ed.manufacture.config.DataSourceConfig;
import com.ed.manufacture.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Repository
public class ViewsRepository {

    @Autowired
    DataSourceConfig dataSourceConfig;

    public String getOrder() {
        Connection con = null;

        try {
            con = dataSourceConfig.dataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return JSON.resultSetToJson(con, "SELECT * FROM Сотрудники");
    }
}
