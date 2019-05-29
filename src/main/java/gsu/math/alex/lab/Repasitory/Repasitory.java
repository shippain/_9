package gsu.math.alex.lab.Repasitory;

import gsu.math.alex.lab.Model.IEntity;

import java.util.List;

public interface Repasitory<T extends IEntity> {
    void save (T t);
    T findById (int id);
    List<T> findAll();
    void delete (int id);
}
