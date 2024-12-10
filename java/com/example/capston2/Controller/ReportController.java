package com.example.capston2.Controller;

import com.example.capston2.ApiResponse.ApiResponse;
import com.example.capston2.Model.Cat;
import com.example.capston2.Model.Report;
import com.example.capston2.Service.ReportService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/get")
   public ResponseEntity getAllReport() {
        return  ResponseEntity.status(200).body(reportService.getAllReport());
    }

    @PostMapping("/add")
   public ResponseEntity addNewReport(@RequestBody @Valid Report report){
      reportService.addNewReport(report);
       return ResponseEntity.status(200).body(new ApiResponse("تم رفع البلاغ ،شكرا لك"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateReport(@PathVariable Integer id, @RequestBody @Valid Report report){

        reportService.updateReport(report,id);
        return ResponseEntity.status(200).body(new ApiResponse("Report updated"));
   }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteReport(@PathVariable Integer id){
        reportService.deleteRepor(id);
        return ResponseEntity.status(200).body(new ApiResponse("Report Deleted"));
    }

    @PutMapping("/updateHealth/volunteerId/{volunteerId}/cats/{catId}/HealthStatus/{healthStatus}")
    public ResponseEntity updateCatHealthStatus(@PathVariable Integer volunteerId,@PathVariable String healthStatus ,@PathVariable Integer catId) {
        String result = reportService.updateCatHealthStatus(volunteerId,catId,healthStatus);
        return ResponseEntity.status(200).body(result);
    }
}
