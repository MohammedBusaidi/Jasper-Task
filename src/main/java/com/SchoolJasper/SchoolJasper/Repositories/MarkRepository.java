package com.SchoolJasper.SchoolJasper.Repositories;

import com.SchoolJasper.SchoolJasper.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
}
