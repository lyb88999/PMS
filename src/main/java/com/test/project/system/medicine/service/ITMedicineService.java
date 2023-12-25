package com.test.project.system.medicine.service;

import java.util.List;
import com.test.project.system.medicine.domain.TMedicine;

/**
 * 药品信息Service接口
 * 
 * @author test
 * @date 2023-04-16
 */
public interface ITMedicineService 
{
    /**
     * 查询药品信息
     * 
     * @param id 药品信息ID
     * @return 药品信息
     */
    public TMedicine selectTMedicineById(Long id);

    /**
     * 查询药品信息列表
     * 
     * @param tMedicine 药品信息
     * @return 药品信息集合
     */
    public List<TMedicine> selectTMedicineList(TMedicine tMedicine);

    /**
     * 新增药品信息
     * 
     * @param tMedicine 药品信息
     * @return 结果
     */
    public int insertTMedicine(TMedicine tMedicine);

    /**
     * 修改药品信息
     * 
     * @param tMedicine 药品信息
     * @return 结果
     */
    public int updateTMedicine(TMedicine tMedicine);

    /**
     * 批量删除药品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMedicineByIds(String ids);

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息ID
     * @return 结果
     */
    public int deleteTMedicineById(Long id);
}
