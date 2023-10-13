package com.bootcoding.review.reviewsystem.repository;

import com.bootcoding.review.reviewsystem.model.User;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        try {
            String query = "INSERT into review " + "values(' " + user.getUsername() + "','" + user.getEmailId() + "'," + user.getPhone() + ")";
            jdbcTemplate.update(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            String sql = "Select * from review";
            return jdbcTemplate.query(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setEmailId(rs.getString("emailId"));
                    user.setPhone(rs.getLong("phone"));
                    return user;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public User getUserById(int id) {
        try {
            String sql = "SELECT * FROM review WHERE ID =?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPhone(rs.getLong("phone"));
                    user.setEmailId(rs.getString("emailId"));
                    return user;
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

