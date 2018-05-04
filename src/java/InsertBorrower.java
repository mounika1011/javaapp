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
public class InsertBorrower extends HttpServlet {

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
            out.println("<title>Servlet InsertBorrower</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertBorrower at " + request.getContextPath() + "</h1>");
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
            String card_no=request.getParameter("c_no").trim();
            String b_name=request.getParameter("b_name").trim();
            String b_address=request.getParameter("b_add").trim();
             String b_phone=request.getParameter("b_phone").trim();
              try{  
                    
               
                Class.forName(driver);
                //pw.println("ssstvvvvvvtt............");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "omsrisairam");
                //pw.println("ssstpppppppp............");
               // pw.println(isbn_no);
                // pw.println(title);
                 // pw.println(publisher_id);
                 // pw.println(author_id);
                   //pw.println(b_phone);
                  
                stmt=conn.createStatement();
                
               //String q="insert into book (ISBN,Title,PublisherId,AuthorID,PublishDate,AvailableCopies) values ('"+isbn_no+"','"+title+"','"+publisher_id+"','"+author_id+"','"+publisher_date+"','"+available_copies+"')";
                String q = "insert into borrower(Card_No,B_name,B_address,B_phone)values('"+card_no+"','"+b_name+"','"+b_address+"','"+b_phone+"');";
              
               int result=stmt.executeUpdate(q);
               //pw.println(result);
               if(result>0)
               {
                   pw.println("Succesfully inserted");
               }
               else
               {
                   RequestDispatcher rd=request.getRequestDispatcher("Main.jsp");
               }
               //pw.println("res"+result);
               
                     //  pw.println("check wat is happening.............");
               /*if(result>0)
                    {
                        int m=0;
                         //pw.println("entered");
                        while(rs.next())
                            {
                                //pw.println("Tell me what is happening inside the loop i want to know.............");
                               
                                //isbn_no=rs.getString(1);
                                //pw.println(isbn_no);
                                    //pw.println("fname");
                                //publisher_id=rs.getString(3);
                                 //author_id=rs.getString(4);
                                 //publisher_date=rs.getString(5);
                                 //available_copies=rs.getString(6);
                              
                           }
                      
                              RequestDispatcher rd=request.getRequestDispatcher("insertbook.jsp"); 
                            
                               //res= isbn_no+","+publisher_id+","+author_id+","+publisher_date+","+available_copies+"";
                           
                            //  pw.println(res);   
                            //request.setAttribute("title",res);
                            
                            //rd.include(request,response);
 }*/
               /* else{
                    
                    pw.println("exception");
                    RequestDispatcher rd=request.getRequestDispatcher("insertbook.jsp");  
                    rd.forward(request,response);
                
                }*/
             pw.close();
             }
    catch(Exception e){
    
              //RequestDispatcher rd=request.getRequestDispatcher("insertbook.jsp");  
                //    rd.forward(request,response);
    
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
