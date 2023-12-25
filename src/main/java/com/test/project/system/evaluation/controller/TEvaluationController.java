package com.test.project.system.evaluation.controller;

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
import com.test.project.system.evaluation.domain.TEvaluation;
import com.test.project.system.evaluation.service.ITEvaluationService;
import com.test.common.framework.web.controller.BaseController;
import com.test.common.framework.web.domain.AjaxResult;
import com.test.common.utils.poi.ExcelUtil;
import com.test.common.framework.web.page.TableDataInfo;

/**
 * 处方点评Controller
 * 
 * @author test
 * @date 2023-04-16
 */
@Controller
@RequestMapping("/system/evaluation")
public class TEvaluationController extends BaseController
{
    private String prefix = "system/evaluation";

    @Autowired
    private ITEvaluationService tEvaluationService;

    @GetMapping()
    public String evaluation()
    {
        return prefix + "/evaluation";
    }
    @GetMapping("/show")
    public String show()
    {
        return prefix + "/show";
    }
    /**
     * 查询处方点评列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TEvaluation tEvaluation)
    {
        startPage();
        if(getSysUser().getRoleId() == 2L && tEvaluation.getPid() == null) {
        	tEvaluation.setCreateBy(getLoginName());
        }
        List<TEvaluation> list = tEvaluationService.selectTEvaluationList(tEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出处方点评列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TEvaluation tEvaluation)
    {
        List<TEvaluation> list = tEvaluationService.selectTEvaluationList(tEvaluation);
        ExcelUtil<TEvaluation> util = new ExcelUtil<TEvaluation>(TEvaluation.class);
        return util.exportExcel(list, "evaluation");
    }

    /**
     * 新增处方点评
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存处方点评
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TEvaluation tEvaluation)
    {
        return toAjax(tEvaluationService.insertTEvaluation(tEvaluation));
    }

    /**
     * 修改处方点评
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TEvaluation tEvaluation = tEvaluationService.selectTEvaluationById(id);
        mmap.put("tEvaluation", tEvaluation);
        return prefix + "/edit";
    }

    /**
     * 修改保存处方点评
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TEvaluation tEvaluation)
    {
        return toAjax(tEvaluationService.updateTEvaluation(tEvaluation));
    }

    /**
     * 删除处方点评
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tEvaluationService.deleteTEvaluationByIds(ids));
    }
}
