package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JipiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 航班信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jipiao")
public class JipiaoView extends JipiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 航班类型的值
	*/
	@ColumnInfo(comment="航班类型的字典表值",type="varchar(200)")
	private String jipiaoValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;
	/**
	* 航班状态的值
	*/
	@ColumnInfo(comment="航班状态的字典表值",type="varchar(200)")
	private String hangbanValue;




	public JipiaoView() {

	}

	public JipiaoView(JipiaoEntity jipiaoEntity) {
		try {
			BeanUtils.copyProperties(this, jipiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 航班类型的值
	*/
	public String getJipiaoValue() {
		return jipiaoValue;
	}
	/**
	* 设置： 航班类型的值
	*/
	public void setJipiaoValue(String jipiaoValue) {
		this.jipiaoValue = jipiaoValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}
	//当前表的
	/**
	* 获取： 航班状态的值
	*/
	public String getHangbanValue() {
		return hangbanValue;
	}
	/**
	* 设置： 航班状态的值
	*/
	public void setHangbanValue(String hangbanValue) {
		this.hangbanValue = hangbanValue;
	}




	@Override
	public String toString() {
		return "JipiaoView{" +
			", jipiaoValue=" + jipiaoValue +
			", shangxiaValue=" + shangxiaValue +
			", hangbanValue=" + hangbanValue +
			"} " + super.toString();
	}
}
