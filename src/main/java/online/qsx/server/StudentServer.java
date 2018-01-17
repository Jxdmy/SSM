package online.qsx.server;

import com.github.pagehelper.PageInfo;
import online.qsx.model.Student;

import java.util.List;

public interface StudentServer {

    PageInfo<Student> findListByObject(Student student,int pageNum);

    Student findStudentById(Integer studentno);
}
