package ru.kurganov;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final Connection conn;

    public ProductRepository(Connection conn) {
        this.conn = conn;
    }

    public void insert(Products product){
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "insert into products(`name`, `description`, `price`) values (?, ?, ?);");
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Ошибка в ProductRepository.class метод insert!!!");
            e.printStackTrace();
        }
    }

    public void update(Products product){
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "update products set `name` = ?, `description` = ?, `price` = ? where `id` = ?;");
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setLong(4, product.getId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Ошибка в ProductRepository.class метод update!!!");
            e.printStackTrace();
        }
    }

    public void delete(long id){
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "delete from products where id = ?;");
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Ошибка в ProductRepository.class метод delete!!!");
            e.printStackTrace();
        }
    }

    public Products findById(long id){
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(
                    "select `id`, `name`, `description`, `price` from `products` where `id` = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Products(
                        rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getBigDecimal(4)
                );
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в ProductRepository.class метод findeById!!!");
            e.printStackTrace();
        }
        return new Products(-1L, "", "", null);
    }

    public List<Products> findAll(){
        List<Products> res = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select `id`, `name`, `description`, `price` from `products`");

            while (rs.next()) {
                res.add(new Products(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getBigDecimal(4)));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в ProductRepository.class метод findAll!!!");
            e.printStackTrace();
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn){
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("create table if not exists `products` (\n" +
                    "    `id` int auto_increment primary key,\n" +
                    "    `name` varchar(25),\n" +
                    "    `description` varchar(25),\n" +
                    "    `price` decimal(19, 2) \n" +
                    ");");
        } catch (SQLException e) {
            System.out.println("Ошибка в ProductRepository.class метод createTableIfNotExists!!!");
            e.printStackTrace();
        }

    }
}
