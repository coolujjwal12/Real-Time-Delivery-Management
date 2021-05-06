package cal;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
@SuppressWarnings("serial")
public class driv extends HttpServlet {
	   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	   {
		   PrintWriter pw=res.getWriter();
		   res.setContentType("text/html");
		   String pic1=req.getParameter("pic1");
		   String drp1=req.getParameter("drp1");
		   String pic2=req.getParameter("pic2");
		   String drp2=req.getParameter("drp2");
		   String pic3=req.getParameter("pic3");
		   String drp3=req.getParameter("drp3");
		   graph g=new graph();
		   ArrayList<String> str=new ArrayList<String>();
		   g.makeGraph();
		   str=g.getReal(pic1, drp1);
		   pw.println("<p><h4>Delivery Executive "+str.get(0)+" will go to take the order</h4></p>");
		   pw.println("<p>Path taken by the delivery Executive</p>");
		   pw.println("<p style=\"color:DodgerBlue;\">"+str.get(1)+" "+str.get(2)+"</p>");
		   str=g.getReal(pic2, drp2);
		   pw.println("<p><h4>Delivery Executive "+str.get(0)+" will go to take the order</h4></p>");
		   pw.println("<p>Path taken by the delivery Executive</p>");
		   pw.println("<p style=\"color:DodgerBlue;\">"+str.get(1)+" "+str.get(2)+"</p>");
		   str=g.getReal(pic3, drp3);
		   pw.println("<p><h4>Delivery Executive "+str.get(0)+" will go to take the order</h4></p>");
		   pw.println("<p>Path taken by the delivery Executive</p>");
		   pw.println("<p style=\"color:DodgerBlue;\">"+str.get(1)+" "+str.get(2)+"</p>");
		   pw.close();
	   }
}
	   