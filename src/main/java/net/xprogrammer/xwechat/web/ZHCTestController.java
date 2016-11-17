package net.xprogrammer.xwechat.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import net.xprogrammer.xwechat.dto.ClassifyBean;
import net.xprogrammer.xwechat.dto.ClassifyItemBean;
import net.xprogrammer.xwechat.dto.CommonBean;
import net.xprogrammer.xwechat.dto.DetailsBean;
import net.xprogrammer.xwechat.dto.DishesBean;
import net.xprogrammer.xwechat.dto.EvaluateBean;
import net.xprogrammer.xwechat.dto.EvaluateBean.EvaluateListBean;
import net.xprogrammer.xwechat.dto.FavorableTypeBean;
import net.xprogrammer.xwechat.dto.GrouponBean;
import net.xprogrammer.xwechat.dto.ListBean;
import net.xprogrammer.xwechat.dto.MainPagerShow;
import net.xprogrammer.xwechat.dto.PayTypeBean;
import net.xprogrammer.xwechat.dto.Person;
import net.xprogrammer.xwechat.dto.PersonBean;
import net.xprogrammer.xwechat.dto.PriceTypeBean;
import net.xprogrammer.xwechat.dto.QRCodeBean;
import net.xprogrammer.xwechat.dto.SettleAccountsBean;
import net.xprogrammer.xwechat.dto.SettleAccountsDishesBean;
import net.xprogrammer.xwechat.dto.SettleAccountsDishesItemBean;
import net.xprogrammer.xwechat.dto.TabBean;
import net.xprogrammer.xwechat.dto.UserLoginBean;

@RestController
@RequestMapping("/android/test")
public class ZHCTestController {

	@RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
	public String vipLogin(String username, String password) {
		UserLoginBean bean = new UserLoginBean();
		System.out.println("name="+username+",password="+password);
		if ("zhangsan".equals(username) && "123".equals(password)) {
			bean.setCode(0);
			bean.setId("159625");
			bean.setName("张三他爹");
			bean.setUrl("http://img1.3lian.com/gif/more/11/201209/642ea8b04746a5902152cf88aca069be.jpg");
			bean.setVip(9);
			bean.setVipUrl("http://pic1.ooopic.com/uploadfilepic/weili/2009-10-14/OOOPIC_hanmingyiqqq_20091014a1b07546031d8709.jpg");
			bean.setMsg("登录成功");
		} else {
			bean.setCode(1);
			bean.setMsg("账号或密码错误");
		}
		return JSON.toJSONString(bean);
	}

	@RequestMapping(value = "/person", produces = "text/html;charset=UTF-8")
	public String findPerson() {
		List<Person> list = new ArrayList<Person>();
		Person p = new Person();
		Person p1 = new Person();
		p.setName("王老二");
		p.setAge(18);

		p1.setName("王大力");
		p1.setAge(36);

		list.add(p);
		list.add(p1);
		return JSON.toJSONString(list);
	}

	@RequestMapping(value = "/testMap", produces = "text/html;charset=UTF-8")
	public String testMap(Map<String, String> map) {
		String s = map.get("k1");
		System.out.println(s);
		List<Person> list = new ArrayList<Person>();
		Person p = new Person();
		Person p1 = new Person();
		p.setName("王老二");
		p.setAge(18);

		p1.setName("王大力");
		p1.setAge(36);

		list.add(p);
		list.add(p1);
		// http://localhost:8080/xwechat/images/a.png
		return JSON.toJSONString(list);
	}

