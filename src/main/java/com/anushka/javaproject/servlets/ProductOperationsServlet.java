package com.anushka.javaproject.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.anushka.javaproject.dao.CategoryDao;
import com.anushka.javaproject.dao.ProductDao;
import com.anushka.javaproject.entities.Catalog;
import com.anushka.javaproject.entities.Product;
import com.anushka.javaproject.helper.FactoryProvider;

@MultipartConfig
public class ProductOperationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductOperationsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String opType= request.getParameter("operationType");
			System.out.println(opType);
			
			if(opType.trim().equals("addCategory")) {
				
				String catTitle= request.getParameter("catTitle");
				String catDesc= request.getParameter("catDesc");
				
				Catalog cat= new Catalog(catTitle,catDesc);
				
				//adding category to db
				CategoryDao catDao= new CategoryDao(FactoryProvider.getFactory());
				int catId= catDao.addCategory(cat);
				System.out.println(catId);
				
				//giving confirmation
				
				HttpSession httpSession= request.getSession();
				httpSession.setAttribute("message", "Category Added Succesfully !!");
				
				response.sendRedirect("admin.jsp");
				return;
				
			}
			else if(opType.trim().equals("addProduct")) {
				
				String pName= request.getParameter("pName");
				String pDesc= request.getParameter("pDesc");
				Integer pPrice= Integer.parseInt(request.getParameter("pPrice"));
				Integer pDisc= Integer.parseInt(request.getParameter("pDisc"));
				Integer pQuantity= Integer.parseInt(request.getParameter("pQuantity"));
				Integer catId= Integer.parseInt(request.getParameter("catId"));
				Part part= request.getPart("pPhoto");
				
				Product prod= new Product();
				prod.setpName(pName);
				prod.setpDesc(pDesc);
				prod.setpPrice(pPrice);
				prod.setpDisc(pDisc);
				prod.setpQuantity(pQuantity);
				prod.setpPhoto(part.getSubmittedFileName());
				
				CategoryDao cDao= new CategoryDao(FactoryProvider.getFactory());
				Catalog cat= cDao.getCategoryById(catId);
				
				prod.setCatalog(cat);
				
				//adding product to db
				ProductDao productDao= new ProductDao(FactoryProvider.getFactory());
				int pId= productDao.addProduct(prod);
				System.out.println(pId);
				
				//saving product photo
				
				//getting complete path of photo
				String path= request.getRealPath("images") + File.separator + "products" + File.separator + part.getSubmittedFileName();
				System.out.println(path);
				
				//uploading
				try {
					FileOutputStream fos= new FileOutputStream(path);
					InputStream is= part.getInputStream();
					
					//reading data
					byte [] data= new byte[is.available()];  
					is.read(data);
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				//giving confirmation
				
				HttpSession httpSession= request.getSession();
				httpSession.setAttribute("message", "Product Added Succesfull !!");
				
				response.sendRedirect("admin.jsp");
				return;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
