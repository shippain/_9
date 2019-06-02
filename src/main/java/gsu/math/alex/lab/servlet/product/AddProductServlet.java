package gsu.math.alex.lab.servlet.product;

import gsu.math.alex.lab.model.Product;
import gsu.math.alex.lab.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/add")
public class AddProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = new ProductRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("product_name");
        String price = req.getParameter("product_price");

        if (name != null && price != null) {
            Product product = new Product(null, name, Integer.parseInt(price));
            productRepository.save(product);
        }

        resp.sendRedirect("/");
    }
}
