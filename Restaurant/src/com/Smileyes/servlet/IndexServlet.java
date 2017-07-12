package com.Smileyes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.Food;
import com.Smileyes.entity.FoodTable;
import com.Smileyes.entity.FoodType;
import com.Smileyes.entity.Orders;

/**
 * 核心Servlet，起始页
 */
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("foodList".equals(method)) {
			this.foodList(request, response);
		} else {
			request.getRequestDispatcher("sys/index.jsp").forward(request, response);
		}
	}

	// 菜品列表
	private void foodList(HttpServletRequest request, HttpServletResponse response) {
		List<Food> list = FoodServlet.service.getAll();
		request.setAttribute("foodList", list);
		try {
			request.getRequestDispatcher("sys/food/foodList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
