package gsu.math.alex.lab.repository;

import gsu.math.alex.lab.model.Product;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product> {

    private ConnectionFactory factory = new ConnectionFactory();

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            create(product);
        } else {
            update(product);
        }

    }
    @SneakyThrows
    private void update(Product product) {
        try (PreparedStatement statement =
                     factory.getConnection().prepareStatement("update product set name = ?, price = ? where id = ?")) {
            statement.setString(1, product.getName());
            statement.setInt(2,product.getPrice());
            statement.setInt(3,product.getId());
            statement.execute();
        }


    }
    @SneakyThrows
    private void create(Product product) {
        try (PreparedStatement statement =
                factory.getConnection().prepareStatement("insert into product (name, price) values (?,?)", Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1,product.getName());
            statement.setInt(2,product.getPrice());
            statement.execute();

            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);
            product.setId(id);
        }

    }

    @Override
    @SneakyThrows
    public Product findById(int id) {
        PreparedStatement statement = factory.getConnection().prepareStatement("select * from product where id = ?");
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        List<Product> products = parseResultSet(rs);

        if (products.size() > 1) {
            throw new RuntimeException("no unique product by id");
        }
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    @SneakyThrows
    public List<Product> findAll() {
        try (PreparedStatement statement = factory.getConnection().prepareStatement("select * from product")) {
            ResultSet rs = statement.executeQuery();
            return parseResultSet(rs);
        }
    }

    @SneakyThrows
    private List<Product> parseResultSet(ResultSet rs) {
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");

            Product product = new Product(id1,name, price);
            products.add(product);
        }
        return products;
    }

    @Override
    @SneakyThrows
    public void delete(int id) {
        try (PreparedStatement statement =
                     factory.getConnection().prepareStatement("delete from product where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        }
    }
}
