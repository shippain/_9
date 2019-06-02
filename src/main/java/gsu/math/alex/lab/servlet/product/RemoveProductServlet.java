package gsu.math.alex.lab.servlet.product;

import gsu.math.alex.lab.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/remove")
public class RemoveProductServlet extends HttpServlet {

    private ProductRepository productRepository ;

    @Override
    public void init() throws ServletException {
        productRepository = new ProductRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id =  Integer.parseInt(req.getParameter("product_id"));
        productRepository.delete(id);

        resp.sendRedirect("/");
    }
}
