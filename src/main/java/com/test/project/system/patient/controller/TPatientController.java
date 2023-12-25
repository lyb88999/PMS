package com.test.project.system.patient.controller;

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
import com.test.project.system.patient.domain.TPatient;
import com.test.project.system.patient.service.ITPatientService;
import com.test.common.framework.web.controller.BaseController;
import com.test.common.framework.web.domain.AjaxResult;
import com.test.common.utils.poi.ExcelUtil;
import com.test.common.framework.web.page.TableDataInfo;

/**
 * 患者处方Controller
 * 
 * @author test
 * @date 2023-04-16
 */
@Controller
@RequestMapping("/system/patient")
public class TPatientController extends BaseController
{
    private String prefix = "system/patient";

    @Autowired
    private ITPatientService tPatientService;

    @GetMapping()
    public String patient()
    {
        return prefix + "/patient";
    }

    @GetMapping("/dianping")
    public String dianping()
    {
        return prefix + "/dianping";
    }
    @GetMapping("/gongshi")
    public String gongshi()
    {
        return prefix + "/gongshi";
    }
    /**
     * 查询患者处方列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPatient tPatient)
    {
        startPage();
        if(getSysUser().getRoleId() != 1) {
        	tPatient.setCreateBy(getLoginName());
        }
        List<TPatient> list = tPatientService.selectTPatientList(tPatient);
        return getDataTable(list);
    }
    @PostMapping("/dlist")
    @ResponseBody
    public TableDataInfo dlist(TPatient tPatient)
    {
        startPage();
        if(getSysUser().getRoleId() != 1) {
        	tPatient.setPingjia("Y");
        }
        List<TPatient> list = tPatientService.selectTPatientList(tPatient);
        return getDataTable(list);
    }    
    
    @PostMapping("/glist")
    @ResponseBody
    public TableDataInfo glist(TPatient tPatient)
    {
        startPage();
        if(getSysUser().getRoleId() != 1) {
        	tPatient.setGongshi("Y");
        }
        List<TPatient> list = tPatientService.selectTPatientList(tPatient);
        return getDataTable(list);
    }
    /**
     * 导出患者处方列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TPatient tPatient)
    {
        List<TPatient> list = tPatientService.selectTPatientList(tPatient);
        ExcelUtil<TPatient> util = new ExcelUtil<TPatient>(TPatient.class);
        return util.exportExcel(list, "patient");
    }

    /**
     * 新增患者处方
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者处方
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPatient tPatient)
    {
        return toAjax(tPatientService.insertTPatient(tPatient));
    }

    /**
     * 修改患者处方
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TPatient tPatient = tPatientService.selectTPatientById(id);
        mmap.put("tPatient", tPatient);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者处方
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPatient tPatient)
    {
        return toAjax(tPatientService.updateTPatient(tPatient));
    }

    /**
     * 删除患者处方
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tPatientService.deleteTPatientByIds(ids));
    }
}
