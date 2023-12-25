package com.test.project.system.medicine.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.common.framework.aspectj.lang.enums.BusinessType;
import com.test.project.system.medicine.domain.TMedicine;
import com.test.project.system.medicine.service.ITMedicineService;
import com.test.common.framework.web.controller.BaseController;
import com.test.common.framework.web.domain.AjaxResult;
import com.test.common.utils.poi.ExcelUtil;
import com.test.common.framework.web.page.TableDataInfo;

/**
 * 药品信息Controller
 * 
 * @author test
 * @date 2023-04-16
 */
@Controller
@RequestMapping("/system/medicine")
public class TMedicineController extends BaseController
{
    private String prefix = "system/medicine";

    @Autowired
    private ITMedicineService tMedicineService;

    @GetMapping()
    public String medicine()
    {
        return prefix + "/medicine";
    }

    /**
     * 查询药品信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TMedicine tMedicine)
    {
        startPage();
        List<TMedicine> list = tMedicineService.selectTMedicineList(tMedicine);
        return getDataTable(list);
    }

    /**
     * 导出药品信息列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TMedicine tMedicine)
    {
        List<TMedicine> list = tMedicineService.selectTMedicineList(tMedicine);
        ExcelUtil<TMedicine> util = new ExcelUtil<TMedicine>(TMedicine.class);
        return util.exportExcel(list, "medicine");
    }

    /**
     * 新增药品信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存药品信息
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TMedicine tMedicine)
    {
        return toAjax(tMedicineService.insertTMedicine(tMedicine));
    }

    /**
     * 修改药品信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TMedicine tMedicine = tMedicineService.selectTMedicineById(id);
        mmap.put("tMedicine", tMedicine);
        return prefix + "/edit";
    }

    /**
     * 修改保存药品信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TMedicine tMedicine)
    {
        return toAjax(tMedicineService.updateTMedicine(tMedicine));
    }

    /**
     * 删除药品信息
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tMedicineService.deleteTMedicineByIds(ids));
    }
}
