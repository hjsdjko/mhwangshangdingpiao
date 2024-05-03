package com.entity.model;

import com.entity.JipiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 航班信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JipiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 航班标题
     */
    private String jipiaoName;


    /**
     * 航班照片
     */
    private String jipiaoPhoto;


    /**
     * 航班类型
     */
    private Integer jipiaoTypes;


    /**
     * 现价
     */
    private Double jipiaoNewMoney;


    /**
     * 出发地
     */
    private String jipiaoChufadi;


    /**
     * 目的地
     */
    private String jipiaoMudidi;


    /**
     * 出发时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jipiaoTime;


    /**
     * 座位
     */
    private Integer zuoweiNumber;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 航班状态
     */
    private Integer hangbanTypes;


    /**
     * 逻辑删除
     */
    private Integer jipiaoDelete;


    /**
     * 航班详情
     */
    private String jipiaoContent;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
