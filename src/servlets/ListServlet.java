package servlets;

import edu.iba.bean.Student;
import edu.iba.bean.User;
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
import static edu.iba.dao.db2impl.DB2DAOFactory.getDAO;

/**
 * Created by Igor on 16.04.2017.
 */

public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mess", request.getSession().getAttribute("USER"));
        request.setAttribute("state", request.getParameter("state"));

        String entityType = request.getParameter("type");

        String entityIdentifier = request.getParameter("id");


            create(request);

            if (request.getParameter("UPDATE") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                if (id != 0) {
                    for (Student student : SectionServlet.students) {
                        if (student.getId() == id) {
                            request.setAttribute("currentStudent", student);
                            response.sendRedirect("/list/student.jsp?type=student&update=true");
                        }
                    }
                }
                if (entityType.equals("student")) {
                    update(request);
                }

            }

            response.sendRedirect("/section?choice=" + entityType);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String update(HttpServletRequest request) {
        String entityType = request.getParameter("type");
       if (entityType.equals("student")) {
            return updateStudent(request);
        }
        return "";
    }

    private String delete(HttpServletRequest request) {
        String entityType = request.getParameter("type");

       if (entityType.equals("student")) {
            return deleteStudent(request);
        }
        return "";
    }

    private String create(HttpServletRequest request) {
        String entityType = request.getParameter("type");

       if (entityType.equals("student")) {
            return createStudent(request);
        }
        return "";
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
        return "wrongParams";
    }
}
