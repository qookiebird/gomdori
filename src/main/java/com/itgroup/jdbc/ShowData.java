package com.itgroup.jdbc;

import com.itgroup.bean.Member;

public class ShowData {
    public static void printBean(Member bean) {
        String id = bean.getId();
        String name = bean.getName();
        String ssn = bean.getSsn();
        String address = bean.getAddress();
        String gender = bean.getGender();
        String email = bean.getEmail();
        String hiredate = bean.getHiredate();

        System.out.println("아이디 : " + id);
        System.out.println("이름 : " + name);
        System.out.println("주민 번호 : " + ssn);
        System.out.println("주소 : " + address);
        System.out.println("성별 : " + gender);
        System.out.println("이메일 : " + email);
        System.out.println("입사 일자 : " + hiredate);
        System.out.println("===================");
    }
}
