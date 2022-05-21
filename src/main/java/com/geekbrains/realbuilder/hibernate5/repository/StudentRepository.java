package com.geekbrains.realbuilder.hibernate5.repository;

import com.geekbrains.realbuilder.hibernate5.model.Students;
import java.util.List;

public interface StudentRepository extends BaseRepository<Students, Long>{
    Long countAll();
    List<Students> findByName(String name);
    List<Students> mergeBatch(List<Students> entities);
    boolean removeAll();
}
