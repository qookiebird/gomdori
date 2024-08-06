package com.itgroup.jdbc;

import com.itgroup.bean.Member;
import com.itgroup.dao.MemberDao;

import java.util.Scanner;

public class DeleteMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 아이디 번호: ");
        String id = scan.next();
//라랄랄랄라
        //하하하하하하하하하


        MemberDao dao = new MemberDao();
        int cnt = -1;
        cnt = dao.deleteData(id);

        if(cnt==-1){
            System.out.println("멤버 삭제에 실패하였습니다.");
        }else {
            System.out.println("멤버 삭제에 성공하였습니다.");

        }
    }
}
