package com.geekbrans.Springlesson7.repositories;

import com.geekbrans.Springlesson7.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
}