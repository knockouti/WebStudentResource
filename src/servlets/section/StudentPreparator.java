package servlets.section;

import edu.iba.bean.Student;
import edu.iba.dao.DAOException;
import edu.iba.dao.db2impl.StudentDAOImpl;
import edu.iba.dao.interfaces.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Igor on 14.04.2017.
 */


public class StudentPreparator {

    public void configureForm(HttpServletRequest request, String entityIdentifier) {
        if (entityIdentifier == null) {
            request.setAttribute("id", "");
            request.setAttribute("first_name", "");
            request.setAttribute("last_name", "");
            request.setAttribute("group_number", "");
            request.setAttribute("avg_mark", "");
        }
        DAO<Student> dao = new StudentDAOImpl();

        try {
            Student student = dao.get(entityIdentifier);
            request.setAttribute("id", student.getId());
            request.setAttribute("first_name", student.getFirstName());
            request.setAttribute("last_name", student.getLastName());
            request.setAttribute("group_number", student.getGroupNumber());
            request.setAttribute("avg_mark", student.getAvg_mark());
        } catch (DAOException e) {
            request.setAttribute("state", e.getMessage());
            return;
        }
        request.setAttribute("state", "ok");
    }
}
