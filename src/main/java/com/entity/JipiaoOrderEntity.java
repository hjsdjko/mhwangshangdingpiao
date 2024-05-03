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
 * 机票预订
 *
 * @author 
 * @email
 */
@TableName("jipiao_order")
public class JipiaoOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JipiaoOrderEntity() {

	}

	public JipiaoOrderEntity(T t) {
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
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "jipiao_order_uuid_number")

    private String jipiaoOrderUuidNumber;


    /**
     * 机票
     */
    @ColumnInfo(comment="机票",type="int(11)")
    @TableField(value = "jipiao_id")

    private Integer jipiaoId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "jipiao_order_true_price")

    private Double jipiaoOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "jipiao_order_types")

    private Integer jipiaoOrderTypes;


    /**
     * 预定座位
     */
    @ColumnInfo(comment="预定座位",type="varchar(200)")
    @TableField(value = "buy_zuowei_number")

    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="订购日期",type="date")
    @TableField(value = "buy_zuowei_time")

    private Date buyZuoweiTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：订单号
	 */
    public String getJipiaoOrderUuidNumber() {
        return jipiaoOrderUuidNumber;
    }
    /**
	 * 设置：订单号
	 */

    public void setJipiaoOrderUuidNumber(String jipiaoOrderUuidNumber) {
        this.jipiaoOrderUuidNumber = jipiaoOrderUuidNumber;
    }
    /**
	 * 获取：机票
	 */
    public Integer getJipiaoId() {
        return jipiaoId;
    }
    /**
	 * 设置：机票
	 */

    public void setJipiaoId(Integer jipiaoId) {
        this.jipiaoId = jipiaoId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getJipiaoOrderTruePrice() {
        return jipiaoOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setJipiaoOrderTruePrice(Double jipiaoOrderTruePrice) {
        this.jipiaoOrderTruePrice = jipiaoOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getJipiaoOrderTypes() {
        return jipiaoOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setJipiaoOrderTypes(Integer jipiaoOrderTypes) {
        this.jipiaoOrderTypes = jipiaoOrderTypes;
    }
    /**
	 * 获取：预定座位
	 */
    public String getBuyZuoweiNumber() {
        return buyZuoweiNumber;
    }
    /**
	 * 设置：预定座位
	 */

    public void setBuyZuoweiNumber(String buyZuoweiNumber) {
        this.buyZuoweiNumber = buyZuoweiNumber;
    }
    /**
	 * 获取：订购日期
	 */
    public Date getBuyZuoweiTime() {
        return buyZuoweiTime;
    }
    /**
	 * 设置：订购日期
	 */

    public void setBuyZuoweiTime(Date buyZuoweiTime) {
        this.buyZuoweiTime = buyZuoweiTime;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "JipiaoOrder{" +
            ", id=" + id +
            ", jipiaoOrderUuidNumber=" + jipiaoOrderUuidNumber +
            ", jipiaoId=" + jipiaoId +
            ", yonghuId=" + yonghuId +
            ", jipiaoOrderTruePrice=" + jipiaoOrderTruePrice +
            ", jipiaoOrderTypes=" + jipiaoOrderTypes +
            ", buyZuoweiNumber=" + buyZuoweiNumber +
            ", buyZuoweiTime=" + DateUtil.convertString(buyZuoweiTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
