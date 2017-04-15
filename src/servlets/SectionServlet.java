package servlets;

import edu.iba.bean.Student;
import edu.iba.dao.DAOException;
import edu.iba.dao.db2impl.StudentDAOImpl;
import edu.iba.dao.interfaces.DAO;
import servlets.section.StudentPreparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Igor on 10.04.2017.
 */

public class SectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String entityType = request.getParameter("type");
        if(entityType.equals("student")){
            new StudentPreparator().configureForm(request,"");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private String create(HttpServletRequest request) {
        String entityType = request.getParameter("type");

        if (entityType.equals("student")) {
            return createStudent(request);
        }

        else return "";


    }
    private String updateStudent(HttpServletRequest request) {
        DAO<Student> dao = new StudentDAOImpl();
        try {
            dao.update(new Student(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("first_name"),
                            request.getParameter("last_name"),
                            Double.parseDouble(request.getParameter("avg_mark")),
                            Integer.parseInt(request.getParameter("group_number"))),
                    request.getParameter("id"));
            return "ok";
        } catch (DAOException e) {
            return "wrongParams";
        }
    }

    private String deleteStudent(HttpServletRequest request) {
        DAO<Student> dao = new StudentDAOImpl();
        try {
            dao.delete(request.getParameter("id"));
            return "ok";
        } catch (DAOException e) {
            return "wrongParams";
        }
    }

    private String createStudent(HttpServletRequest request) {
        DAO<Student> dao = new StudentDAOImpl();
        try {
            dao.create(new Student(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("first_name"),
                    request.getParameter("last_name"),
                    Double.parseDouble(request.getParameter("avg_mark")),
                    Integer.parseInt(request.getParameter("group_number"))));
            return "ok";
        } catch (DAOException e) {
            return "wrongParams";
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return "";
    }
}
