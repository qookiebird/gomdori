package com.itgroup.jdbc;

import com.itgroup.bean.Member;
import com.itgroup.dao.MemberDao;
import com.itgroup.utility.Paging;

import java.util.List;
import java.util.Scanner;

public class SelectPagination {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("몇 페이지 볼꺼니?");
        String pageNumber = scan.next(); //10

        System.out.print("페이지 당 몇 건씩 볼꺼니?");
        String pageSize = scan.next();

        System.out.print("all, 남자, 여자 중 1개 입력 : ");
        String mode = scan.next(); //검색 모드(무엇을 검색할 것인가?)

        MemberDao dao = new MemberDao();
        int totalCount = dao.getTotalCount(mode);

        String url = "mbList.jsp";
        String keyword = "";

        Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, mode, keyword);
        pageInfo.displayInformation();

        List<Member> memberList = dao.getPaginationDate(pageInfo);

        for(Member bean : memberList){
            ShowData.printBean(bean);
        }

    }
}
