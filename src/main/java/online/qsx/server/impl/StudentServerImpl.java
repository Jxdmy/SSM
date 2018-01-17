package online.qsx.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.qsx.mapper.StudentMapper;
import online.qsx.model.Student;
import online.qsx.model.StudentCriteria;
import online.qsx.server.StudentServer;
import online.qsx.utile.PageUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServerImpl implements StudentServer {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageInfo<Student> findListByObject(Student student,int pageNum) {
        //组装条件
        StudentCriteria studentCriteria=new StudentCriteria();
        if(student!=null){
           StudentCriteria.Criteria criteria=studentCriteria.createCriteria();
           if(student.getStudentname()!=null&&student.getStudentname().trim().length()>0){
               criteria.andStudentnameLike("%"+student.getStudentname().trim()+"%");
           }
           if(student.getIdentitycard()!=null&&student.getIdentitycard().trim().length()>0){
               criteria.andIdentitycardLike("%"+student.getIdentitycard()+"%");
           }
        }
        //分页查询
        PageHelper.startPage(pageNum, PageUtile.PAGE_SIZE);
        List<Student> students=studentMapper.selectByExample(studentCriteria);
        return new PageInfo<>(students);
    }

    @Override
    public Student findStudentById(Integer studentno) {
        return studentMapper.selectByPrimaryKey(studentno);
    }
}
