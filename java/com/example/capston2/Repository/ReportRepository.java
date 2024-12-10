package com.example.capston2.Repository;

import com.example.capston2.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Integer> {

    Report findReportByReportId(Integer id);
}
