package com.test.project.system.yaopin.service;

import java.util.List;
import com.test.project.system.yaopin.domain.TYaopin;

/**
 * 处方药品Service接口
 * 
 * @author test
 * @date 2023-04-16
 */
public interface ITYaopinService 
{
    /**
     * 查询处方药品
     * 
     * @param id 处方药品ID
     * @return 处方药品
     */
    public TYaopin selectTYaopinById(Long id);

    /**
     * 查询处方药品列表
     * 
     * @param tYaopin 处方药品
     * @return 处方药品集合
     */
    public List<TYaopin> selectTYaopinList(TYaopin tYaopin);

    /**
     * 新增处方药品
     * 
     * @param tYaopin 处方药品
     * @return 结果
     */
    public int insertTYaopin(TYaopin tYaopin);

    /**
     * 修改处方药品
     * 
     * @param tYaopin 处方药品
     * @return 结果
     */
    public int updateTYaopin(TYaopin tYaopin);

    /**
     * 批量删除处方药品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTYaopinByIds(String ids);

    /**
     * 删除处方药品信息
     * 
     * @param id 处方药品ID
     * @return 结果
     */
    public int deleteTYaopinById(Long id);
}
