package online.qsx.server.impl;

import online.qsx.mapper.GradeMapper;
import online.qsx.model.Grade;
import online.qsx.server.GradeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServerImpl implements GradeServer {
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Grade findGradeById(Integer gradeid) {
        return gradeMapper.selectByPrimaryKey(gradeid);
    }
}
