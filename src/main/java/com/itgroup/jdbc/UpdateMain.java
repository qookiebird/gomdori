package com.itgroup.jdbc;

import com.itgroup.bean.Member;
import com.itgroup.dao.MemberDao;

import java.util.Scanner;

public class UpdateMain {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        Member bean = new Member();

        Scanner scan = new Scanner(System.in);
        System.out.print("멤버 아이디 : ");
        String id = scan.next();

        System.out.print("멤버 이름: ");
        String name = scan.next();

        bean.setId(id);
        bean.setName(name);
        bean.setSsn("000000-0000000");
        bean.setAddress("대구");
        bean.setGender("외계인");
        bean.setEmail("qqq@naver.com");
        bean.setHiredate("2000/01/01");

        int cnt = -1;
        cnt = dao.updateData(bean);

        if(cnt==-1){
            System.out.println("멤버 수정에 실패하였습니다.");
        }else {
            System.out.println("멤버 수정에 성공하였습니다.");

        }
    }
}