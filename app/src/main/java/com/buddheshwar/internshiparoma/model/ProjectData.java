package com.buddheshwar.internshiparoma.model;

public class ProjectData {
    private String title;
    private String link;
    private String description;
    private String startDate;
    private String endDate;

    public  ProjectData(String title,String startDate,String endDate,String description,String link) {
        this.title=title;
        this.link=link;
        this.description=description;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
