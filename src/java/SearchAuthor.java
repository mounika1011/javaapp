/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mouni
 */
public class SearchAuthor extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchAuthor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchAuthor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
            String a_name=request.getParameter("a_name").trim();
            String a_id="";//= request.getParameter("isbn").trim();  
            
            String a_email="";//=request.getParameter("p_id").trim();
      
            
            
            try{  
                    
               
                Class.forName(driver);
                //pw.println("ssstvvvvvvtt............");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "omsrisairam");
               // pw.println("ssstpppppppp............");
                stmt=conn.createStatement();
                
                rs=stmt.executeQuery("select * from author where A_name='"+a_name+"'");
                     //  pw.println("check wat is happening.............");
                if(rs!=null)
                    {
                         //pw.println("entered");
                        while(rs.next())
                            {
                                //pw.println("Tell me what is happening inside the loop i want to know.............");
                               
                                a_id=rs.getString(1);
                                //pw.println(isbn_no);
                                    //pw.println("fname");
                                a_email=rs.getString(3);
                               
                                 
                              
                           }
                      
                              RequestDispatcher rd=request.getRequestDispatcher("index4.jsp"); 
                            
                               res= a_id+","+a_email;
                           
                            //  pw.println(res);   
                            request.setAttribute("a_name",res);
                            
                            rd.include(request,response);
 }
                else{
                    
                    pw.println("exception");
                    RequestDispatcher rd=request.getRequestDispatcher("index4.jsp");  
                    rd.forward(request,response);
                
                }
             pw.close();
             }
    catch(Exception e){
    
              RequestDispatcher rd=request.getRequestDispatcher("index4.jsp");  
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
