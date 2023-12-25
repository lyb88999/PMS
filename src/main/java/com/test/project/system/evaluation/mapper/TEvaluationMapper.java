package com.test.project.system.evaluation.mapper;

import java.util.List;
import com.test.project.system.evaluation.domain.TEvaluation;

/**
 * 处方点评Mapper接口
 * 
 * @author test
 * @date 2023-04-16
 */
public interface TEvaluationMapper 
{
    /**
     * 查询处方点评
     * 
     * @param id 处方点评ID
     * @return 处方点评
     */
    public TEvaluation selectTEvaluationById(Long id);

    /**
     * 查询处方点评列表
     * 
     * @param tEvaluation 处方点评
     * @return 处方点评集合
     */
    public List<TEvaluation> selectTEvaluationList(TEvaluation tEvaluation);

    /**
     * 新增处方点评
     * 
     * @param tEvaluation 处方点评
     * @return 结果
     */
    public int insertTEvaluation(TEvaluation tEvaluation);

    /**
     * 修改处方点评
     * 
     * @param tEvaluation 处方点评
     * @return 结果
     */
    public int updateTEvaluation(TEvaluation tEvaluation);

    /**
     * 删除处方点评
     * 
     * @param id 处方点评ID
     * @return 结果
     */
    public int deleteTEvaluationById(Long id);

    /**
     * 批量删除处方点评
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTEvaluationByIds(String[] ids);
}
