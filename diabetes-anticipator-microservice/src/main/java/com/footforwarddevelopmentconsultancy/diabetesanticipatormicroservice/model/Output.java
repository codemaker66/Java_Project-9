package com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model;

public class Output {
    private String name;
    private String familyName;
    private int age;
    private String diabetesAssessment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiabetesAssessment() {
        return diabetesAssessment;
    }

    public void setDiabetesAssessment(String diabetesAssessment) {
        this.diabetesAssessment = diabetesAssessment;
    }
}
