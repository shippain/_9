package gsu.math.alex.lab.servlet.product;

import gsu.math.alex.lab.model.Product;
import gsu.math.alex.lab.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("")
public class RootServlet extends HttpServlet {

    ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository  = new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> p = new ArrayList<>(productRepository.findAll());

        req.setAttribute("productList",p);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }
}
