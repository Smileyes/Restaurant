package com.Smileyes.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Smileyes.entity.Food;
import com.Smileyes.entity.FoodType;
import com.Smileyes.entity.OrderDetail;
import com.Smileyes.factory.BeanFactory;
import com.Smileyes.service.FoodService_IN;
import com.Smileyes.utils.DirUtils;
import com.Smileyes.utils.WebUtils;

/**
 * 菜品服务类
 */
public class FoodServlet extends HttpServlet {
	static String dirPath = DirUtils.getBean("imagesDir");
	public static FoodService_IN service = BeanFactory.getBean("foodService", FoodService_IN.class);
	static {
		System.out.println(dirPath);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("add".equals(method)) {
			// 添加菜品之前
			this.add(request, response);
		} else if ("doAdd".equals(method)) {
			// 添加菜品
			this.doAdd(request, response);
		} else if ("delete".equals(method)) {
			// 菜品管理：删除菜品
			this.delete(request, response);
		} else if ("update".equals(method)) {
			// 修改前的查找
			this.update(request, response);
		} else if ("find".equals(method)) {
			// 根据名称查找
			this.findByName(request, response);
		} else if ("doUpdate".equals(method)) {
			// 修改菜品
			this.doUpdate(request, response);
		} else if ("foodList".equals(method)) {
			// 显示所有
			this.list(request, response);
		}
	}

	// 修改前的准备
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
		List<FoodType> typeList = TypeServlet.service.getAll();
		request.setAttribute("typeList", typeList);
		int id = Integer.parseInt(request.getParameter("id"));
		Food food = this.service.findById(id);
		request.setAttribute("food", food);
		try {
			request.getRequestDispatcher("sys/food/updateFood.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 添加菜品前，获取菜系列表
	private void doAdd(HttpServletRequest request, HttpServletResponse response) {
		List<FoodType> typeList = TypeServlet.service.getAll();
		request.setAttribute("typeList", typeList);
		try {
			request.getRequestDispatcher("/sys/food/saveFood.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 显示所有菜品
	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<Food> foodList = this.service.getAll();
		request.setAttribute("foodList", foodList);// 菜品
		List<FoodType> typeList = TypeServlet.service.getAll();
		request.setAttribute("typeList", typeList);// 菜系
		try {
			request.getRequestDispatcher("sys/food/foodList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 根据名称查找
	private void findByName(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("foodName");
		List<Food> list = this.service.findByName(name);
		request.setAttribute("foodList", list);
		request.setAttribute("search", name);
		List<FoodType> typeList = TypeServlet.service.getAll();
		request.setAttribute("typeList", typeList);// 菜系
		try {
			request.getRequestDispatcher("sys/food/foodList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 修改
	private void update(HttpServletRequest request, HttpServletResponse response) {
		Food food = new Food();
		FileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		if (upload.isMultipartContent(request)) {
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					if (item.isFormField()) {
						// 普通表单项则封装到对象
						WebUtils.copyToBean(item.getFieldName(), item.getString("utf-8"), food);
					} else {
						if (item != null && item.getName() != null
								&& (!"".equals(item.getName()))) {
							// 上传表单项，保存到指定目录，并将相关路径封装到对象
							File file = new File(dirPath, item.getName());
							item.write(file);
							WebUtils.copyToBean(item.getFieldName(), file.getName(), food);
						}
					}
				}
				service.update(food);
				this.list(request, response);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

	// 修改前的查找
	private void findById(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Food food = this.service.findById(id);
		request.setAttribute("food", food);
		try {
			request.getRequestDispatcher("/sys/food/updateFood.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	// 删除菜品
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<OrderDetail> detailList = OrderServlet.dService.findByFoodId(id);
		if (detailList == null || detailList.isEmpty()) {
			this.service.delete(id);
			this.list(request, response);
		} else {
			Food food = service.findById(id);
			request.setAttribute("foodName", food.getFoodName());
			request.getRequestDispatcher("sys/error/foodDelError.jsp").forward(request, response);

		}

	}

	// 添加菜品
	private void add(HttpServletRequest request, HttpServletResponse response) {
		Food food = new Food();
		FileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		if (upload.isMultipartContent(request)) {
			try {
				List<FileItem> list = upload.parseRequest(request);
				for (FileItem item : list) {
					if (item.isFormField()) {
						// 普通表单项则封装到对象
						WebUtils.copyToBean(item.getFieldName(), item.getString("utf-8"), food);
					} else {
						if (item != null && item.getName() != null
								&& (!"".equals(item.getName()))) {
							// 上传表单项，保存到指定目录，并将相关路径封装到对象
							File file = new File(dirPath, item.getName());
							item.write(file);
							WebUtils.copyToBean(item.getFieldName(), file.getName(), food);
						}
					}
				}
				service.add(food);
				this.list(request, response);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
