package payMent.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import payMent.DAO.oderDAO;
import payMent.bean.roomBean;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/GetRoom")
public class GetRoom extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Connection conn;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Integer listId = Integer.parseInt(request.getParameter("listId"));
        try {
            oderDAO dao = new oderDAO();
            roomBean room = dao.getByRoomId(listId);
            request.setAttribute("room", room);
            request.getRequestDispatcher("/JSP/GetRoom.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
