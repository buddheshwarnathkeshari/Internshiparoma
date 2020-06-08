package com.buddheshwar.internshiparoma.model;

public class SkillData {

    private String title,skillLevel;

    public  SkillData(String title,String skillLevel) {
        this.title=title;
        this.skillLevel=skillLevel;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
