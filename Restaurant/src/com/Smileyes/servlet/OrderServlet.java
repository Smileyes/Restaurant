package com.Smileyes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.Food;
import com.Smileyes.entity.FoodTable;
import com.Smileyes.entity.OrderDetail;
import com.Smileyes.entity.Orders;
import com.Smileyes.factory.BeanFactory;
import com.Smileyes.service.OrderDetailService_IN;
import com.Smileyes.service.OrderService_IN;

/**
 * 订单服务类
 */
public class OrderServlet extends HttpServlet {
	public static OrderService_IN service = BeanFactory.getBean("orderService",
			OrderService_IN.class);
	public static OrderDetailService_IN dService = BeanFactory.getBean("orderDetailService",
			OrderDetailService_IN.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("orderList".equals(method)) {
			this.list(request, response);
		} else if ("add".equals(method)) {
			this.add(request, response);
		} else if ("delete".equals(method)) {
			this.delete(request, response);
		} else if ("check".equals(method)) {
			this.check(request, response);
		} else if ("detail".equals(method)) {
			this.detail(request, response);
		}
	}

	// 订单详情
	private void detail(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		List<OrderDetail> detailList = this.dService.find(id);
		request.setAttribute("detailList", detailList);// 订单详情
		List<Food> foodList = FoodServlet.service.getAll();
		request.setAttribute("foodList", foodList);// 菜品详情
		Orders order = this.service.findById(id);
		request.setAttribute("order", order);// 订单
		try {
			request.getRequestDispatcher("sys/order/orderDetail.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 显示所有订单
	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<Orders> list = OrderServlet.service.getAll();
		request.setAttribute("orderList", list);// 订单表
		List<FoodTable> tList = TableServlet.service.getAll();
		request.setAttribute("tableList", tList);// 餐桌表
		try {
			request.getRequestDispatcher("sys/order/orderList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 结账
	private void check(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		this.service.check(id);// 改变订单状态
		Orders order = this.service.findById(id);
		FoodTable ft = TableServlet.service.findById(order.getTableId());
		ft.setTableStatus(1);
		ft.setOrderTime(null);
		TableServlet.service.update(ft);// 改变餐桌状态
		this.list(request, response);
	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int orderId = Integer.parseInt(request.getParameter("id"));
		this.dService.deleteOrder(orderId);// 删除订单详情
		this.service.delete(orderId);// 删除订单
		this.list(request, response);

	}

	// 添加订单
	private void add(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * String name = (String) request.getParameter("tableName"); try { Orders order
		 * = WebUtils.copyToBean(request, Orders.class); this.service.add(order); String
		 * path = this.getServletContext().getContextPath(); response.sendRedirect(path
		 * + "/index?method=tableList"); } catch (InvocationTargetException |
		 * IOException e) { throw new RuntimeException(e); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
