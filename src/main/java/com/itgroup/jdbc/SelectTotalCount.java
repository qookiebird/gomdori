package com.itgroup.jdbc;

import com.itgroup.dao.MemberDao;

import java.util.Scanner;

public class SelectTotalCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("여자, 남자 중 1개 입력: ");
        String gender = scan.next();

        MemberDao dao = new MemberDao();
        int totalCount = dao.getTotalCount(gender);
        if(gender.equals("all")){
            System.out.println("상품 전체 개수 : " + totalCount);

        }else {
            String message = "성별 %s의 개수 :  %d\n";
            System.out.printf(message,gender,totalCount);
        }

    }
}
