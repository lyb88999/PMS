package com.test.project.system.yaopin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.common.exception.BusinessException;
import com.test.common.framework.aspectj.lang.enums.BusinessType;
import com.test.project.system.medicine.domain.TMedicine;
import com.test.project.system.medicine.service.ITMedicineService;
import com.test.project.system.yaopin.domain.TYaopin;
import com.test.project.system.yaopin.service.ITYaopinService;
import com.test.common.framework.web.controller.BaseController;
import com.test.common.framework.web.domain.AjaxResult;
import com.test.common.utils.poi.ExcelUtil;
import com.test.common.framework.web.page.TableDataInfo;

/**
 * 处方药品Controller
 * 
 * @author test
 * @date 2023-04-16
 */
@Controller
@RequestMapping("/system/yaopin")
public class TYaopinController extends BaseController
{
    private String prefix = "system/yaopin";

    @Autowired
    private ITYaopinService tYaopinService;

    @Autowired
    private ITMedicineService tMedicineService;
    @GetMapping()
    public String yaopin()
    {
        return prefix + "/yaopin";
    }

    /**
     * 查询处方药品列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TYaopin tYaopin)
    {
        startPage();
        List<TYaopin> list = tYaopinService.selectTYaopinList(tYaopin);
        return getDataTable(list);
    }

    /**
     * 导出处方药品列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TYaopin tYaopin)
    {
        List<TYaopin> list = tYaopinService.selectTYaopinList(tYaopin);
        ExcelUtil<TYaopin> util = new ExcelUtil<TYaopin>(TYaopin.class);
        return util.exportExcel(list, "yaopin");
    }

    /**
     * 新增处方药品
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	List<TMedicine> selectTMedicineList = tMedicineService.selectTMedicineList(new TMedicine());
    	mmap.put("list", selectTMedicineList);
        return prefix + "/add";
    }
    @GetMapping("/yao")
    public String yao(ModelMap mmap)
    { 
        return prefix + "/yao";
    }

    /**
     * 新增保存处方药品
     */
    @PostMapping("/add")
    @ResponseBody
    @Transactional
    public AjaxResult addSave(TYaopin tYaopin)
    {
    	TMedicine selectTMedicineById = tMedicineService.selectTMedicineById(tYaopin.getYid());
    	if(selectTMedicineById.getStock() < Long.parseLong( tYaopin.getShuliang())) {
    		throw new BusinessException("药品库存不足，当前剩余："+selectTMedicineById.getStock());
    	}
    	selectTMedicineById.setStock(selectTMedicineById.getStock() - Long.parseLong( tYaopin.getShuliang()));
    	tMedicineService.updateTMedicine(selectTMedicineById);
    	tYaopin.setMingcheng(selectTMedicineById.getName());
        return toAjax(tYaopinService.insertTYaopin(tYaopin));
    }

    /**
     * 修改处方药品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TYaopin tYaopin = tYaopinService.selectTYaopinById(id);
        mmap.put("tYaopin", tYaopin);
        return prefix + "/edit";
    }

    /**
     * 修改保存处方药品
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TYaopin tYaopin)
    {
        return toAjax(tYaopinService.updateTYaopin(tYaopin));
    }

    /**
     * 删除处方药品
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tYaopinService.deleteTYaopinByIds(ids));
    }
}
