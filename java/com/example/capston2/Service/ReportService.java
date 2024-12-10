package com.example.capston2.Service;

import com.example.capston2.ApiResponse.ApiExption;
import com.example.capston2.Model.Cat;
import com.example.capston2.Model.Customer;
import com.example.capston2.Model.Report;
import com.example.capston2.Model.Volunteer;
import com.example.capston2.Repository.CustomerRepository;
import com.example.capston2.Repository.ReportRepository;
import com.example.capston2.Repository.VolunteerRepository;
import jakarta.persistence.SequenceGenerators;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
   private final CustomerRepository customerRepository;
    private final VolunteerRepository volunteerRepository;
    public ReportService(ReportRepository reportRepository, CustomerRepository customerRepository, VolunteerRepository volunteerRepository) {
        this.reportRepository = reportRepository;
        this.customerRepository = customerRepository;
        this.volunteerRepository = volunteerRepository;
    }


    public List<Report> getAllReport(){
        return reportRepository.findAll();
    }

    public void addNewReport(Report report){
        Customer customer=customerRepository.findCustomerByCustomerId(report.getCustomerId());
        if(customer==null){
            throw new ApiExption("Cannot found the id of this customer");
        }
        Volunteer volunteer=volunteerRepository.findVolunteerByVolunterId(report.getVolId());
        if(volunteer==null){
            throw new ApiExption("Cannot found the id of this customer");
        }
        report.setAdoptionStatus("Unavailable");
        report.setStatus("Pending");
        reportRepository.save(report) ;  }


    public void updateReport(Report report,Integer id){
        Report oldReport=reportRepository.findReportByReportId(id);
        if(oldReport==null){
            throw new ApiExption("Cannot found the id of this report");
        }

        oldReport.setAdoptionStatus(report.getAdoptionStatus());
        oldReport.setLocation(report.getLocation());
        oldReport.setHealthStatus(report.getHealthStatus());
        oldReport.setDescription(report.getDescription());
        reportRepository.save(oldReport);
    }


    /// /Update that volunteer doing
    public String updateCatHealthStatus(Integer volunteerId, Integer reportId, String healthStatus) {
        Volunteer volunteer=volunteerRepository.findVolunteerByVolunterId(volunteerId);
        if (volunteer == null ) {
            throw new ApiExption("You are not authorized to update cat status, only volunteers can do this");
        }
       Report report = reportRepository.findReportByReportId(reportId);
        if (report == null) {
            throw new ApiExption("Cannot find a report with the provided ID");
        }
        if(report.getAdoptionStatus().equalsIgnoreCase("Unavailable")){
            report.setAdoptionStatus("Available");
        }
        report.setHealthStatus(healthStatus);
        report.setStatus("Reviewed");
        reportRepository.save(report);
        return " Number of  report Id " + reportId + "Done Update from volunteer" + volunteer.getName();
    }


    public void deleteRepor(Integer id){
       Report report= reportRepository.findReportByReportId(id);
        if(report==null){
            throw new ApiExption("Cannot found the repor with this id");

        }
       reportRepository.delete(report);
    }


}
