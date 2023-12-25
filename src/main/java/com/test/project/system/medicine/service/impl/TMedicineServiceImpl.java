package com.test.project.system.medicine.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.project.system.medicine.mapper.TMedicineMapper;
import com.test.project.system.medicine.domain.TMedicine;
import com.test.project.system.medicine.service.ITMedicineService;
import com.test.common.utils.security.ShiroUtils;
import com.test.common.utils.text.Convert;

/**
 * 药品信息Service业务层处理
 * 
 * @author test
 * @date 2023-04-16
 */
@Service
public class TMedicineServiceImpl implements ITMedicineService 
{
    @Autowired
    private TMedicineMapper tMedicineMapper;

    /**
     * 查询药品信息
     * 
     * @param id 药品信息ID
     * @return 药品信息
     */
    @Override
    public TMedicine selectTMedicineById(Long id)
    {
        return tMedicineMapper.selectTMedicineById(id);
    }

    /**
     * 查询药品信息列表
     * 
     * @param tMedicine 药品信息
     * @return 药品信息
     */
    @Override
    public List<TMedicine> selectTMedicineList(TMedicine tMedicine)
    {
        return tMedicineMapper.selectTMedicineList(tMedicine);
    }

    /**
     * 新增药品信息
     * 
     * @param tMedicine 药品信息
     * @return 结果
     */
    @Override
    public int insertTMedicine(TMedicine tMedicine)
    {
        
        
        
        tMedicine.setCreateBy(ShiroUtils.getLoginName());
        
        return tMedicineMapper.insertTMedicine(tMedicine);
    }

    /**
     * 修改药品信息
     * 
     * @param tMedicine 药品信息
     * @return 结果
     */
    @Override
    public int updateTMedicine(TMedicine tMedicine)
    {
        return tMedicineMapper.updateTMedicine(tMedicine);
    }

    /**
     * 删除药品信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMedicineByIds(String ids)
    {
        return tMedicineMapper.deleteTMedicineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除药品信息信息
     * 
     * @param id 药品信息ID
     * @return 结果
     */
    @Override
    public int deleteTMedicineById(Long id)
    {
        return tMedicineMapper.deleteTMedicineById(id);
    }
}
