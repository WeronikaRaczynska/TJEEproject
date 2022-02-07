package CRUDoperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hibernate.Blake;
import EJB.bean;
import hibernate.BlakeQuery;

@WebServlet(name = "ShowDatabase", urlPatterns = {"/ShowDatabase","/Insert","/Delete","/Update"})
public class ShowDatabase extends HttpServlet {

    @EJB
    bean newbean;
    private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
            String text = newbean.getNewText();
            String hash = newbean.getHashFunction() ;
            Blake blake = new Blake(text,hash);
            new BlakeQuery().insert(blake);
            response.sendRedirect("ShowDatabase");
    }
    private void delete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String del = request.getParameter("Del");
        new BlakeQuery().delete(del);
        response.sendRedirect("ShowDatabase");
    
    }
    private void update(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{
            String text = request.getParameter("Text");
            String hash=request.getParameter("Hash");
            Blake blake = new Blake(text,hash);
            new BlakeQuery().update(blake);
            response.sendRedirect("ShowDatabase");
    }   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link rel=\"stylesheet\" href=\"Style/css/styles.css\">");        
            out.println("</head>");
            out.println("<body><div id=\"tablePage\">");
            out.println("<h1>History of hashes</h1>");
            out.println(new BlakeQuery().getBlakeList());
            out.println("<form><input type=\"submit\" class=\"insubmit\" value=\"Back\" formaction=\"/Final1/\"/>");
            //out.println(request.getHeader("referer"));
            //out.println("/>");
            out.println("<input type=\"submit\" class=\"insubmit\" value=\"Edit Table\" formaction=\"/Final1/editPage.jsp\"/>");
            out.println("</form><br/><br/></div></body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/Insert":
                    insert(request, response);
                    break;
                    
                case "/Delete":
                    delete(request, response);
                    break;
                    
                case "/Update":
                    update(request, response);
                    break;

                default:
                    processRequest(request, response);
                    break;
           }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
