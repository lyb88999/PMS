package com.test.project.system.yaopin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.project.system.yaopin.mapper.TYaopinMapper;
import com.test.project.system.yaopin.domain.TYaopin;
import com.test.project.system.yaopin.service.ITYaopinService;
import com.test.common.utils.security.ShiroUtils;
import com.test.common.utils.text.Convert;

/**
 * 处方药品Service业务层处理
 * 
 * @author test
 * @date 2023-04-16
 */
@Service
public class TYaopinServiceImpl implements ITYaopinService 
{
    @Autowired
    private TYaopinMapper tYaopinMapper;

    /**
     * 查询处方药品
     * 
     * @param id 处方药品ID
     * @return 处方药品
     */
    @Override
    public TYaopin selectTYaopinById(Long id)
    {
        return tYaopinMapper.selectTYaopinById(id);
    }

    /**
     * 查询处方药品列表
     * 
     * @param tYaopin 处方药品
     * @return 处方药品
     */
    @Override
    public List<TYaopin> selectTYaopinList(TYaopin tYaopin)
    {
        return tYaopinMapper.selectTYaopinList(tYaopin);
    }

    /**
     * 新增处方药品
     * 
     * @param tYaopin 处方药品
     * @return 结果
     */
    @Override
    public int insertTYaopin(TYaopin tYaopin)
    {
        
        
        
        
        
        
        tYaopin.setCreateBy(ShiroUtils.getLoginName());
        
        return tYaopinMapper.insertTYaopin(tYaopin);
    }

    /**
     * 修改处方药品
     * 
     * @param tYaopin 处方药品
     * @return 结果
     */
    @Override
    public int updateTYaopin(TYaopin tYaopin)
    {
        return tYaopinMapper.updateTYaopin(tYaopin);
    }

    /**
     * 删除处方药品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTYaopinByIds(String ids)
    {
        return tYaopinMapper.deleteTYaopinByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除处方药品信息
     * 
     * @param id 处方药品ID
     * @return 结果
     */
    @Override
    public int deleteTYaopinById(Long id)
    {
        return tYaopinMapper.deleteTYaopinById(id);
    }
}
