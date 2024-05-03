package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 航班信息
 *
 * @author 
 * @email
 */
@TableName("jipiao")
public class JipiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JipiaoEntity() {

	}

	public JipiaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 航班标题
     */
    @ColumnInfo(comment="航班标题",type="varchar(200)")
    @TableField(value = "jipiao_name")

    private String jipiaoName;


    /**
     * 航班照片
     */
    @ColumnInfo(comment="航班照片",type="varchar(200)")
    @TableField(value = "jipiao_photo")

    private String jipiaoPhoto;


    /**
     * 航班类型
     */
    @ColumnInfo(comment="航班类型",type="int(11)")
    @TableField(value = "jipiao_types")

    private Integer jipiaoTypes;


    /**
     * 现价
     */
    @ColumnInfo(comment="现价",type="decimal(10,2)")
    @TableField(value = "jipiao_new_money")

    private Double jipiaoNewMoney;


    /**
     * 出发地
     */
    @ColumnInfo(comment="出发地",type="varchar(200)")
    @TableField(value = "jipiao_chufadi")

    private String jipiaoChufadi;


    /**
     * 目的地
     */
    @ColumnInfo(comment="目的地",type="varchar(200)")
    @TableField(value = "jipiao_mudidi")

    private String jipiaoMudidi;


    /**
     * 出发时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出发时间",type="timestamp")
    @TableField(value = "jipiao_time")

    private Date jipiaoTime;


    /**
     * 座位
     */
    @ColumnInfo(comment="座位",type="int(11)")
    @TableField(value = "zuowei_number")

    private Integer zuoweiNumber;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 航班状态
     */
    @ColumnInfo(comment="航班状态",type="int(11)")
    @TableField(value = "hangban_types")

    private Integer hangbanTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jipiao_delete")

    private Integer jipiaoDelete;


    /**
     * 航班详情
     */
    @ColumnInfo(comment="航班详情",type="longtext")
    @TableField(value = "jipiao_content")

    private String jipiaoContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：航班标题
	 */
    public String getJipiaoName() {
        return jipiaoName;
    }
    /**
	 * 设置：航班标题
	 */

    public void setJipiaoName(String jipiaoName) {
        this.jipiaoName = jipiaoName;
    }
    /**
	 * 获取：航班照片
	 */
    public String getJipiaoPhoto() {
        return jipiaoPhoto;
    }
    /**
	 * 设置：航班照片
	 */

    public void setJipiaoPhoto(String jipiaoPhoto) {
        this.jipiaoPhoto = jipiaoPhoto;
    }
    /**
	 * 获取：航班类型
	 */
    public Integer getJipiaoTypes() {
        return jipiaoTypes;
    }
    /**
	 * 设置：航班类型
	 */

    public void setJipiaoTypes(Integer jipiaoTypes) {
        this.jipiaoTypes = jipiaoTypes;
    }
    /**
	 * 获取：现价
	 */
    public Double getJipiaoNewMoney() {
        return jipiaoNewMoney;
    }
    /**
	 * 设置：现价
	 */

    public void setJipiaoNewMoney(Double jipiaoNewMoney) {
        this.jipiaoNewMoney = jipiaoNewMoney;
    }
    /**
	 * 获取：出发地
	 */
    public String getJipiaoChufadi() {
        return jipiaoChufadi;
    }
    /**
	 * 设置：出发地
	 */

    public void setJipiaoChufadi(String jipiaoChufadi) {
        this.jipiaoChufadi = jipiaoChufadi;
    }
    /**
	 * 获取：目的地
	 */
    public String getJipiaoMudidi() {
        return jipiaoMudidi;
    }
    /**
	 * 设置：目的地
	 */

    public void setJipiaoMudidi(String jipiaoMudidi) {
        this.jipiaoMudidi = jipiaoMudidi;
    }
    /**
	 * 获取：出发时间
	 */
    public Date getJipiaoTime() {
        return jipiaoTime;
    }
    /**
	 * 设置：出发时间
	 */

    public void setJipiaoTime(Date jipiaoTime) {
        this.jipiaoTime = jipiaoTime;
    }
    /**
	 * 获取：座位
	 */
    public Integer getZuoweiNumber() {
        return zuoweiNumber;
    }
    /**
	 * 设置：座位
	 */

    public void setZuoweiNumber(Integer zuoweiNumber) {
        this.zuoweiNumber = zuoweiNumber;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：航班状态
	 */
    public Integer getHangbanTypes() {
        return hangbanTypes;
    }
    /**
	 * 设置：航班状态
	 */

    public void setHangbanTypes(Integer hangbanTypes) {
        this.hangbanTypes = hangbanTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJipiaoDelete() {
        return jipiaoDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJipiaoDelete(Integer jipiaoDelete) {
        this.jipiaoDelete = jipiaoDelete;
    }
    /**
	 * 获取：航班详情
	 */
    public String getJipiaoContent() {
        return jipiaoContent;
    }
    /**
	 * 设置：航班详情
	 */

    public void setJipiaoContent(String jipiaoContent) {
        this.jipiaoContent = jipiaoContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jipiao{" +
            ", id=" + id +
            ", jipiaoName=" + jipiaoName +
            ", jipiaoPhoto=" + jipiaoPhoto +
            ", jipiaoTypes=" + jipiaoTypes +
            ", jipiaoNewMoney=" + jipiaoNewMoney +
            ", jipiaoChufadi=" + jipiaoChufadi +
            ", jipiaoMudidi=" + jipiaoMudidi +
            ", jipiaoTime=" + DateUtil.convertString(jipiaoTime,"yyyy-MM-dd") +
            ", zuoweiNumber=" + zuoweiNumber +
            ", shangxiaTypes=" + shangxiaTypes +
            ", hangbanTypes=" + hangbanTypes +
            ", jipiaoDelete=" + jipiaoDelete +
            ", jipiaoContent=" + jipiaoContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
