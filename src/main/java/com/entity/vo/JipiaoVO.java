package com.entity.vo;

import com.entity.JipiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 航班信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jipiao")
public class JipiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 航班标题
     */

    @TableField(value = "jipiao_name")
    private String jipiaoName;


    /**
     * 航班照片
     */

    @TableField(value = "jipiao_photo")
    private String jipiaoPhoto;


    /**
     * 航班类型
     */

    @TableField(value = "jipiao_types")
    private Integer jipiaoTypes;


    /**
     * 现价
     */

    @TableField(value = "jipiao_new_money")
    private Double jipiaoNewMoney;


    /**
     * 出发地
     */

    @TableField(value = "jipiao_chufadi")
    private String jipiaoChufadi;


    /**
     * 目的地
     */

    @TableField(value = "jipiao_mudidi")
    private String jipiaoMudidi;


    /**
     * 出发时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jipiao_time")
    private Date jipiaoTime;


    /**
     * 座位
     */

    @TableField(value = "zuowei_number")
    private Integer zuoweiNumber;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 航班状态
     */

    @TableField(value = "hangban_types")
    private Integer hangbanTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jipiao_delete")
    private Integer jipiaoDelete;


    /**
     * 航班详情
     */

    @TableField(value = "jipiao_content")
    private String jipiaoContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：航班标题
	 */
    public String getJipiaoName() {
        return jipiaoName;
    }


    /**
	 * 获取：航班标题
	 */

    public void setJipiaoName(String jipiaoName) {
        this.jipiaoName = jipiaoName;
    }
    /**
	 * 设置：航班照片
	 */
    public String getJipiaoPhoto() {
        return jipiaoPhoto;
    }


    /**
	 * 获取：航班照片
	 */

    public void setJipiaoPhoto(String jipiaoPhoto) {
        this.jipiaoPhoto = jipiaoPhoto;
    }
    /**
	 * 设置：航班类型
	 */
    public Integer getJipiaoTypes() {
        return jipiaoTypes;
    }


    /**
	 * 获取：航班类型
	 */

    public void setJipiaoTypes(Integer jipiaoTypes) {
        this.jipiaoTypes = jipiaoTypes;
    }
    /**
	 * 设置：现价
	 */
    public Double getJipiaoNewMoney() {
        return jipiaoNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setJipiaoNewMoney(Double jipiaoNewMoney) {
        this.jipiaoNewMoney = jipiaoNewMoney;
    }
    /**
	 * 设置：出发地
	 */
    public String getJipiaoChufadi() {
        return jipiaoChufadi;
    }


    /**
	 * 获取：出发地
	 */

    public void setJipiaoChufadi(String jipiaoChufadi) {
        this.jipiaoChufadi = jipiaoChufadi;
    }
    /**
	 * 设置：目的地
	 */
    public String getJipiaoMudidi() {
        return jipiaoMudidi;
    }


    /**
	 * 获取：目的地
	 */

    public void setJipiaoMudidi(String jipiaoMudidi) {
        this.jipiaoMudidi = jipiaoMudidi;
    }
    /**
	 * 设置：出发时间
	 */
    public Date getJipiaoTime() {
        return jipiaoTime;
    }


    /**
	 * 获取：出发时间
	 */

    public void setJipiaoTime(Date jipiaoTime) {
        this.jipiaoTime = jipiaoTime;
    }
    /**
	 * 设置：座位
	 */
    public Integer getZuoweiNumber() {
        return zuoweiNumber;
    }


    /**
	 * 获取：座位
	 */

    public void setZuoweiNumber(Integer zuoweiNumber) {
        this.zuoweiNumber = zuoweiNumber;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：航班状态
	 */
    public Integer getHangbanTypes() {
        return hangbanTypes;
    }


    /**
	 * 获取：航班状态
	 */

    public void setHangbanTypes(Integer hangbanTypes) {
        this.hangbanTypes = hangbanTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJipiaoDelete() {
        return jipiaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJipiaoDelete(Integer jipiaoDelete) {
        this.jipiaoDelete = jipiaoDelete;
    }
    /**
	 * 设置：航班详情
	 */
    public String getJipiaoContent() {
        return jipiaoContent;
    }


    /**
	 * 获取：航班详情
	 */

    public void setJipiaoContent(String jipiaoContent) {
        this.jipiaoContent = jipiaoContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
