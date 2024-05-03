package com.dao;

import com.entity.JipiaoOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JipiaoOrderView;

/**
 * 机票预订 Dao 接口
 *
 * @author 
 */
public interface JipiaoOrderDao extends BaseMapper<JipiaoOrderEntity> {

   List<JipiaoOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
