package com.buddheshwar.internshiparoma.model;

public class EducationData {

    private int startYear;
    private int endYear;
    private String college;
    private String degree;
    private String stream;
    private String type;

    private String performanceScale;
    private float performance;

    private int year;
    private String school;
    private String board;

    public EducationData(String type, int startYear, int endYear, String college, String degree, String stream, String performanceScale, float performance){
        this.startYear=startYear;
        this.endYear=endYear;
        this.college=college;
        this.degree=degree;
        this.performanceScale=performanceScale;
        this.performance=performance;
        this.stream=stream;
        this.type=type;
    }
    public EducationData(String type, int startYear, int endYear, String college, String stream, String performanceScale, float performance){
        this.startYear=startYear;
        this.endYear=endYear;
        this.college=college;
        this.performanceScale=performanceScale;
        this.performance=performance;
        this.stream=stream;
        this.type=type;
    }

    public EducationData(String type,int year,String board,String school,String stream,String performanceScale,float performance){
        this.year=year;
        this.board=board;
        this.school=school;
        this.performanceScale=performanceScale;
        this.performance=performance;
        this.stream=stream;
        this.type=type;

    }
    public EducationData(String type,int year,String board,String school,String performanceScale,float performance){
        this.year=year;
        this.board=board;
        this.school=school;
        this.performanceScale=performanceScale;
        this.performance=performance;
        this.type=type;

    }

    public String getType(){
        return type;
    }
    public void setType(){
        this.type=type;
    }
    public int getStartYear(){
        return startYear;
    }
    public void setStartYear(){
        this.startYear=startYear;
    }
    public int getEndYear(){
        return endYear;
    }
    public void setEndYear(){
        this.endYear=endYear;
    }
    public String getCollege(){
        return college;
    }
    public void setCollege(){
        this.college=college;
    }
    public String getDegree(){
        return degree;
    }
    public void setDegree(){
        this.degree=degree;
    }
    public String getPerformanceScale(){
        return performanceScale;
    }
    public void setPerformanceScale(){
        this.performanceScale=performanceScale;
    }
    public String getStream(){
        return stream;
    }
    public void setStream(){
        this.stream=stream;
    }
    public float getPerformance(){
        return performance;
    }
    public void setPerformance(){
        this.performance=performance;
    }
    public int getYear(){
        return year;
    }
    public void setYear(){
        this.year=year;
    }
    public String getBoard(){
        return board;
    }
    public void setBoard(){
        this.board=board;
    }
    public String getSchool(){
        return school;
    }
    public void setSchool(){
        this.school=school;
    }
}
