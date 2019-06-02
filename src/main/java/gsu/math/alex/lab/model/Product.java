package gsu.math.alex.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product implements IEntity {
    private Integer id;
    private String name;
    private int price;
}
