package com.test.project.system.evaluation.domain;

import com.test.common.framework.aspectj.lang.annotation.Excel;
import com.test.common.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 处方点评对象 t_evaluation
 * 
 * @author test
 * @date 2023-04-16
 */
public class TEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 处方ID */
    @Excel(name = "处方ID")
    private Long pid;
    
    /** 单号 */
    @Excel(name = "单号")
    private String danhao;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

    private String yishi;
    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 症状 */
    @Excel(name = "症状")
    private String symptom;

    /** 病因 */
    @Excel(name = "病因")
    private String cause;
    
    

    public String getYishi() {
		return yishi;
	}

	public void setYishi(String yishi) {
		this.yishi = yishi;
	}

	public String getDanhao() {
		return danhao;
	}

	public void setDanhao(String danhao) {
		this.danhao = danhao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	/** 评价 */
    @Excel(name = "评价")
    private String evaluate;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Long getPid()
    {
        return pid;
    }
    public void setEvaluate(String evaluate)
    {
        this.evaluate = evaluate;
    }

    public String getEvaluate()
    {
        return evaluate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("evaluate", getEvaluate())
            .toString();
    }
}
