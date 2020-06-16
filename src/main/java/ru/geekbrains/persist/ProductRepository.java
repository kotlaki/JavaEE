package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    private Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @Inject
    private ServletContext ctx;

    private Connection conn;

    @PostConstruct
    public void init() {
        String jdbcConnectionString = ctx.getInitParameter("jdbcConnectionString");
        String dbUsername = ctx.getInitParameter("dbUsername");
        String dbPassword = ctx.getInitParameter("dbPassword");


        try {
            conn = DriverManager.getConnection(jdbcConnectionString, dbUsername, dbPassword);

            if (this.findAll().isEmpty()) {
                this.insert(new Products(-1L, "Product1", "Desc1", new BigDecimal(10)));
                this.insert(new Products(-1L, "Product2", "Desc2", new BigDecimal(102)));
                this.insert(new Products(-1L, "Product3", "Desc3", new BigDecimal(1030)));
                this.insert(new Products(-1L, "Product4", "Desc4", new BigDecimal(140)));
            }
            createTableIfNotExists(conn);
        } catch (SQLException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }
    }

    public void insert(Products product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into products(`name`, `description`, `price`) values (?, ?, ?);")) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.execute();
        }
    }

    public void update(Products product) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update products set `name` = ?, `description` = ?, `price` = ? where `id` = ?;")) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setLong(4, product.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from products where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

    public Products findById(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "select `id`, `name`, `description`, `price` from `products` where `id` = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Products(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4));
            }
        }
        return new Products(-1L, "", "", null);
    }

    public List<Products> findAll() throws SQLException {
        List<Products> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select `id`, `name`, `description`, `price` from `products`");

            while (rs.next()) {
                res.add(new Products(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4)));
            }
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists `products` (\n" +
                    "    `id` int auto_increment primary key,\n" +
                    "    `name` varchar(25),\n" +
                    "    `description` varchar(25),\n" +
                    "    `price` decimal(19, 2) \n" +
                    ");");
        }
    }
}