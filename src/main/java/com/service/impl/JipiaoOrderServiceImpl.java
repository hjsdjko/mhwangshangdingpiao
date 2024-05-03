package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.JipiaoOrderDao;
import com.entity.JipiaoOrderEntity;
import com.service.JipiaoOrderService;
import com.entity.view.JipiaoOrderView;

/**
 * 机票预订 服务实现类
 */
@Service("jipiaoOrderService")
@Transactional
public class JipiaoOrderServiceImpl extends ServiceImpl<JipiaoOrderDao, JipiaoOrderEntity> implements JipiaoOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<JipiaoOrderView> page =new Query<JipiaoOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
