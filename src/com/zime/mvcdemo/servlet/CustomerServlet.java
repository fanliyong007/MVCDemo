package com.zime.mvcdemo.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zime.mvcdemo.dao.CustomerDAO;
import com.zime.mvcdemo.impl.CustomerDAOJdbcImpl;
import com.zime.mvcdemo.entity.Customer;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("*.do")
public class CustomerServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String method=request.getParameter("method");
//		switch(method) {
//			case "add":{
//				add(request,response);
//				break;
//			}
//			case "update":{
//				update(request,response);
//				break;
//			}
//			case "delete":{
//				delete(request,response);
//				break;
//			}
//		}
//	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        String servletPath = req.getServletPath();// /add.do
        //去掉/, .do
        String methodName = servletPath.substring(1);// add.do
        methodName = methodName.substring(0, methodName.length() - 3);
        try
        {
            //利用反射获取methodName对应的方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class
            );
            method.invoke(this, req, resp);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //获取查询条件
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        //调用getAll方法获取数据
        List<Customer> customers = customerDAO.getAll();
        //把Customers集合放入request中
        request.setAttribute("customers", customers);
        //转发页面到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
