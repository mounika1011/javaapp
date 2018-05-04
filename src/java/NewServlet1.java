/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mouni
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        }
    }

    
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
            PrintWriter pw = response.getWriter(); 
            Connection conn=null;
            Statement stmt=null;
            ResultSet rs=null;
            String res="";
             String url="jdbc:mysql://localhost:3306/";
            String driver="com.mysql.jdbc.Driver";
            String isbn_no ="";//= request.getParameter("isbn").trim();  
            String title=request.getParameter("title").trim();
           // pw.println(title);
            //String card_no="";//=request.getParameter("card_no").trim();
            //String author_name="";//=request.getParameter("a_name").trim();
            String publisher_id="";//=request.getParameter("p_id").trim();
            String author_id="";//=request.getParameter("a_id").trim();
            String publisher_date="";//=request.getParameter("p_date").trim();
            String available_copies="";//=request.getParameter("avail_copies").trim();
          //  pw.println("sssttttttttt............");
            try{  
                    
               
                Class.forName(driver);
                //pw.println("ssstvvvvvvtt............");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "root");
               // pw.println("ssstpppppppp............");
                stmt=conn.createStatement();
                
                rs=stmt.executeQuery("select * from book where title='"+title+"'");
                     //  pw.println("check wat is happening.............");
                if(rs!=null)
                    {
                         //pw.println("entered");
                        while(rs.next())
                            {
                                //pw.println("Tell me what is happening inside the loop i want to know.............");
                               
                                isbn_no=rs.getString(1);
                                //pw.println(isbn_no);
                                    //pw.println("fname");
                                publisher_id=rs.getString(3);
                                 author_id=rs.getString(4);
                                 publisher_date=rs.getString(5);
                                 available_copies=rs.getString(6);
                              
                           }
                      
                              RequestDispatcher rd=request.getRequestDispatcher("index1.jsp"); 
                            
                               res= isbn_no+","+publisher_id+","+author_id+","+publisher_date+","+available_copies+"";
                           
                            //  pw.println(res);   
                            request.setAttribute("title",res);
                            
                            rd.include(request,response);
 }
                else{
                    
                    pw.println("exception");
                    RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");  
                    rd.forward(request,response);
                
                }
             pw.close();
             }
    catch(Exception e){
    
              RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");  
                    rd.forward(request,response);
    
    }
	
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
