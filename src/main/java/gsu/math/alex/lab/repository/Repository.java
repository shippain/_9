package gsu.math.alex.lab.repository;

import gsu.math.alex.lab.model.IEntity;

import java.util.List;

public interface Repository<T extends IEntity> {
    void save (T t);
    T findById (int id);
    List<T> findAll();
    void delete (int id);
}
