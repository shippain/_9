package gsu.math.alex.lab.servlet.product;

import gsu.math.alex.lab.model.Product;
import gsu.math.alex.lab.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/update")
public class EditProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("product_id"));

        Product product = productRepository.findById(id);
        req.setAttribute("product", product);

        req.getRequestDispatcher("/update_product.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("product_id"));
        String name = req.getParameter("product_name");
        int price =  Integer.parseInt(req.getParameter("product_price"));

        Product product = new Product(id, name, price);
        productRepository.save(product);

        resp.sendRedirect("/");
    }
}
