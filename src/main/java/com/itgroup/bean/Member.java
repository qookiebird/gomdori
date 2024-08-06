package com.itgroup.bean;

public class Member {



    private String id;
    private String name;
    private String ssn;
    private String address;
    private String gender;
    private String email;
    private String hiredate;

    //getter, setter, toString(), 생성자 구현


    public Member() {
    }

    public Member(String id, String name, String ssn, String address, String gender, String email, String hiredate) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.hiredate = hiredate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }
}
