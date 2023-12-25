package com.test.project.system.evaluation.service.impl;

import java.util.List;
import com.test.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.project.system.evaluation.mapper.TEvaluationMapper;
import com.test.project.system.evaluation.domain.TEvaluation;
import com.test.project.system.evaluation.service.ITEvaluationService;
import com.test.common.utils.security.ShiroUtils;
import com.test.common.utils.text.Convert;

/**
 * 处方点评Service业务层处理
 * 
 * @author test
 * @date 2023-04-16
 */
@Service
public class TEvaluationServiceImpl implements ITEvaluationService 
{
    @Autowired
    private TEvaluationMapper tEvaluationMapper;

    /**
     * 查询处方点评
     * 
     * @param id 处方点评ID
     * @return 处方点评
     */
    @Override
    public TEvaluation selectTEvaluationById(Long id)
    {
        return tEvaluationMapper.selectTEvaluationById(id);
    }

    /**
     * 查询处方点评列表
     * 
     * @param tEvaluation 处方点评
     * @return 处方点评
     */
    @Override
    public List<TEvaluation> selectTEvaluationList(TEvaluation tEvaluation)
    {
        return tEvaluationMapper.selectTEvaluationList(tEvaluation);
    }

    /**
     * 新增处方点评
     * 
     * @param tEvaluation 处方点评
     * @return 结果
     */
    @Override
    public int insertTEvaluation(TEvaluation tEvaluation)
    {
        
        
        
        tEvaluation.setCreateTime(DateUtils.getNowDate());
        
        
        tEvaluation.setCreateBy(ShiroUtils.getLoginName());
        
        return tEvaluationMapper.insertTEvaluation(tEvaluation);
    }

    /**
     * 修改处方点评
     * 
     * @param tEvaluation 处方点评
     * @return 结果
     */
    @Override
    public int updateTEvaluation(TEvaluation tEvaluation)
    {
        return tEvaluationMapper.updateTEvaluation(tEvaluation);
    }

    /**
     * 删除处方点评对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTEvaluationByIds(String ids)
    {
        return tEvaluationMapper.deleteTEvaluationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除处方点评信息
     * 
     * @param id 处方点评ID
     * @return 结果
     */
    @Override
    public int deleteTEvaluationById(Long id)
    {
        return tEvaluationMapper.deleteTEvaluationById(id);
    }
}
