package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JipiaoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 机票预订
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jipiao_order")
public class JipiaoOrderView extends JipiaoOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String jipiaoOrderValue;

	//级联表 航班信息
		/**
		* 航班标题
		*/

		@ColumnInfo(comment="航班标题",type="varchar(200)")
		private String jipiaoName;
		/**
		* 航班照片
		*/

		@ColumnInfo(comment="航班照片",type="varchar(200)")
		private String jipiaoPhoto;
		/**
		* 航班类型
		*/
		@ColumnInfo(comment="航班类型",type="int(11)")
		private Integer jipiaoTypes;
			/**
			* 航班类型的值
			*/
			@ColumnInfo(comment="航班类型的字典表值",type="varchar(200)")
			private String jipiaoValue;
		/**
		* 现价
		*/
		@ColumnInfo(comment="现价",type="decimal(10,2)")
		private Double jipiaoNewMoney;
		/**
		* 出发地
		*/

		@ColumnInfo(comment="出发地",type="varchar(200)")
		private String jipiaoChufadi;
		/**
		* 目的地
		*/

		@ColumnInfo(comment="目的地",type="varchar(200)")
		private String jipiaoMudidi;
		/**
		* 出发时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="出发时间",type="timestamp")
		private Date jipiaoTime;
		/**
		* 座位
		*/

		@ColumnInfo(comment="座位",type="int(11)")
		private Integer zuoweiNumber;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 航班状态
		*/
		@ColumnInfo(comment="航班状态",type="int(11)")
		private Integer hangbanTypes;
			/**
			* 航班状态的值
			*/
			@ColumnInfo(comment="航班状态的字典表值",type="varchar(200)")
			private String hangbanValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jipiaoDelete;
		/**
		* 航班详情
		*/

		@ColumnInfo(comment="航班详情",type="longtext")
		private String jipiaoContent;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;



	public JipiaoOrderView() {

	}

	public JipiaoOrderView(JipiaoOrderEntity jipiaoOrderEntity) {
		try {
			BeanUtils.copyProperties(this, jipiaoOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getJipiaoOrderValue() {
		return jipiaoOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setJipiaoOrderValue(String jipiaoOrderValue) {
		this.jipiaoOrderValue = jipiaoOrderValue;
	}


	//级联表的get和set 航班信息

		/**
		* 获取： 航班标题
		*/
		public String getJipiaoName() {
			return jipiaoName;
		}
		/**
		* 设置： 航班标题
		*/
		public void setJipiaoName(String jipiaoName) {
			this.jipiaoName = jipiaoName;
		}

		/**
		* 获取： 航班照片
		*/
		public String getJipiaoPhoto() {
			return jipiaoPhoto;
		}
		/**
		* 设置： 航班照片
		*/
		public void setJipiaoPhoto(String jipiaoPhoto) {
			this.jipiaoPhoto = jipiaoPhoto;
		}
		/**
		* 获取： 航班类型
		*/
		public Integer getJipiaoTypes() {
			return jipiaoTypes;
		}
		/**
		* 设置： 航班类型
		*/
		public void setJipiaoTypes(Integer jipiaoTypes) {
			this.jipiaoTypes = jipiaoTypes;
		}


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

		/**
		* 获取： 现价
		*/
		public Double getJipiaoNewMoney() {
			return jipiaoNewMoney;
		}
		/**
		* 设置： 现价
		*/
		public void setJipiaoNewMoney(Double jipiaoNewMoney) {
			this.jipiaoNewMoney = jipiaoNewMoney;
		}

		/**
		* 获取： 出发地
		*/
		public String getJipiaoChufadi() {
			return jipiaoChufadi;
		}
		/**
		* 设置： 出发地
		*/
		public void setJipiaoChufadi(String jipiaoChufadi) {
			this.jipiaoChufadi = jipiaoChufadi;
		}

		/**
		* 获取： 目的地
		*/
		public String getJipiaoMudidi() {
			return jipiaoMudidi;
		}
		/**
		* 设置： 目的地
		*/
		public void setJipiaoMudidi(String jipiaoMudidi) {
			this.jipiaoMudidi = jipiaoMudidi;
		}

		/**
		* 获取： 出发时间
		*/
		public Date getJipiaoTime() {
			return jipiaoTime;
		}
		/**
		* 设置： 出发时间
		*/
		public void setJipiaoTime(Date jipiaoTime) {
			this.jipiaoTime = jipiaoTime;
		}

		/**
		* 获取： 座位
		*/
		public Integer getZuoweiNumber() {
			return zuoweiNumber;
		}
		/**
		* 设置： 座位
		*/
		public void setZuoweiNumber(Integer zuoweiNumber) {
			this.zuoweiNumber = zuoweiNumber;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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
		/**
		* 获取： 航班状态
		*/
		public Integer getHangbanTypes() {
			return hangbanTypes;
		}
		/**
		* 设置： 航班状态
		*/
		public void setHangbanTypes(Integer hangbanTypes) {
			this.hangbanTypes = hangbanTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJipiaoDelete() {
			return jipiaoDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJipiaoDelete(Integer jipiaoDelete) {
			this.jipiaoDelete = jipiaoDelete;
		}

		/**
		* 获取： 航班详情
		*/
		public String getJipiaoContent() {
			return jipiaoContent;
		}
		/**
		* 设置： 航班详情
		*/
		public void setJipiaoContent(String jipiaoContent) {
			this.jipiaoContent = jipiaoContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "JipiaoOrderView{" +
			", jipiaoOrderValue=" + jipiaoOrderValue +
			", jipiaoName=" + jipiaoName +
			", jipiaoPhoto=" + jipiaoPhoto +
			", jipiaoNewMoney=" + jipiaoNewMoney +
			", jipiaoChufadi=" + jipiaoChufadi +
			", jipiaoMudidi=" + jipiaoMudidi +
			", jipiaoTime=" + DateUtil.convertString(jipiaoTime,"yyyy-MM-dd") +
			", zuoweiNumber=" + zuoweiNumber +
			", jipiaoDelete=" + jipiaoDelete +
			", jipiaoContent=" + jipiaoContent +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", newMoney=" + newMoney +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
