package indi.latch.demo.multidatasource.repo.mysql.mapper;

import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTaskBasicInfo;
import indi.latch.demo.multidatasource.repo.mysql.domain.UjmTaskBasicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UjmTaskBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int countByExample(UjmTaskBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int deleteByExample(UjmTaskBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int insert(UjmTaskBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int insertSelective(UjmTaskBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    List<UjmTaskBasicInfo> selectByExample(UjmTaskBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    UjmTaskBasicInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UjmTaskBasicInfo record, @Param("example") UjmTaskBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UjmTaskBasicInfo record, @Param("example") UjmTaskBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UjmTaskBasicInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujm_task_basic_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UjmTaskBasicInfo record);
}