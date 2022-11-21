package org.backend.models;

import java.util.Date;
import java.util.List;

public class EmployeeDetails {

    private Integer createdAt;
    private String employee_firstname;
    private String employee_lastname;
    private String employee_phonenumbe;
    private String ademployee_emaildress;
    private String citemployee_addressy;
    private String stateemployee_dev_level;
    private Date employee_hire_date;
    private String employee_gender;
    private boolean employee_onleave;
    private List<String> tech_stack;
    private List<String> project;

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public void setEmployee_firstname(String employee_firstname) {
        this.employee_firstname = employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

    public String getEmployee_phonenumbe() {
        return employee_phonenumbe;
    }

    public void setEmployee_phonenumbe(String employee_phonenumbe) {
        this.employee_phonenumbe = employee_phonenumbe;
    }

    public String getAdemployee_emaildress() {
        return ademployee_emaildress;
    }

    public void setAdemployee_emaildress(String ademployee_emaildress) {
        this.ademployee_emaildress = ademployee_emaildress;
    }

    public String getCitemployee_addressy() {
        return citemployee_addressy;
    }

    public void setCitemployee_addressy(String citemployee_addressy) {
        this.citemployee_addressy = citemployee_addressy;
    }

    public String getStateemployee_dev_level() {
        return stateemployee_dev_level;
    }

    public void setStateemployee_dev_level(String stateemployee_dev_level) {
        this.stateemployee_dev_level = stateemployee_dev_level;
    }

    public Date getEmployee_hire_date() {
        return employee_hire_date;
    }

    public void setEmployee_hire_date(Date employee_hire_date) {
        this.employee_hire_date = employee_hire_date;
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public boolean isEmployee_onleave() {
        return employee_onleave;
    }

    public void setEmployee_onleave(boolean employee_onleave) {
        this.employee_onleave = employee_onleave;
    }

    public List<String> getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(List<String> tech_stack) {
        this.tech_stack = tech_stack;
    }

    public List<String> getProject() {
        return project;
    }

    public void setProject(List<String> project) {
        this.project = project;
    }
}