	/**
	 * 主页锅底选择，菜品推荐
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/openReady", produces = "text/html;charset=UTF-8")
	public String mainPagerShow(String id, String deviceId) {
		String userId = id;
		String deviceIds = deviceId;
		MainPagerShow bean = new MainPagerShow();
		bean.setStatus(0);
		bean.setTableNumber("2桌002号");
		bean.setDefaultNumber(4);
		bean.setWaitress("隔壁老王");
		bean.setCartStatus(0);
		List<PersonBean> personList = new ArrayList<>();
		PersonBean personBean1 = new PersonBean();
		personBean1.setNumber(2);
		personList.add(personBean1);
		PersonBean personBean2 = new PersonBean();
		personBean2.setNumber(4);
		personList.add(personBean2);
		PersonBean personBean3 = new PersonBean();
		personBean3.setNumber(6);
		personList.add(personBean3);
		bean.setPerson(personList);
		List<DishesBean> potList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			DishesBean dishesbean = new DishesBean();
			dishesbean.setType(0);
			dishesbean.setId(56 * i + "");
			dishesbean.setName("绝味红红锅" + i + "号");
			dishesbean.setPrice((38 + 2 * i));
			dishesbean.setUrl("http://www.canyin375.com/uploads/allimg/150624/3-150624105543B7.jpg");
			dishesbean.setSales(i * 5);
			dishesbean.setCollect(i * 3);
			dishesbean.setStockout(0);
			dishesbean.setNumber(0);
			List<PriceTypeBean> priceList = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				PriceTypeBean mPriceTypeBean = new PriceTypeBean();
				mPriceTypeBean.setType(i);
				mPriceTypeBean.setPrice((28 + i));
				priceList.add(mPriceTypeBean);
			}
			dishesbean.setPriceType(priceList);
			potList.add(dishesbean);
		}

		bean.setPotList(potList);

		List<DishesBean> dishesList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			DishesBean dishesbean = new DishesBean();
			dishesbean.setType(1);
			dishesbean.setId((12 * i + 5) + "");
			dishesbean.setName("藕片" + i + "号");
			dishesbean.setPrice((38 + 2 * i));
			dishesbean.setUrl("http://www.yizhaoxiang.com/upLoad/image/20160105/14519823721135923.jpg");
			dishesbean.setSales(i * 5);
			dishesbean.setCollect(i * 3);
			dishesbean.setStockout(0);
			dishesbean.setNumber(0);
			List<PriceTypeBean> priceList = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				PriceTypeBean mPriceTypeBean = new PriceTypeBean();
				mPriceTypeBean.setType(j);
				mPriceTypeBean.setPrice((28 + j));
				priceList.add(mPriceTypeBean);
			}
			dishesbean.setPriceType(priceList);
			dishesList.add(dishesbean);
		}

		bean.setDishesList(dishesList);

		return JSON.toJSONString(bean);
	}

	/**
	 * 开桌请求
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/cart/open", produces = "text/html;charset=UTF-8")
	public String openTable(String table, int type, String params, int person) {
		System.out.println("开桌：" + params);
		CommonBean bean = new CommonBean();
		bean.setStatus(0);
		bean.setMsg("开桌成功");
		bean.setShowType(0);
		return JSON.toJSONString(bean);
	}

	/**
	 * 选择菜品好了
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/cart/order", produces = "text/html;charset=UTF-8")
	public String chooseGood(String table, int orderType, int type, String params) {
		System.out.println("选择菜品好了：" + params);
		CommonBean bean = new CommonBean();
		bean.setStatus(0);
		bean.setMsg("您选择的菜品已经提交，请耐心等待");
		return JSON.toJSONString(bean);
	}

	private String[] className = { "锅底", "特色凉卤", "牛杂类", "海鲜类", "豆制品", "主食", "叶菜类", "白肉类", "太蕨类", "黑色料理" };

	/**
	 * 分类
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/order/classify", produces = "text/html;charset=UTF-8")
	public String classify(String table, int type) {

		ClassifyBean bean = new ClassifyBean();
		bean.setTable(table);
		bean.setDefaultClassify(1);
		bean.setOrderMoreHint(5);
		bean.setMainTale(0);
		List<TabBean> tabList = new ArrayList<>();
		TabBean tab1 = new TabBean();
		tab1.setId(0);
		tab1.setName("主桌（1大001号）");
		tabList.add(tab1);
		TabBean tab2 = new TabBean();
		tab2.setId(0);
		tab2.setName("辅助（5大001号）");
		tabList.add(tab2);
		bean.setTabList(tabList);
		List<ClassifyItemBean> itemBean = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ClassifyItemBean mClassifyItemBean = new ClassifyItemBean();
			mClassifyItemBean.setId(i);
			mClassifyItemBean.setName(className[i]);
			if (i == 8) {
				mClassifyItemBean.setPermiss(1);
			} else {
				mClassifyItemBean.setPermiss(0);
			}
			mClassifyItemBean.setUrl("order/dishes");
			itemBean.add(mClassifyItemBean);
		}

		bean.setClassifyItemList(itemBean);

		return JSON.toJSONString(bean);
	}

	private String[] dishesUrl = { "http://i2.s2.dpfile.com/pc/fa05814d3461eb73884cb591e48e80ad%28700x700%29/thumb.jpg",
			"http://www.jxweihuang.com/Upload/CN/Images/Product/2015060814400263_y.jpg",
			"http://pic61.nipic.com/file/20150302/9422660_204750122000_2.jpg",
			"http://pic38.nipic.com/20140224/4499633_184422412000_2.jpg",
			"http://d1.lashouimg.com/tmp/2014/03/11/si_139450972666137.jpg",
			"http://p1.zhms.cn/2014-04/201404241037323662.jpg",
			"http://www.cyw51.com/file/upload/201306/20/12-05-39-90-186.jpg",
			"http://s1.lashouimg.com/wg/chengdu/201212/18/lizhuang022.jpg",
			"http://www.wslc.gov.cn/UploadFiles/2013-01/admin/2013010615205595297.jpg",
			"http://postimg1.mop.com/2014/07/15/14054077360485315.jpg" };

	/**
	 * 菜品分类
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/order/dishes", produces = "text/html;charset=UTF-8")
	public String classifyDishes(int id, int type, String table) {
		System.out.println("桌号：" + table + ",请求类型：" + type);
		List<DishesBean> dishesList = new ArrayList<>();
		int number = (int) (1 + Math.random() * (18 - 1 + 1));
		dishesList = initDishes(id, number, className[id], dishesUrl[id]);
		return JSON.toJSONString(dishesList);
	}

	private List<DishesBean> initDishes(int id, int number, String name, String url) {
		List<DishesBean> dishesList = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			DishesBean bean0 = new DishesBean();
			bean0.setType(id);
			bean0.setId(2515 + "");
			bean0.setName(name + i + "号");
			bean0.setPermiss(0);
			bean0.setPrice(89 + i);
			bean0.setUrl(url);
			bean0.setSales(589 * i);
			bean0.setCollect(254 * i);
			bean0.setNumber(0);
			List<PriceTypeBean> priceTypeBeans = new ArrayList<>();
			PriceTypeBean priceTypeBean1 = new PriceTypeBean();
			priceTypeBean1.setType(0);
			priceTypeBean1.setPrice(81 - i);
			priceTypeBeans.add(priceTypeBean1);
			PriceTypeBean priceTypeBean2 = new PriceTypeBean();
			priceTypeBean2.setType(1);
			priceTypeBean2.setPrice(84 - i);
			priceTypeBeans.add(priceTypeBean2);
			bean0.setPriceType(priceTypeBeans);
			dishesList.add(bean0);
		}

		return dishesList;
	}

	/**
	 * 支付清单请求
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/payTheBills/show", produces = "text/html;charset=UTF-8")
	public String settleAccountsShow(String table) {
		SettleAccountsBean bean = new SettleAccountsBean();
		bean.setTable(table);
		bean.setFavorableType(favorableType());
		bean.setPayTypeBeen(payTypeBeans());
		bean.setSettleAccountsDishesBeen(settleAccountsDishesBeans());
		return JSON.toJSONString(bean);
	}

	/**
	 * 优惠类型
	 * 
	 * @return
	 */
	private List<FavorableTypeBean> favorableType() {
		List<FavorableTypeBean> favorableTypeList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			FavorableTypeBean bean = new FavorableTypeBean();
			bean.setId(i);
			if (i == 0) {
				bean.setName("会员卡");
			} else if (i == 1) {
				bean.setName("店内促销");
			} else if (i == 2) {
				bean.setName("团购券");
			}
			favorableTypeList.add(bean);
		}
		return favorableTypeList;
	}

	/**
	 * 支付方式
	 * 
	 * @return
	 */
	private List<PayTypeBean> payTypeBeans() {
		List<PayTypeBean> beans = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			PayTypeBean bean = new PayTypeBean();
			bean.setId(i);
			if (i == 0) {
				bean.setName("现金");
			} else if (i == 1) {
				bean.setName("微信");
			} else if (i == 2) {
				bean.setName("银行卡");
			} else {
				bean.setName("支付宝");
			}
			beans.add(bean);
		}
		return beans;
	}

	/**
	 * 菜品详情
	 * 
	 * @return
	 */
	private List<SettleAccountsDishesBean> settleAccountsDishesBeans() {
		List<SettleAccountsDishesBean> beans = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			SettleAccountsDishesBean bean = new SettleAccountsDishesBean();
			String name = "";
			int total = 0;
			int totalNum = 0;
			bean.setId(i);
			if (i == 0) {
				name = "锅底";
				bean.setName(name);
			} else if (i == 1) {
				name = "特色凉卤";
				bean.setName(name);
			} else if (i == 2) {
				name = "牛杂类";
				bean.setName(name);
			} else if (i == 3) {
				name = "海鲜类";
				bean.setName(name);
			}
			List<SettleAccountsDishesItemBean> itemBeans = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				SettleAccountsDishesItemBean itemBean = new SettleAccountsDishesItemBean();
				itemBean.setId(j + "");
				itemBean.setName(name + j + "号");
				int randNum = (int) (1 + Math.random() * (10 - 1 + 1));
				itemBean.setNumber(randNum);
				totalNum = totalNum + randNum;
				int price = (int) (20 + Math.random() * (10 - 1 + 1));
				itemBean.setPrice(price);
				PriceTypeBean priceTypeBean = new PriceTypeBean();
				priceTypeBean.setType(0);
				priceTypeBean.setPrice(price - 2);
				total = total + (price - 2) * randNum;
				itemBean.setPriceTypeBean(priceTypeBean);
				itemBeans.add(itemBean);
			}
			bean.setTotalNumber(totalNum);
			bean.setTotalPrice(total);
			bean.setItemDishes(itemBeans);
			beans.add(bean);

		}

		return beans;
	}

	/**
	 * 团购券验证
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/payTheBills/groupon", produces = "text/html;charset=UTF-8")
	public String verifyGroup(String table, String group) {
		GrouponBean bean = new GrouponBean();
		bean.setTable(table);
		int status = (int) (0 + Math.random() * (1 - 0 + 1));
		bean.setStatus(status);
		if (status == 0) {
			bean.setMsg("验证成功");
		} else {
			bean.setMsg("验证失败");
		}

		return JSON.toJSONString(bean);
	}

	/**
	 * 支付
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/payTheBills/pay", produces = "text/html;charset=UTF-8")
	public String pay(String table, int favorableType, String userNmae, String coupon, int payType, int giftMoney) {
		QRCodeBean bean = new QRCodeBean();
		bean.setStatus(0);
		bean.setMsg("请完成支付");
		bean.setTable(table);
		bean.setUrl("http://192.168.0.250:8080/xwechat/images/code.png");
		List<ListBean> lists = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			ListBean mListBean = new ListBean();
			mListBean.setId(i);
			if (i == 0) {
				mListBean.setTitle("账单：");
				mListBean.setContext("¥ 3855");
			} else if (i == 1) {
				mListBean.setTitle("优惠：");
				mListBean.setContext("¥ 37");
			} else if (i == 2) {
				mListBean.setTitle("打赏：");
				mListBean.setContext("¥ " + giftMoney);
			} else if (i == 3) {
				mListBean.setTitle("其他1：");
				mListBean.setContext("5555");
			} else if (i == 4) {
				mListBean.setTitle("其他2：");
				mListBean.setContext("2222");
			} else if (i == 5) {
				mListBean.setTitle("其他3：");
				mListBean.setContext("222");
			}

			lists.add(mListBean);
		}
		bean.setListBeanList(lists);
		return JSON.toJSONString(bean);
	}

	/**
	 * 评价请求数据
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/payTheBills/evaluate", produces = "text/html;charset=UTF-8")
	public String getEvaluate(String id) {
		System.out.println("id="+id);
		String[] str = { "上菜快", "服务态度好", "味道超级棒", "环境不错", "就一吃货", "测试数据" };
		EvaluateBean bean = new EvaluateBean();
		List<EvaluateBean.EvaluateListBean> mList = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			EvaluateBean.EvaluateListBean bean2 = new EvaluateListBean();
			bean2.setId(i);
			bean2.setText(str[i]);
			mList.add(bean2);
		}
		bean.setEvaluateListBean(mList);
		return JSON.toJSONString(bean);
	}

	/**
	 * 评价发送数据
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/payTheBills/evaluatePost", produces = "text/html;charset=UTF-8")
	public String postEvaluate(String id,float attitude,float quality,float speed,float other,String hotword,String opinion) {
		CommonBean bean=new CommonBean();
		bean.setStatus(0);
		bean.setMsg("评价成功，感谢你的宝贵意见！");
		return JSON.toJSONString(bean);
	}
	
	/**
	 * 菜品详情
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/order/show/details", produces = "text/html;charset=UTF-8")
	public String details(String id,String name) {
		DetailsBean bean=new DetailsBean();
		List<String> urlList=new ArrayList<>();
		urlList.add("http://192.168.0.250:8080/xwechat/images/1.jpg");
		urlList.add("http://192.168.0.250:8080/xwechat/images/2.jpg");
		urlList.add("http://192.168.0.250:8080/xwechat/images/3.jpg");
		bean.setUrls(urlList);
		List<PriceTypeBean> priceType=new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			PriceTypeBean bean2=new PriceTypeBean();
			bean2.setType(i);
			bean2.setPrice(54);
			bean2.setTitle("标题");
			bean2.setUrl("http://192.168.0.250:8080/xwechat/images/vip.png");
			priceType.add(bean2);
		}
		bean.setPriceType(priceType);
		bean.setTotalEvaluate(150);
		bean.setGoodEvaluate(115);
		
		return JSON.toJSONString(bean);
	}

}
