package online.qsx.controller;

import com.alibaba.fastjson.JSONObject;
import online.qsx.model.Grade;
import online.qsx.model.Student;
import online.qsx.server.GradeServer;
import online.qsx.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.java2d.windows.GDIRenderer;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentServer studentServer;

    @Autowired
    private GradeServer gradeServer;

    //http://localhost:80/student/list
    @RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView list(Student student, @RequestParam(defaultValue ="1" ) int pageNum, ModelAndView mav){
        mav.addObject("pageInfo",studentServer.findListByObject(student,pageNum));
        mav.addObject("pageNum",pageNum);
        mav.addObject("student",student);
        mav.setViewName("student/list");
        return  mav;
    }

    @PostMapping(value = "findGrade",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findGrade(Integer studentno){
        Student student=studentServer.findStudentById(studentno);
        Grade grade= gradeServer.findGradeById(student.getGradeid());

        JSONObject json=new JSONObject();
        json.put("gradeid",grade.getGradeid());
        json.put("gradename",grade.getGradename());
        return json.toString();
    }
}
