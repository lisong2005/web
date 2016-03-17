package com.mbg.test.dao;

import com.mbg.test.model.ConfigParam;
import com.mbg.test.model.ConfigParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigParamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int countByExample(ConfigParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int deleteByExample(ConfigParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int insert(ConfigParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int insertSelective(ConfigParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    List<ConfigParam> selectByExample(ConfigParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    ConfigParam selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int updateByExampleSelective(@Param("record") ConfigParam record, @Param("example") ConfigParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int updateByExample(@Param("record") ConfigParam record, @Param("example") ConfigParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int updateByPrimaryKeySelective(ConfigParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eh_config_param
     *
     * @mbggenerated Thu Mar 17 10:52:23 CST 2016
     */
    int updateByPrimaryKey(ConfigParam record);
}