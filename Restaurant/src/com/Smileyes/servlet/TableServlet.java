package com.Smileyes.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.FoodTable;
import com.Smileyes.entity.OrderDetail;
import com.Smileyes.entity.Orders;
import com.Smileyes.factory.BeanFactory;
import com.Smileyes.service.TableService_IN;
import com.Smileyes.utils.WebUtils;

/**
 * 餐桌服务类
 */
public class TableServlet extends HttpServlet {
	public static TableService_IN service = BeanFactory.getBean("tableService",
			TableService_IN.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("tableList".equals(method)) {
			this.list(request, response);
		} else if ("add".equals(method)) {
			this.addTable(request, response);
		} else if ("delete".equals(method)) {
			this.delete(request, response);
		} else if ("update".equals(method)) {
			this.update(request, response);
		} else if ("find".equals(method)) {
			this.find(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<FoodTable> list = TableServlet.service.getAll();
		request.setAttribute("tableList", list);
		try {
			request.getRequestDispatcher("sys/table/tableList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}

	}

	// 根据名称查找
	private void find(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("tableName");
		List<FoodTable> list = this.service.findByName(name);
		request.setAttribute("tableList", list);
		request.setAttribute("search", name);
		try {
			request.getRequestDispatcher("sys/table/tableList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 改变餐桌状态
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			FoodTable ft = WebUtils.copyToBean(request, FoodTable.class);
			this.service.update(ft);
			String path = request.getServletContext().getContextPath();
			this.list(request, response);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Orders> odList = OrderServlet.service.findByTableId(id);
		FoodTable ft = this.service.findById(id);
		if (ft.getTableStatus() == 0 && (odList == null || odList.isEmpty())) {
			this.service.delete(id);
			this.list(request, response);
		} else {
			try {
				request.getRequestDispatcher("sys/error/tableDelError.jsp").forward(request,
						response);
			} catch (IOException | ServletException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// 添加餐桌
	private void addTable(HttpServletRequest request, HttpServletResponse response) {
		String name = (String) request.getParameter("tableName");
		try {
			FoodTable ft = WebUtils.copyToBean(request, FoodTable.class);
			this.service.add(ft);
			this.list(request, response);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
