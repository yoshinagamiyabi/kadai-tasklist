package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public EditServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        // 該当のIDのメッセージ1件のみをデータベースから取得
        Task m = em.find(Task.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // メッセージ情報とセッションIDをリクエストスコープに登録
        request.setAttribute("tasks", m);
        request.setAttribute("_token", request.getSession().getId());

        // メッセージIDをセッションスコープに登録
        request.getSession().setAttribute("tasks_id", m.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Task/edit.jsp");
        rd.forward(request, response);
    }
}