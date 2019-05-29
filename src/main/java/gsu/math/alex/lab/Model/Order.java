package gsu.math.alex.lab.Model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order implements IEntity {
    private Integer id;
    private Date date;
    private String phone;
    private List<Product> products;
}
