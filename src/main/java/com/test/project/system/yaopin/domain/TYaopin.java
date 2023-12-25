package com.test.project.system.yaopin.domain;

import com.test.common.framework.aspectj.lang.annotation.Excel;
import com.test.common.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 处方药品对象 t_yaopin
 * 
 * @author test
 * @date 2023-04-16
 */
public class TYaopin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 处方 */
    @Excel(name = "处方")
    private Long pid;

    /** 药品ID */
    @Excel(name = "药品ID")
    private Long yid;

    /** 药品 */
    @Excel(name = "药品")
    private String mingcheng;

    /** 数量 */
    @Excel(name = "数量")
    private String shuliang;

    /** 备注 */
    @Excel(name = "备注")
    private String 备注;

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
    public void setYid(Long yid)
    {
        this.yid = yid;
    }

    public Long getYid()
    {
        return yid;
    }
    public void setMingcheng(String mingcheng)
    {
        this.mingcheng = mingcheng;
    }

    public String getMingcheng()
    {
        return mingcheng;
    }
    public void setShuliang(String shuliang)
    {
        this.shuliang = shuliang;
    }

    public String getShuliang()
    {
        return shuliang;
    }
    public void set备注(String 备注)
    {
        this.备注 = 备注;
    }

    public String get备注()
    {
        return 备注;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("yid", getYid())
            .append("mingcheng", getMingcheng())
            .append("shuliang", getShuliang())
            .append("备注", get备注())
            .toString();
    }
}
