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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Igor on 10.04.2017.
 */

public class SectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private static Map<String,Map<String,Student>> choice = new TreeMap<String,Map<String,Student>>();
    public static List<Student> students = new ArrayList<Student>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO<Student> dao = new StudentDAOImpl();
        try {
            students =  dao.getAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        choice.put("student",getStudentList());
        String choiceParameter = request.getParameter("choice");
        Map<String,Student> map =  choice.get(choiceParameter);
        request.setAttribute("items",map);
        request.setAttribute("studentList", map.values());
        request.setAttribute("itemsKeys",map.keySet());
        request.setAttribute("choice",choiceParameter);
        request.getRequestDispatcher("tablelist.jsp").forward(request,response);
    }
    private static Map<String,Student> getStudentList() {
        TreeMap<String, Student> map = new TreeMap<String, Student>();
        for (Student student:
                students) {
            map.put("/list?type=student&id=" + student.getId(),student);
        }
        return map;
    }

}
