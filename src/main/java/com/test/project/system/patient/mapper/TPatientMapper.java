package com.test.project.system.patient.mapper;

import java.util.List;
import com.test.project.system.patient.domain.TPatient;

/**
 * 患者处方Mapper接口
 * 
 * @author test
 * @date 2023-04-16
 */
public interface TPatientMapper 
{
    /**
     * 查询患者处方
     * 
     * @param id 患者处方ID
     * @return 患者处方
     */
    public TPatient selectTPatientById(Long id);

    /**
     * 查询患者处方列表
     * 
     * @param tPatient 患者处方
     * @return 患者处方集合
     */
    public List<TPatient> selectTPatientList(TPatient tPatient);

    /**
     * 新增患者处方
     * 
     * @param tPatient 患者处方
     * @return 结果
     */
    public int insertTPatient(TPatient tPatient);

    /**
     * 修改患者处方
     * 
     * @param tPatient 患者处方
     * @return 结果
     */
    public int updateTPatient(TPatient tPatient);

    /**
     * 删除患者处方
     * 
     * @param id 患者处方ID
     * @return 结果
     */
    public int deleteTPatientById(Long id);

    /**
     * 批量删除患者处方
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTPatientByIds(String[] ids);
}
