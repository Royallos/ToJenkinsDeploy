package org.example.jenkinsProject.repository.impl;

import org.example.jenkinsProject.repository.IAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class AppRepository implements IAppRepository {

    private DataSource dataSource;

    @Autowired
    public AppRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(String value) {
        String query = "insert into USERS (id, userName) values (?, ?)";
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, 1);
            statement.setString(2, value);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String get() {
        String result = null;
        String query = "select * from USERS";
        try (Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getString("userName");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

}
