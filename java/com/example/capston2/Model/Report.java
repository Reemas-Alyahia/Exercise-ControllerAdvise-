package com.example.capston2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @NotNull(message = " customerId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer customerId;

    @NotEmpty(message = "Health status must not be empty!")
    @Pattern(regexp = "^(Healthy|Injured|Critical)$",
            message = "Health status must be one of the following: 'Healthy', 'Injured', or 'Critical'")
    @Column(columnDefinition = "varchar(10) not null")
    private String healthStatus;

    @NotEmpty(message = "location must not be Empty!...")
    @Column(columnDefinition ="varchar(200) not null")
    private String location;

    @Pattern(regexp = "^(Available|Adopted|Unavailable)$",message = "the adoption Status must be \"Available\" or \"Adopted\" or \"Unavailable\"")
    @Column(columnDefinition = "varchar(20) not null")
    private String adoptionStatus;

    @Pattern(regexp = "^(Pending|Reviewed)$",message = "the Status must be \"Pending\" or  \"Reviewed\"")
    private String status;

    @NotEmpty(message = "description must not be Empty!...")
    @Column(columnDefinition ="varchar(200) not null")
    private String description;

    @NotNull(message = " customerId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer volId;

    public Report(Integer reportId, Integer customerId, String healthStatus, String location, String adoptionStatus, String status, String description, Integer volId) {
        this.reportId = reportId;
        this.customerId = customerId;
        this.healthStatus = healthStatus;
        this.location = location;
        this.adoptionStatus = adoptionStatus;
        this.status = status;
        this.description = description;
        this.volId = volId;
    }

    public Report() {
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVolId() {
        return volId;
    }

    public void setVolId(Integer volId) {
        this.volId = volId;
    }
}
