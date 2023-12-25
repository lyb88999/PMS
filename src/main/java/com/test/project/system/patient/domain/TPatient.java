package com.test.project.system.patient.domain;

import com.test.common.framework.aspectj.lang.annotation.Excel;
import com.test.common.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 患者处方对象 t_patient
 * 
 * @author test
 * @date 2023-04-16
 */
public class TPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 单号 */
    @Excel(name = "单号")
    private String danhao;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String name;

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
    private String yishi;

    /** 开启评价 */
    @Excel(name = "开启评价")
    private String pingjia;

    /** 处方公示 */
    @Excel(name = "处方公示")
    private String gongshi;

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getYishi() {
		return yishi;
	}

	public void setYishi(String yishi) {
		this.yishi = yishi;
	}

	public Long getId()
    {
        return id;
    }
    public void setDanhao(String danhao)
    {
        this.danhao = danhao;
    }

    public String getDanhao()
    {
        return danhao;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setSymptom(String symptom)
    {
        this.symptom = symptom;
    }

    public String getSymptom()
    {
        return symptom;
    }
    public void setCause(String cause)
    {
        this.cause = cause;
    }

    public String getCause()
    {
        return cause;
    }
    public void setPingjia(String pingjia)
    {
        this.pingjia = pingjia;
    }

    public String getPingjia()
    {
        return pingjia;
    }
    public void setGongshi(String gongshi)
    {
        this.gongshi = gongshi;
    }

    public String getGongshi()
    {
        return gongshi;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("danhao", getDanhao())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("symptom", getSymptom())
            .append("cause", getCause())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("pingjia", getPingjia())
            .append("gongshi", getGongshi())
            .toString();
    }
}
