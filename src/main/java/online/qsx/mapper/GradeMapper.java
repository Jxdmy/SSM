package online.qsx.mapper;

import java.util.List;
import online.qsx.model.Grade;
import online.qsx.model.GradeCriteria;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int countByExample(GradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int deleteByExample(GradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int deleteByPrimaryKey(Integer gradeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int insert(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int insertSelective(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    List<Grade> selectByExample(GradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    Grade selectByPrimaryKey(Integer gradeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int updateByExample(@Param("record") Grade record, @Param("example") GradeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int updateByPrimaryKeySelective(Grade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table grade
     *
     * @mbggenerated Fri Jan 12 14:38:03 CST 2018
     */
    int updateByPrimaryKey(Grade record);
}