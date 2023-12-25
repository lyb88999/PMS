package com.test.project.system.patient.service.impl;

import java.util.List;
import com.test.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.project.system.patient.mapper.TPatientMapper;
import com.test.project.system.patient.domain.TPatient;
import com.test.project.system.patient.service.ITPatientService;
import com.test.common.utils.security.ShiroUtils;
import com.test.common.utils.text.Convert;

/**
 * 患者处方Service业务层处理
 * 
 * @author test
 * @date 2023-04-16
 */
@Service
public class TPatientServiceImpl implements ITPatientService 
{
    @Autowired
    private TPatientMapper tPatientMapper;

    /**
     * 查询患者处方
     * 
     * @param id 患者处方ID
     * @return 患者处方
     */
    @Override
    public TPatient selectTPatientById(Long id)
    {
        return tPatientMapper.selectTPatientById(id);
    }

    /**
     * 查询患者处方列表
     * 
     * @param tPatient 患者处方
     * @return 患者处方
     */
    @Override
    public List<TPatient> selectTPatientList(TPatient tPatient)
    {
        return tPatientMapper.selectTPatientList(tPatient);
    }

    /**
     * 新增患者处方
     * 
     * @param tPatient 患者处方
     * @return 结果
     */
    @Override
    public int insertTPatient(TPatient tPatient)
    {
        
        
        
        
        
    	tPatient.setDanhao("C"+System.currentTimeMillis());
        
    	tPatient.setPingjia("N");
    	tPatient.setGongshi("N");
        tPatient.setCreateTime(DateUtils.getNowDate());
        
        
        
        tPatient.setCreateBy(ShiroUtils.getLoginName());
        
        return tPatientMapper.insertTPatient(tPatient);
    }

    /**
     * 修改患者处方
     * 
     * @param tPatient 患者处方
     * @return 结果
     */
    @Override
    public int updateTPatient(TPatient tPatient)
    {
        return tPatientMapper.updateTPatient(tPatient);
    }

    /**
     * 删除患者处方对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTPatientByIds(String ids)
    {
        return tPatientMapper.deleteTPatientByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者处方信息
     * 
     * @param id 患者处方ID
     * @return 结果
     */
    @Override
    public int deleteTPatientById(Long id)
    {
        return tPatientMapper.deleteTPatientById(id);
    }
}
