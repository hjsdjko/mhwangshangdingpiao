package com.entity.vo;

import com.entity.JipiaoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 机票预订
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jipiao_order")
public class JipiaoOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "jipiao_order_uuid_number")
    private String jipiaoOrderUuidNumber;


    /**
     * 机票
     */

    @TableField(value = "jipiao_id")
    private Integer jipiaoId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "jipiao_order_true_price")
    private Double jipiaoOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "jipiao_order_types")
    private Integer jipiaoOrderTypes;


    /**
     * 预定座位
     */

    @TableField(value = "buy_zuowei_number")
    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "buy_zuowei_time")
    private Date buyZuoweiTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getJipiaoOrderUuidNumber() {
        return jipiaoOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setJipiaoOrderUuidNumber(String jipiaoOrderUuidNumber) {
        this.jipiaoOrderUuidNumber = jipiaoOrderUuidNumber;
    }
    /**
	 * 设置：机票
	 */
    public Integer getJipiaoId() {
        return jipiaoId;
    }


    /**
	 * 获取：机票
	 */

    public void setJipiaoId(Integer jipiaoId) {
        this.jipiaoId = jipiaoId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getJipiaoOrderTruePrice() {
        return jipiaoOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setJipiaoOrderTruePrice(Double jipiaoOrderTruePrice) {
        this.jipiaoOrderTruePrice = jipiaoOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getJipiaoOrderTypes() {
        return jipiaoOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setJipiaoOrderTypes(Integer jipiaoOrderTypes) {
        this.jipiaoOrderTypes = jipiaoOrderTypes;
    }
    /**
	 * 设置：预定座位
	 */
    public String getBuyZuoweiNumber() {
        return buyZuoweiNumber;
    }


    /**
	 * 获取：预定座位
	 */

    public void setBuyZuoweiNumber(String buyZuoweiNumber) {
        this.buyZuoweiNumber = buyZuoweiNumber;
    }
    /**
	 * 设置：订购日期
	 */
    public Date getBuyZuoweiTime() {
        return buyZuoweiTime;
    }


    /**
	 * 获取：订购日期
	 */

    public void setBuyZuoweiTime(Date buyZuoweiTime) {
        this.buyZuoweiTime = buyZuoweiTime;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
