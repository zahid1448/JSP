package org.btm.curdApp;
import java.util.*;
import org.btm.curd.Emp;
import java.sql.*;  
public class EmpDao {  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into btm.studentss values(?,?,?,?,?,?,?,?)");  
            ps.setInt(1,e.getId ()); 
            ps.setString(2,e.getEmployee_code());  
            ps.setString(3,e.getEmail_Id()); 
            ps.setString(4,e.getContact_No());  
            ps.setString(5,e.getReporting_Manager());  
            ps.setString(6,e.getStatus()); 
            ps.setObject(7,e.getDate_Of_Joining()); 
            ps.setObject(8,e.getDate_Of_Resigning()); 
            status=ps.executeUpdate();  
          //  con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update btm.studentss set Employee_code=?,Email_Id=?,Contact_No=?,Reporting_Manager=?,Status=?,Date_Of_Joining=?,Date_Of_Resigning=? where id=?");
           // ps.setString(1,e.getEmployee_Name());
            ps.setString(1,e.getEmployee_code());  
            ps.setString(2,e.getEmail_Id());  
            ps.setString(3,e.getContact_No());  
            ps.setString(4,e.getReporting_Manager());  
            ps.setString(5,e.getStatus());  
            ps.setObject(6,e.getDate_Of_Joining()); 
            ps.setObject(7,e.getDate_Of_Resigning()); 
            ps.setInt (8,e.getId());
            status=ps.executeUpdate();  
            //con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
        return status;  
    }  
    public static int delete(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from btm.studentss where id=?");  
            ps.setInt(1,e.getId()); 
            status=ps.executeUpdate();  
        }
        catch(Exception e1)
        {e1.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from btm.studentss where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1)); 
                e.setEmployee_code(rs.getString(2));  
                e.setEmail_Id(rs.getString(3));  
                e.setContact_No(rs.getString(4));  
                e.setReporting_Manager(rs.getString(5));  
                e.setStatus(rs.getString(6)); 
                e.setDate_Of_Joining(rs.getDate(7)); 
                e.setDate_Of_Resigning(rs.getDate(8)); 
            }  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from btm.studentss");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1)); 
                e.setEmployee_code(rs.getString(2));  
                e.setEmail_Id(rs.getString(3));  
                e.setContact_No(rs.getString(4));  
                e.setReporting_Manager(rs.getString(5));  
                e.setStatus(rs.getString(6)); 
                e.setDate_Of_Joining(rs.getDate(7)); 
                e.setDate_Of_Joining(rs.getDate(8)); 
                list.add(e);  
                            }  
                        }
        catch(Exception e){e.printStackTrace();
                          }  
        return list;  
    }  
}  