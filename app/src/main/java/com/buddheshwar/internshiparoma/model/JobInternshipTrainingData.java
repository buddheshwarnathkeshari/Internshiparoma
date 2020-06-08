package com.buddheshwar.internshiparoma.model;

public class JobInternshipTrainingData {

    private String type;
    private String profile;
    private String organization;
    private String location;
    private String description;
    private String startDate;
    private String endDate;

    public  JobInternshipTrainingData(String type,String profile,String organization,String location,String startDate,String endDate,String description) {
        this.type=type;
        this.profile=profile;
        this.organization=organization;
        this.location=location;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
