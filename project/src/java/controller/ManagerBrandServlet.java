package controller;

import dao.BrandDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Brand;

public class ManagerBrandServlet extends HttpServlet {

    BrandDAO brandDAO = new BrandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String brand_id = request.getParameter("brand_id");
        String url = "";
        try {
            switch (command) {
                case "delete":
                    brandDAO.delete(Long.parseLong(brand_id));
                    response.sendRedirect("/project/admin/manager_brand.jsp");
                    break;
            }
        } catch (Exception e) {
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String tenThuongHieu = request.getParameter("tenThuongHieu");
        String img = request.getParameter("img");
        String url = "", error = "";
        if (tenThuongHieu.equals("")) {
            error = "Vui lòng nhập tên thương hiệu!";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                        brandDAO.insert(new Brand(20,tenThuongHieu,img));
                        url = "/admin/manager_brand.jsp";
                        break;
                    case "update":
                        brandDAO.update(new Brand(Long.parseLong(request.getParameter("brand_id")),tenThuongHieu,img));
                        url = "/admin/manager_brand.jsp";
                        break;
                }
            } else {
                url = "/admin/insert_brand.jsp";
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
