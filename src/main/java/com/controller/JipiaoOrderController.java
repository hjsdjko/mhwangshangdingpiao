
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 机票预订
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jipiaoOrder")
public class JipiaoOrderController {
    private static final Logger logger = LoggerFactory.getLogger(JipiaoOrderController.class);

    private static final String TABLE_NAME = "jipiaoOrder";

    @Autowired
    private JipiaoOrderService jipiaoOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JipiaoService jipiaoService;//航班信息
    @Autowired
    private JipiaoCollectionService jipiaoCollectionService;//航班收藏
    @Autowired
    private NewsService newsService;//民航新闻
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jipiaoOrderService.queryPage(params);

        //字典表数据转换
        List<JipiaoOrderView> list =(List<JipiaoOrderView>)page.getList();
        for(JipiaoOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JipiaoOrderEntity jipiaoOrder = jipiaoOrderService.selectById(id);
        if(jipiaoOrder !=null){
            //entity转view
            JipiaoOrderView view = new JipiaoOrderView();
            BeanUtils.copyProperties( jipiaoOrder , view );//把实体数据重构到view中
            //级联表 航班信息
            //级联表
            JipiaoEntity jipiao = jipiaoService.selectById(jipiaoOrder.getJipiaoId());
            if(jipiao != null){
            BeanUtils.copyProperties( jipiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJipiaoId(jipiao.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jipiaoOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JipiaoOrderEntity jipiaoOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jipiaoOrder:{}",this.getClass().getName(),jipiaoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jipiaoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jipiaoOrder.setCreateTime(new Date());
        jipiaoOrder.setInsertTime(new Date());
        jipiaoOrderService.insert(jipiaoOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JipiaoOrderEntity jipiaoOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jipiaoOrder:{}",this.getClass().getName(),jipiaoOrder.toString());
        JipiaoOrderEntity oldJipiaoOrderEntity = jipiaoOrderService.selectById(jipiaoOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jipiaoOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jipiaoOrderService.updateById(jipiaoOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JipiaoOrderEntity> oldJipiaoOrderList =jipiaoOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jipiaoOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }



    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JipiaoOrderEntity> jipiaoOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JipiaoOrderEntity jipiaoOrderEntity = new JipiaoOrderEntity();
//                            jipiaoOrderEntity.setJipiaoOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            jipiaoOrderEntity.setJipiaoId(Integer.valueOf(data.get(0)));   //机票 要改的
//                            jipiaoOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jipiaoOrderEntity.setJipiaoOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            jipiaoOrderEntity.setJipiaoOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            jipiaoOrderEntity.setBuyZuoweiNumber(data.get(0));                    //预定座位 要改的
//                            jipiaoOrderEntity.setBuyZuoweiTime(sdf.parse(data.get(0)));          //订购日期 要改的
//                            jipiaoOrderEntity.setInsertTime(date);//时间
//                            jipiaoOrderEntity.setCreateTime(date);//时间
                            jipiaoOrderList.add(jipiaoOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("jipiaoOrderUuidNumber")){
                                    List<String> jipiaoOrderUuidNumber = seachFields.get("jipiaoOrderUuidNumber");
                                    jipiaoOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jipiaoOrderUuidNumber = new ArrayList<>();
                                    jipiaoOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jipiaoOrderUuidNumber",jipiaoOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<JipiaoOrderEntity> jipiaoOrderEntities_jipiaoOrderUuidNumber = jipiaoOrderService.selectList(new EntityWrapper<JipiaoOrderEntity>().in("jipiao_order_uuid_number", seachFields.get("jipiaoOrderUuidNumber")));
                        if(jipiaoOrderEntities_jipiaoOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JipiaoOrderEntity s:jipiaoOrderEntities_jipiaoOrderUuidNumber){
                                repeatFields.add(s.getJipiaoOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jipiaoOrderService.insertBatch(jipiaoOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jipiaoOrderService.queryPage(params);

        //字典表数据转换
        List<JipiaoOrderView> list =(List<JipiaoOrderView>)page.getList();
        for(JipiaoOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JipiaoOrderEntity jipiaoOrder = jipiaoOrderService.selectById(id);
            if(jipiaoOrder !=null){


                //entity转view
                JipiaoOrderView view = new JipiaoOrderView();
                BeanUtils.copyProperties( jipiaoOrder , view );//把实体数据重构到view中

                //级联表
                    JipiaoEntity jipiao = jipiaoService.selectById(jipiaoOrder.getJipiaoId());
                if(jipiao != null){
                    BeanUtils.copyProperties( jipiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJipiaoId(jipiao.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jipiaoOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JipiaoOrderEntity jipiaoOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jipiaoOrder:{}",this.getClass().getName(),jipiaoOrder.toString());
            JipiaoEntity jipiaoEntity = jipiaoService.selectById(jipiaoOrder.getJipiaoId());
            if(jipiaoEntity == null){
                return R.error(511,"查不到该航班信息");
            }
            // Double jipiaoNewMoney = jipiaoEntity.getJipiaoNewMoney();

            if(false){
            }
            else if(jipiaoEntity.getJipiaoNewMoney() == null){
                return R.error(511,"现价不能为空");
            }
            List<String> buyZuoweiNumberList = new ArrayList<>(Arrays.asList(jipiaoOrder.getBuyZuoweiNumber().split(",")));//这次购买的座位
            List<String> beforeBuyZuoweiNumberList = new ArrayList<>();//之前已经购买的座位

                    //某天日期的某个分段
            List<JipiaoOrderEntity> jipiaoOrderEntityList =
                        jipiaoOrderService.selectList(new EntityWrapper<JipiaoOrderEntity>()
                        .eq("jipiao_id", jipiaoOrder.getJipiaoId())
                        .eq("buy_zuowei_time", jipiaoOrder.getBuyZuoweiTime())
                        .notIn("jipiao_order_types",102)//已退票的订单

                        );
            for(JipiaoOrderEntity d:jipiaoOrderEntityList){
                beforeBuyZuoweiNumberList.addAll(Arrays.asList(d.getBuyZuoweiNumber().split(",")));
            }
            buyZuoweiNumberList.retainAll(beforeBuyZuoweiNumberList);//判断当前购买list包含已经被购买的list中是否有重复的  有的话 就保留
            if(buyZuoweiNumberList != null && buyZuoweiNumberList.size()>0 ){
                return R.error(511,buyZuoweiNumberList.toString()+" 的座位已经被使用");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - jipiaoEntity.getJipiaoNewMoney()*(jipiaoOrder.getBuyZuoweiNumber().split(",").length);//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            jipiaoOrder.setJipiaoOrderTypes(101); //设置订单状态为已预约
            jipiaoOrder.setJipiaoOrderTruePrice(jipiaoEntity.getJipiaoNewMoney()*(jipiaoOrder.getBuyZuoweiNumber().split(",").length)); //设置实付价格
            jipiaoOrder.setYonghuId(userId); //设置订单支付人id
            jipiaoOrder.setJipiaoOrderUuidNumber(String.valueOf(new Date().getTime()));
            jipiaoOrder.setInsertTime(new Date());
            jipiaoOrder.setCreateTime(new Date());
                jipiaoOrderService.insert(jipiaoOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退票
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JipiaoOrderEntity jipiaoOrder = jipiaoOrderService.selectById(id);//当前表service
            Integer buyNumber = jipiaoOrder.getBuyZuoweiNumber().split(",").length;
            Integer jipiaoId = jipiaoOrder.getJipiaoId();
            if(jipiaoId == null)
                return R.error(511,"查不到该航班信息");
            JipiaoEntity jipiaoEntity = jipiaoService.selectById(jipiaoId);
            if(jipiaoEntity == null)
                return R.error(511,"查不到该航班信息");
            Double jipiaoNewMoney = jipiaoEntity.getJipiaoNewMoney();
            if(jipiaoNewMoney == null)
                return R.error(511,"航班信息价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = jipiaoEntity.getJipiaoNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额




            jipiaoOrder.setJipiaoOrderTypes(102);//设置订单状态为已退票
            jipiaoOrderService.updateAllColumnById(jipiaoOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jipiaoService.updateById(jipiaoEntity);//更新订单中航班信息的信息

            return R.ok();
    }

    /**
     * 待取票
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JipiaoOrderEntity  jipiaoOrderEntity = jipiaoOrderService.selectById(id);
        jipiaoOrderEntity.setJipiaoOrderTypes(103);//设置订单状态为待取票
        jipiaoOrderService.updateById( jipiaoOrderEntity);

        return R.ok();
    }


    /**
     * 取票
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JipiaoOrderEntity  jipiaoOrderEntity = jipiaoOrderService.selectById(id);
        jipiaoOrderEntity.setJipiaoOrderTypes(104);//设置订单状态为取票
        jipiaoOrderService.updateById( jipiaoOrderEntity);
        return R.ok();
    }

}

