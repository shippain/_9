package gsu.math.alex.lab;

import gsu.math.alex.lab.Model.Product;
import gsu.math.alex.lab.Repasitory.ConnectionFactory;
import gsu.math.alex.lab.Repasitory.ProductRepository;

import java.sql.Connection;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();

        Product byId = repository.findById(2);
        System.out.println(byId);
    }
}
