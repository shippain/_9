package gsu.math.alex.lab.Repasitory;

import gsu.math.alex.lab.Model.IEntity;
import gsu.math.alex.lab.Model.Product;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repasitory<Product> {

    private ConnectionFactory factory = new ConnectionFactory();

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            create(product);
        } else {
            update(product);
        }

    }

    private void update(Product product) {

    }

    private void create(Product product) {

    }

    @Override
    @SneakyThrows
    public Product findById(int id) {
        PreparedStatement statement = factory.getConnectoin().prepareStatement("select * from product where id = ?");
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");

            Product product = new Product(id, name, price);
            products.add(product);
        }
        if (products.size() > 1) {
            throw new RuntimeException("no unique product by id");
        }
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    @SneakyThrows
    public void delete(int id) {
        PreparedStatement statement =
                factory.getConnectoin().prepareStatement("delete from product where id = ?");
        statement.setInt(1, id);
        statement.execute();

    }
}
