package com.Smileyes.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Smileyes.entity.Food;
import com.Smileyes.entity.FoodType;
import com.Smileyes.factory.BeanFactory;
import com.Smileyes.service.FoodTypeService_IN;
import com.Smileyes.utils.WebUtils;

/**
 * 菜系Servlet
 */
public class TypeServlet extends HttpServlet {
	public static FoodTypeService_IN service = BeanFactory.getBean("foodTypeService",
			FoodTypeService_IN.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("typeList".equals(method)) {
			this.list(request, response);
		} else if ("add".equals(method)) {
			// 餐桌管理：显示餐桌列表
			this.addType(request, response);
		} else if ("delete".equals(method)) {
			// 餐桌管理：显示餐桌列表
			this.deleteType(request, response);
		} else if ("update".equals(method)) {
			// 修改前的查找
			this.findById(request, response);
		} else if ("find".equals(method)) {
			// 根据名称查找
			this.findByName(request, response);
		} else if ("doUpdate".equals(method)) {
			this.updateType(request, response);
		}

	}

	// 获取所有
	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<FoodType> list = TypeServlet.service.getAll();
		request.setAttribute("typeList", list);
		try {
			request.getRequestDispatcher("sys/type/typeList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据名称查找
	private void findByName(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("typeName");
		List<FoodType> list = this.service.findByName(name);
		request.setAttribute("typeList", list);
		request.setAttribute("search", name);
		try {
			request.getRequestDispatcher("sys/type/typeList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	private void updateType(HttpServletRequest request, HttpServletResponse response) {
		FoodType type;
		try {
			type = WebUtils.copyToBean(request, FoodType.class);
			this.service.update(type);
			this.list(request, response);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}

	}

	// 修改前的查找
	private void findById(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		FoodType ft = this.service.findById(id);
		request.setAttribute("type", ft);
		try {
			request.getRequestDispatcher("/sys/type/updateType.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void deleteType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Food> foodList = FoodServlet.service.findByTypeId(id);
		if (foodList == null || foodList.isEmpty()) {
			this.service.delete(id);
			this.list(request, response);
		} else {
			FoodType type = service.findById(id);
			request.setAttribute("typeName", type.getTypeName());
			request.getRequestDispatcher("sys/error/typeDelError.jsp").forward(request, response);

		}
	}

	// 添加菜系
	private void addType(HttpServletRequest request, HttpServletResponse response) {
		FoodType ft;
		try {
			ft = WebUtils.copyToBean(request, FoodType.class);
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
