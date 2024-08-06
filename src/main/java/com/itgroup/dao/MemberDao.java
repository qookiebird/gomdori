package com.itgroup.dao;

import com.itgroup.bean.Member;
import com.itgroup.utility.Paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao extends Superdao{
    public List<Member> getPaginationDate(Paging pageInfo) {

        Connection conn = null ;
        String sql = " select id, name, ssn, address, gender, email, hiredate ";
        sql += "from ( ";
        sql += " select id, name, ssn, address, gender, email, hiredate, ";
        sql += " rank() over(order by id desc) as ranking ";
        sql += " from members ";

        // mode가 all이 아니면 where 절이 추가로 필요합니다.
        String mode = pageInfo.getMode();
        boolean bool = mode.equals(null) || mode.equals("null") || mode.equals("") || mode.equals("all");

        if(!bool){
            sql +=" where gender = ? ";
        }

        sql += " ) ";
        sql += " where ranking between ? and ? " ;


        PreparedStatement pstmt = null ;
        ResultSet rs = null ;

        List<Member> allData = new ArrayList<>();
        try{
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);

            if(!bool){
                pstmt.setString(1,mode);
                pstmt.setInt(2,pageInfo.getBeginRow());
                pstmt.setInt(3,pageInfo.getEndRow());
            }else {
                pstmt.setInt(1,pageInfo.getBeginRow());
                pstmt.setInt(2,pageInfo.getEndRow());

            }


            rs = pstmt.executeQuery() ;

            while(rs.next()){
                Member bean = this.makeBean(rs);
                allData.add(bean);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(rs!=null){rs.close();}
                if(pstmt!=null){pstmt.close();}
                if(conn!=null){conn.close();}
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return allData ;
    }


    public int getTotalCount(String gender){
        int totalCount = 0;
        String sql = "select count(*) as mycnt from members";

        boolean bool = gender == null || gender.equals("all");
        if(!bool){
            sql += " where gender = ? " ;
        }

        Connection conn = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;

        try{
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);

            if(!bool){
                pstmt.setString(1,gender);
            }

            rs = pstmt.executeQuery() ;

            if(rs.next()){
                totalCount = rs.getInt("mycnt");

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(rs!=null){rs.close();}
                if(pstmt!=null){pstmt.close();}
                if(conn!=null){conn.close();}
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return totalCount;
    }



    public MemberDao() {
        super();
    }

    public List<Member> selectAll() {
        Connection conn = null;
        PreparedStatement pstmt =null;
        String sql = "select * from members order by name desc ";
        ResultSet rs = null;

        List<Member> allData = new ArrayList<Member>();


        try {
                conn = super.getConnection();
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while(rs.next()){
                    Member bean = this. makeBean(rs);
                    allData.add(bean);
                }

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                if(rs!=null) {rs.close();}
                if(pstmt!=null) {pstmt.close();}
                if(conn!=null) {conn.close();}
            }catch(Exception ex) {
                ex.printStackTrace();
            }

        }
        return allData;

    }

    private Member makeBean(ResultSet rs) {
        Member bean = new Member();
        try {
            bean.setId(rs.getString("id"));
            bean.setName(rs.getString("name"));
            bean.setSsn(rs.getString("ssn"));
            bean.setAddress(rs.getString("address"));
            bean.setGender(rs.getString("gender"));
            bean.setEmail(rs.getString("email"));
            bean.setHiredate(rs.getString("hiredate"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bean;
    }


    public List<Member> selectByGender(String gender) {
        Connection conn = null;
        String sql = "select * from members" ;

        boolean bool = gender == null || gender.equals("all");
        if(!bool){
            sql += " where gender = ?";

        }
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Member> allData = new ArrayList<>();

        try{
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            if(!bool){
                pstmt.setString(1,gender);
            }

            rs = pstmt.executeQuery() ;



            while(rs.next()){
                Member bean = this.makeBean(rs);
                allData.add(bean);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(rs!=null){rs.close();}
                if(pstmt!=null){pstmt.close();}
                if(conn!=null){conn.close();}
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return allData ;
    }


    public Member selectByPK(String id) {
        Connection conn = null ;
        String sql = "select * from members" ;
        sql += " where pnum= ?";
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;

        Member bean = null;
        try{
            conn = super.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery() ;

            if(rs.next()){
                bean = this.makeBean(rs);

            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(rs!=null){rs.close();}
                if(pstmt!=null){pstmt.close();}
                if(conn!=null){conn.close();}
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return bean ;
    }


    public int updateData(Member bean) {
        System.out.println(bean);
        int cnt = -1;
        Connection conn =null ;
        PreparedStatement pstmt = null;
        String sql = " update members set name =?,ssn=?,address=?,gender=?,email=?,hiredate=?";
        sql += " where id = ?";


        try {
            conn =super.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,bean.getName());
            pstmt.setString(2,bean.getSsn());
            pstmt.setString(3,bean.getAddress());
            pstmt.setString(4,bean.getGender());
            pstmt.setString(5,bean.getEmail());
            pstmt.setString(6,bean.getHiredate());
            pstmt.setString(7,bean.getId());

            cnt = pstmt.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally {
            try {
                if(pstmt!=null){pstmt.close();}
                if(conn!=null){conn.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return cnt ;
    }

    public int deleteData(String id) {
        System.out.println("기본 키 = " + id);
        int cnt = -1;
        Connection conn =null ;
        PreparedStatement pstmt = null;
        String sql = "delete from members " ;
        sql += " where id = ?";


        try {
            conn =super.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,id);

            cnt = pstmt.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally {
            try {
                if(pstmt!=null){pstmt.close();}
                if(conn!=null){conn.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


        return cnt ;
    }


}
