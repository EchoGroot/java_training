package com.yuyy;

/*import com.ai.ecs.h5.sys.security.Principal;
import com.ai.ecs.webframework.mapper.JsonMapper;
import com.ai.ecs.webframework.util.Collections3;
import com.ai.ecs.webframework.util.CookieUtils;
import com.ai.ecs.webframework.util.DateUtils;
import com.ai.ecsite.util.common.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang3.RandomUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;
import java.util.Map;*/

/**
 * 定义常量和
 * @author wuwh
 *
 */
public class Common {

//	/**
//	 * 静态常量类
//	 * @author tangpeng
//	 *
//	 */
//	public interface RESULTCODE{
//
//		/** 接口返回结果码 0：成功 **/
//		String RESULT_SUCCESS = "0";
//
//		/** 接口返回结果码 -1：失败 **/
//		String RESULT_FAILED = "-1";
//
//		/** 商城商品不存在   1 **/
//		String MALL_SHOPPING_NO = "1";
//	}
//	/**
//	 * 错误代码和信息的定义接口
//	 * @author wuwh
//	 *
//	 */
//	public interface ERROR{
//
//		String SYS_ERROR_CODE="-1";
//		String SYS_ERROR_INFO="系统错误";
//		String LOGIN_ERROR_CODE="-2";
//		String LOGIN_ERROR_INFO="未登陆";
//		//controller 内部异常时
//		String SYS_EXCEPTION_CODE="-9";
//	}
//
//	/**
//	 *
//	 */
//	public interface SYSINFO{
//		String CHAN_ID ="E009";
//		//返回信息中的编码
//		String RESULT_CODE="X_RESULTCODE";
//		//返回信息中的信息
//		String RESULT_INFO="X_RESULTINFO";
//		//成功处理时的返回值
//		String OK_RESULT_CODE="0";
//		//ECOP成功处理时的返回值
//		String OK_ECOP_CODE ="0000";
//		//
//		String BIZ_CODE = "BIZ_CODE";
//
//		String TRANS_CODE = "TRANS_CODE";
//
//		String CONTEXT = "X_CONTEXT";
//		//成功时的返回值
//		String OK_RESULT_INFO="trade ok";
//
//		//短信密码key
//		String DYNAMIC_PASSWORD_KEY = "E004_DYNAMIC_PASSWORD_KEY_";
//
//		//密码登录
//		String LOGIN_PWD_CODE = "0";
//		//短信密码登录
//		String LOGIN_SMSPWD_CODE = "1";
//		//免登陆
//		String LOGIN_AUTO_CODE = "2";
//		//免登陆
//		String SYS_EXCEPTION_INFO = "系统内部异常";
//
//		//cookieTel
//		String COOKIE_TELNUM = "COOKIE_TELNUM";
//
//		//每日短信验证码获取数
//		int DAY_MAX_SMS_LIST_SIZE = 5;
//		//密码错误key
//		String PWD_ERROR_KEY = "E004_DYNAMIC_PASSWORD_ERROR_KEY_";
//		//密码错误超时时间 测试为1小时  生产为24
//		int PWD_ERROR_TIMEOUT = 24*60*60;
//		//每日短信发送30次验证
//		int LOGIN_SMS_NUM=30;
//		int LOGIN_SMS_VALID_TIME=60*60*24;
//		String CATEGORY_TYPE ="10";
//		int SESSION_TIMEOUT = 30*60;
//		int TIMEOUT_DAY_2 =60 * 60 * 24 * 2;
//		int TIMEOUT_HOUR_2 =2*60*60;
//		int TIMEOUT_MIN_1 = 60;
//		int TIMEOUT_MIN_5 = 5*60;
//		int TIMEOUT_MIN_6 = 6*60;
//		int TIMEOUT_MIN_10 = 10*60;
//		int TIMEOUT_SECOND_20 =20;
//		int TIMEOUT_SECOND_90=90;
//		int TIMEOUT_SECOND_120=120;
//		int COUNT_FAIL = -99; //获取数据失败
//		String APP_ENCODE_KEY = "ecmtdl47";//APP端DES加密密钥
//	}
//
//
//	/**
//	 * 创建错误返回值
//	 * @param errorCode
//	 * @param message
//	 * @return
//	 */
//	public static Map<String,Object> createErrorMap(String errorCode, String message){
//		Map<String,Object> info = new HashMap<String,Object>();
//		info.put(SYSINFO.RESULT_CODE, errorCode);
//		info.put(SYSINFO.RESULT_INFO, message);
//		return info;
//
//	}
//	/**
//	 * 创建成功时的返回数据结构
//	 * @return
//	 */
//	public static Map<String,Object> createSucessMap(){
//		Map<String,Object> info = new HashMap<String,Object>();
//		info.put(SYSINFO.RESULT_CODE, SYSINFO.OK_RESULT_CODE);
//		info.put(SYSINFO.RESULT_INFO, SYSINFO.OK_RESULT_INFO);
//		return info;
//	}
//
//
//	/**
//	 * 客户端返回JSON字符串
//	 * @param response
//	 * @param object
//	 * @return
//	 */
//	public static String renderString(ServletResponse response, Object object) {
//		return renderString(response, JsonMapper.toJsonString(object), "application/json");
//	}
//
//	/**
//	 * 客户端返回字符串
//	 * @param response
//	 * @param string
//	 * @return
//	 */
//	public static  String renderString(ServletResponse response, String string, String type) {
//		try {
//			response.reset();
//			response.setContentType(type);
//			response.setCharacterEncoding("utf-8");
//			response.getWriter().print(string);
//			return null;
//		} catch (IOException e) {
//			return null;
//		}
//	}
//
//	/**
//	 *@Author lipp
//	 *@Date 2017/4/17 13:32
//	 * 公共错误处理类
//	 **/
//
//	public static JSONObject getCommonErrorData(){
//		JSONObject data = new JSONObject();
//		data.put("X_RESULTCODE","-1");
//		data.put("X_RESULTINFO", "系统繁忙，请稍后再试！");
//		return data;
//	}
//
//	//将手机号存入cookie
//	public static void setCookieTelNum(HttpServletResponse response){
//		Principal user = UserUtils.getPrincipal();
//		if(user != null){
//			CookieUtils.setCookie(response, SYSINFO.COOKIE_TELNUM,user.getTelNum());
//		}
//	}
//
//	public static JSONObject getResultObject(String code, String info) {
//		JSONObject object = new JSONObject();
//		object.put("RESULT_CODE", code);
//		object.put("RESULT_INFO", info);
//		return object;
//	}
//
//
//	public static long getUsed(Map row){
//		if(null != row && row.containsKey("TOTAL") && row.containsKey("USED")){
//			double total = Double.parseDouble(row.get("TOTAL").toString());
//			double used = Double.parseDouble(row.get("USED").toString());
//
//			return Math.round((used/total)*100);
//		}
//		return 0;
//	}
//
//
//	public static int strChangeInt(String _total){
//		try {
//			return Integer.parseInt(_total);
//		}catch(Exception e) {
//			return 0;
//		}
//	}
//
//	//将秒转换成分钟
//	public static String transstom(String ss) {
//
//		long timeInSeconds=Long.parseLong(ss);
//		long min=timeInSeconds/60;
//
//		return min+"分钟";
//	}
//
//	/**
//	 * 将KB换成*GB*MB
//	 * @param stringB
//	 * @return
//	 * @throws Exception
//	 */
//	public static String transfromKBtoG(String stringB) throws Exception {
//		String str = "";
//		Double intStr = Double.parseDouble(stringB);
//		int gstr = 0;
//		Double mstr = 0.0;
//
//		gstr= (int) (intStr / 1024 / 1024);
//		mstr= (intStr-gstr* 1024L * 1024L)/ 1024;
//		String mstr2="";
//		if(mstr-(int)Math.floor(mstr)>0)
//		{
//			DecimalFormat df = new DecimalFormat("######0.00");
//			mstr2=df.format(mstr);
//		}
//		else
//		{
//			mstr2=(int)Math.floor(mstr)+"";
//		}
//		if("0.0".equals(String.valueOf(mstr)) && gstr>0)
//		{
//			return gstr+"GB";
//		}
//		if(gstr<=0)
//		{
//			str=mstr2+"MB";
//		}
//		else
//		{
//			str=gstr+"GB"+mstr2+"MB";
//		}
//		return str;
//	}
//
//	/**
//	 * 金额处理
//	 *
//	 * @param fee
//	 * @return
//	 */
//	public static String format(String fee) {
//		DecimalFormat df = new DecimalFormat("0.00");
//		return df.format(Double.valueOf(fee) / 100.00);
//	}
//
//	public static String formatStrToStr(String dateStr, String orgPattern, String newPattern) {
//		String resDateStr = "";
//		if(StringUtils.isBlank(dateStr)) {
//			return resDateStr;
//		}
//		SimpleDateFormat orgFormat = new SimpleDateFormat(orgPattern);
//		SimpleDateFormat newFormat = new SimpleDateFormat(newPattern);
//		try {
//			resDateStr =  newFormat.format(orgFormat.parse(dateStr));
//		} catch (ParseException e) {
//			//logger.error("日期[" + dateStr + "]格式化出错.", e);
//		}
//
//		return resDateStr;
//	}
//
//	/**
//	 * 时间字符串格式相互转换
//	 * getDateStr
//	 * @param datastr：如果值为空/为2099年的日期，返回“--”
//	 * @param pattern
//	 * @return
//	 * @throws ParseException
//	 * @return String返回说明
//	 * @Exception 异常说明
//	 * @moduser：
//	 * @moddate：
//	 * @remark：
//	 */
//	public static String getDateStr(String datastr, String pattern) throws ParseException{
//		String resdatestr = "";
//		if ("".equals(datastr)) {
//			resdatestr = "--";
//		} else {
//			String enddatastr=formatDataStr(datastr);
//			SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
//			Date date=sdf1.parse(enddatastr);
//			if("2099".equals(enddatastr.substring(0, 4))) {
//				resdatestr = "--";
//			} else {
//				SimpleDateFormat sdf2=new SimpleDateFormat(pattern);
//				resdatestr=sdf2.format(date);
//			}
//		}
//		return resdatestr ;
//	}
//
//
//	/**
//	 * 日期字符串转yyyyMMddHHmmss
//	 * formatDataStr
//	 * @param datastr
//	 * @return
//	 * @return String返回说明
//	 * @Exception 异常说明
//	 * @moduser：
//	 * @moddate：
//	 * @remark：
//	 */
//	public static String formatDataStr(String datastr){
//		String regEx = "-|:| |/"; //表示a或F
//		Pattern pat = Pattern.compile(regEx);
//		Matcher mat = pat.matcher(datastr);
//		String firstdatastr=mat.replaceAll("");
//		int firstdatalength=firstdatastr.length();
//		String hpstr="";
//		if(firstdatalength<14){
//			for(int i=0;i<14-firstdatalength;i++){
//				hpstr=hpstr+"0";
//			}
//		}
//		return firstdatastr+hpstr;
//	}
//
//
//	/**
//	 * 获取指定月份的第一天
//	 * @param format
//	 * @return
//	 * @throws Exception
//	 */
//	public static String getFirstDayOfMonth(String timeStr,String format) throws Exception{
////		if(StringUtils.isBlank(timeStr))
////			throw new NullArgumentException(timeStr);
////
////		if(StringUtils.isBlank(format)){
////			format="yyyyMMdd";
////		}
////
////		String year = DateUtils.formatDate(DateUtils.parseDate(timeStr), "yyyy");
////		String month = DateUtils.formatDate(DateUtils.parseDate(timeStr), "MM");
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, Integer.parseInt(timeStr.substring(0,4)));
//		cal.set(Calendar.MONTH, Integer.parseInt(timeStr.substring(4,timeStr.length()))-1);
//		cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
//
//		return new   SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());//String.format("%s%s01", year,month);
//	}
//
//	/**
//	 * JSONObject的对象为空
//	 * @param data
//	 * @return
//	 */
//	public static boolean isBlank(JSONObject data) {
//		if (data == null || data.size() == 0) {
//			return true;
//		}
//		return false;
//	}
//	/**
//	 * JSONObject的对象不为空
//	 *
//	 * @param dataset
//	 * @return
//	 */
//	public static boolean isNonBlank(JSONObject dataset) {
//		if (dataset != null && dataset.size() > 0) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * string 为空
//	 *
//	 * @param str
//	 * @return
//	 */
//	public static boolean isBlank(String str) {
//		if (null == str || "".equals(str) || "null".equals(str)) {
//			return true;
//		}
//
//		if (str.trim().length() == 0) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * string 不为空
//	 *
//	 * @param str
//	 * @return
//	 */
//	public static boolean isNonBlank(String str) {
//		return !isBlank(str);
//	}
//
//	/**
//	 * 判断是否为有效数据
//	 * @param str
//	 * @return
//	 */
//	public static boolean isEffect(String str){
//		boolean flag=false;
//		if(Common.isNonBlank(str) && !"undefined".equals(str)&&!"null".equals(str)){
//			flag=true;
//		}
//		return flag;
//	}
//	/**
//	 * 判断是否为有效数据
//	 * @param str
//	 * @return
//	 */
//	public static boolean isNotEffect(String str){
//		return !isEffect(str);
//	}
//	public static String trim(String s){
//		return s == null?null:s.trim();
//	}
//	public interface SORT{
//		String TYPE_STRING ="2";
//		String TYPE_INTEGER ="3";
//		String TYPE_DOUBLE ="4";
//	}
//	/**
//	 * @param jsonArray JSONArray 待排序
//	 * @param key       排序关键字
//	 * @param flag      true 升序  false 降序
//	 */
//	public static void sort(JSONArray jsonArray, final String key,String keyType, boolean flag) {
//		if (Collections3.isEmpty(jsonArray) || StringUtils.isBlank(key)) {
//			return;
//		}
//		if (StringUtils.isBlank(keyType)){
//			keyType =SORT.TYPE_STRING;
//		}
//		// Collections
//		JSONObject[] array = jsonArray.toArray(new JSONObject[jsonArray.size()]);
//		jsonArray.clear();
//		if (SORT.TYPE_STRING.equals(keyType)) {
//			Arrays.sort(array, new Comparator<JSONObject>() {
//				@Override
//				public int compare(JSONObject o1, JSONObject o2) {
//					return o1.getString(key).compareTo(o2.getString(key));
//				}
//			});
//		}else if(SORT.TYPE_INTEGER.equals(keyType)){
//			Arrays.sort(array, new Comparator<JSONObject>() {
//				@Override
//				public int compare(JSONObject o1, JSONObject o2) {
//					return o1.getLongValue(key) == o2.getLongValue(key) ? 0 : (o1.getLongValue(key) < o2.getLongValue(key) ? -1 : 1);
//				}
//			});
//		}else if(SORT.TYPE_DOUBLE.equals(keyType)){
//			Arrays.sort(array, new Comparator<JSONObject>() {
//				@Override
//				public int compare(JSONObject o1, JSONObject o2) {
//					BigDecimal data1 = BigDecimal.valueOf(o1.getDoubleValue(key));
//					BigDecimal data2 = BigDecimal.valueOf(o2.getDoubleValue(key));
//					return data1.compareTo(data2);
//				}
//			});
//		}
//
//		if (flag) {
//			for (int i = 0; i < array.length; i++) {
//				jsonArray.add(array[i]);
//			}
//		} else {
//			for (int i = array.length - 1; i >= 0; i--) {
//				jsonArray.add(array[i]);
//			}
//		}
//	}
//	/**
//	 * @param jsonArray JSONArray 待排序
//	 * @param key       排序关键字,默认String类型排序
//	 * @param flag      true 升序  false 降序
//	 */
//	public static void sort(JSONArray jsonArray, final String key, boolean flag) {
//		if (Collections3.isEmpty(jsonArray) || StringUtils.isBlank(key)) {
//			return;
//		}
//		sort(jsonArray, key,SORT.TYPE_STRING,  flag);
//	}
//
//	/**
//	 *
//	 * @Description: 判断字符串数组是否为空
//	 *
//	 * @param
//	 * @return
//	 * @return：返回结果描述
//	 * @throws：异常描述
//	 *
//	 * Modification History:
//	 *
//	 */
//	public static boolean isBlank(String[] str) {
//		if (str == null || str.length==0)
//			return true;
//
//		return false;
//	}
//
//	/**
//	 *
//	 * @Description: 判断字符串数组非空
//	 *
//	 * @param str
//	 * @return
//	 * @return：返回结果描述
//	 * @throws：异常描述
//	 *
//	 * Modification History:
//	 *
//	 */
//	public static boolean isNonBlank(String[] str) {
//		return !isBlank(str);
//	}
//	/**
//	 * JSONArray对象为空
//	 *
//	 * @param dataset
//	 * @return
//	 */
//	public static boolean isBlank(JSONArray dataset) {
//		return !isNonBlank(dataset);
//	}
//	/**
//	 * 判断JSONArray对象不为空
//	 * @param dataset
//	 * @return
//	 */
//	public static boolean isNonBlank(JSONArray dataset) {
//		if (dataset != null && dataset.size() > 0) {
//			return true;
//		}
//		return false;
//	}
//	/**
//	 * 验证是否为中国移动号码
//	 * isChinaMobileNO
//	 * @param telNum
//	 * @return boolean返回说明
//	 * @Exception 异常说明
//	 * @author：yangxc
//	 * @create：2015-4-21 下午4:16:33
//	 * @remark：
//	 */
//	public static boolean isChinaMobileNO(String telNum){
//		if(isEmpty(telNum))
//			return false;
//		Pattern p = Pattern.compile("^1((3[4-9])||(5[012789])||(4[7])||(8[23478])||78)\\d{8}$");
//		Matcher m = p.matcher(telNum);
//		return m.matches();
//	}
//	/**
//	 * 对象判空
//	 * isEmpty
//	 * @param obj
//	 * @return
//	 * @return boolean返回说明
//	 * @Exception 异常说明
//	 * @author：zhenghw
//	 * @create：May 15, 2014 4:52:45 PM
//	 * @moduser：
//	 * @moddate：
//	 * @remark：
//	 */
//	public static boolean isEmpty(Object obj) {
//		if (null != obj && !"".equals(obj)) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//	/**
//	 * 流量换算(KB换算成**M**KB)
//	 *
//	 * @return
//	 * @throws Exception
//	 */
//	public static String transfromKBtoM(String stringB) throws Exception {
//		String str = "";
//		long intStr = Long.parseLong(stringB);
//		long mstr = -439818635523915776L;
//		long kstr = -439818635523915776L;
//
//		mstr = intStr / 1024L;
//
//		kstr = (intStr - mstr * 1024L);
//		str = mstr + "MB " + kstr + "KB ";
//
//		return str;
//	}
//
//
//	/**
//	 * 判断str，如果是无效的数据，比如null，则设置为默认值
//	 * @param str
//	 * @param defaultStr
//	 * @return
//	 * @throws Exception
//	 */
//	public  static  String convertDefault(String str,String defaultStr)throws Exception {
//		if(isEffect(str)){
//			return str;
//		}else {
//			return  defaultStr;
//		}
//	}
//	public  static  int convertDefault(String str,int defaultStr)throws Exception {
//		if(isEffect(str)){
//			return Integer.parseInt(str);
//		}else {
//			return  defaultStr;
//		}
//	}
//	/**
//	 * 判断str，如果是无效的数据，比如null，则设置为默认值
//	 * @param str
//	 * @param defaultStr
//	 * @return
//	 * @throws Exception
//	 */
//	public  static  boolean convertDefault(Boolean str,boolean defaultStr)throws Exception {
//		if(str!=null){
//			return str;
//		}else {
//			return  defaultStr;
//		}
//	}
//	public  static final JSONArray filterBroad = new JSONArray();
//	static {
//		filterBroad.add("gl_sjkd_cnxfwl300y100m");
//		filterBroad.add("gl_cn4gsj_58y20m");
//		filterBroad.add("gl_cn4gsj_58y60m");
//		filterBroad.add("gl_cn4gsj_58y60m24y");
//		filterBroad.add("gl_cn4gsj_88y60m");
//		filterBroad.add("gl_cn4gsj_88y100m2");
//		filterBroad.add("gl_cn4gsj_88y100m24y");
//		filterBroad.add("gl_cn4gsj_138y100m");
//		filterBroad.add("gl_cn4gsj_138y100m2");
//		filterBroad.add("gl_cn4gsj_158y100m2");
//		filterBroad.add("gl_sjkd_cn4g20173");
//		filterBroad.add("gl_sjkd_cn4g20178");
//	}
//	/**
//	 * cq换ncode
//	 * @param code
//	 * @return
//	 */
//	public static  String changeNcode(String code) {
//		String CODE1[]={"gl_sjkd_cnxfwl68y20m","gl_sjkd_cnxfwl98y60m","gl_sjkd_cnxfwl148y100m"};
//		String CODE2[]={"gl_cqkd_cnxfwl68y20m","gl_cqkd_cnxfwl98y60m","gl_cqkd_cnxfwl148y100m"};
//		for (int i = 0; i < CODE1.length; i++) {
//			if (CODE1[i].equalsIgnoreCase(code)) {
//				return CODE2[i];
//			}
//		}
//		return code;
//	}
//	public interface BroadbandInfo {
//		String KEY_USERS_COUNT = "APP_BROADGROUPDAY_GROUP_COUNT";
//		String KEY_USER_LOCK = "APP_BROADGROUPDAY_USER_";
//		String KEY_GROUPUSER_LOCK = "APP_BROADGROUPUSERDAY_USER_";
//		String KEY_ONU = "APP_BROADGONU_";
//		String KEY_NET_OBS = "NET_OBSTACLE_";
//		String KEY_BROAD_OBS = "BROAD_OBSTACLE_";
//	}
//
//
//	/**
//	 * 日期处理：获取当月月份/当月第一天
//	 * getDateOfCurMonth
//	 * @param format:yyyy-MM/yyyy-MM-dd/yyyy-MM-dd HH:mm:ss等格式串
//	 * @return
//	 * @return String返回说明
//	 * @Exception 异常说明
//	 * @author：zhenghw
//	 * @create：May 17, 2014 10:43:51 AM
//	 * @moduser：
//	 * @moddate：
//	 * @remark：
//	 */
//	public static String getDateOfCurMonth(String format) {
//		Calendar calendar = new GregorianCalendar();
//		calendar.set(Calendar.DATE, 1);
//		SimpleDateFormat simpleFormate = new SimpleDateFormat(format);
//		return simpleFormate.format(calendar.getTime());
//	}
//
//	//获取当前月的前面月份
//	public static String getPreMonth(int i,String dataf) {
//		SimpleDateFormat df = new SimpleDateFormat(dataf); // 制定日期格式
//		Calendar c = Calendar.getInstance();
//		Date date = new Date();
//		c.setTime(date);
//		c.add(Calendar.MONTH, -i); // 将当前日期减i个月
//		String validityDate = df.format(c.getTime());
//		return validityDate;
//	}
//
//
//	/**
//	 * 获取指定月份的最后一天
//	 * @param format
//	 * @return
//	 * @throws Exception
//	 */
//	public static String getLastDayOfMonth(String timeStr,String format) throws Exception{
////		if(StringUtils.isBlank(format)){
////			format="yyyyMMdd";
////		}
////
////		String year = DateUtils.formatDate(DateUtils.parseDate(timeStr), "yyyy");
////		String month = DateUtils.formatDate(DateUtils.parseDate(timeStr), "MM");
////
////		Calendar c = Calendar.getInstance();
////		c.set(Calendar.YEAR, Integer.valueOf(year));
////		c.set(Calendar.MONTH, Integer.valueOf(month));
////		c.set(Calendar.DAY_OF_MONTH, 1);
////		c.add(Calendar.DAY_OF_MONTH, -1);
////
////		SimpleDateFormat f = new SimpleDateFormat(format);
//		if(StringUtils.isBlank(format)){
//			format="yyyyMMdd";
//		}
//		int day = -1;
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR,Integer.parseInt(timeStr.substring(0,4)));
//		cal.set(Calendar.MONTH,Integer.parseInt(timeStr.substring(4,6))-1);
//		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
////		int last = cal.getActualMaximum(Calendar.DATE);
//		SimpleDateFormat f = new SimpleDateFormat(format);
//		String dat= f.format(cal.getTime());
//		//String dat = new   SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());//DateUtils.getDate("yyyyMM")+last;
//
//		return dat;//f.format(c.getTime());
//	}
//
//	/**
//	 * 获取月份
//	 * @param number 需要几个月
//	 * @return
//	 */
//	public static List getMonths(int number){
//		String billCycle = DateUtils.getDate("yyyyMM");//查询月份
//		List months = new ArrayList();
//		for(int i=1;i<=number;i++){
//			Calendar calendar = Calendar.getInstance();
//			calendar.add(Calendar.MONTH, -i);
//			billCycle = DateUtils.formatDate(calendar.getTime(), "yyyyMM");
//			months.add(billCycle);
//		}
//		return months;
//	}
//
//	/**
//	 * 秒数换算(s换算成**h**m**s)
//	 *
//	 *
//	 * @param
//	 * @param
//	 * @return
//	 * @throws Exception
//	 */
//	public static String calcHMS(String ss) {
//		long timeInSeconds = Long.parseLong(ss);
//		long hours, minutes, seconds;
//		hours = timeInSeconds / 3600;
//		timeInSeconds = timeInSeconds - (hours * 3600);
//		minutes = timeInSeconds / 60;
//		timeInSeconds = timeInSeconds - (minutes * 60);
//		seconds = timeInSeconds;
//		return hours + "小时" + minutes + "分" + seconds + "秒";
//	}
//	public static double getM(double k){ // 该参数表示kb的值
//		double m;
//		m =(k / 1024.0);
//		return m; //返回kb转换之后的M值
//	}
//	/**
//	 * 流量换算(B换算成**M**KB)
//	 *
//	 * @param
//	 * @param
//	 * @return
//	 * @throws Exception
//	 */
//	public static String transfromBtoM(String stringB) throws Exception {
//		String str = "";
//		long intStr = Long.parseLong(stringB);
//		long mstr = -439818635523915776L;
//		long kstr = -439818635523915776L;
//		long bstr = -439818635523915776L;
//
//		mstr = intStr / 1024L / 1024L;
//
//		kstr = (intStr - mstr * 1024L * 1024L) / 1024L;
//
//		bstr = intStr - mstr * 1024L * 1024L - kstr * 1024L;
//
//		str = mstr + "MB " + kstr + "KB " + bstr + "bit";
//
//		return str;
//	}
//
//	/**
//	 * 金额处理
//	 *
//	 * @param fee
//	 * @return
//	 */
//	public static String feeFormat(String fee) {
//		DecimalFormat df = new DecimalFormat("0.00");
//		return df.format(Double.valueOf(fee) / 100.00);
//	}
//	/**
//	 * 生成指定长度的随机数
//	 *
//	 * @param length
//	 * @return
//	 */
//	public static String random(int length) {
//		String all = "0123456789";
//		char[] result = new char[length];
//		for (int i = 0; i < length; i++) {
//			result[i] = all.charAt((int) (Math.random() * all.length()));
//		}
//		return String.valueOf(result);
//	}
////	/**
////     * 生成数字随机码
////     * createRandomCode
////     * @param length：随机码位数
////     * @return
////     * @return String返回说明
////     * @Exception 异常说明
////     * @author：zhenghw
////     * @create：May 15, 2014 5:25:24 PM
////     * @moduser：
////     * @moddate：
////     * @remark：
////     */
////    public static String createRandomCode(int length) {
////        Random random = new Random();
////        String result = String.valueOf(Math.abs(random.nextLong()));// 绝对值
////
////        if (result.length() >= length) {
////            return result.substring(0, length);
////        } else {
////            return result + createRandomCode(length - result.length());
////        }
////    }
//  /**
//   * 服务密码的加密
//   * @param str
//   * @return
//   */
//  public static String StrToBin(String str) {
//    String result = "";
//    for (int i = 0; i < str.length(); i++) {
//      result = result + StrToBinstr(str.substring(i, i + 1));
//    }
//    result =
//        result.substring(result.length() - 1, result.length())
//            + result.substring(0, result.length() - 1);// 把最后一位移到最前面去
//    return result;
//  }
//
//  /**
//   * 服务密码加密2012-8-2
//   *
//   * @param str
//   * @return
//   */
//  public static String StrToBinstr(String str) {
//    char[] strChar = str.toCharArray();
//    String result = "";
//    for (int i = 0; i < strChar.length; i++) {
//      result += Integer.toBinaryString(strChar[i]) + "";
//    }
//    if (result.length() < 8) {
//      String temp = "";
//      for (int i = 0; i < 8 - result.length(); i++) {
//        temp = temp + "0";
//      }
//      result = temp + result;
//    }
//    return result;
//  }
//  /**
//   * 密码有效性验证 modify time:090227
//   *
//   * @param pwd
//   * @param serialNumber
//   * @return
//   * @add by cai.hy , at Jun 28, 2007
//   */
//  public static JSONObject validatePwd(String pwd, String serialNumber) throws Exception {
//    JSONObject data = new JSONObject();
//      while (true) {
//          if (pwd != null && !"".equals(pwd.trim())) {
//              if (Pattern.matches("^\\d{6}$", pwd)) {
//                  if (Pattern.matches("^\\d*" + pwd + "\\d*$", "01234567890")) {
//                      data.put("X_RESULTCODE", "-1");
//                      // data.put("X_RESULTINFO", "密码过于简单,密码为序列!");
//                      data.put("X_RESULTINFO", "尊敬的客户您的密码过于简单,密码不可以为01234567890的一个序列!");
//                      break;
//                  } else if (Pattern.matches("^\\d*" + pwd + "\\d*$", serialNumber)) {
//
//                      data.put("X_RESULTCODE", "-2");
//                      // data.put("X_RESULTINFO", "密码过于简单,密码是手机号码的一个序列!");
//                      data.put("X_RESULTINFO", "尊敬的客户您的密码过于简单,密码不可以为手机号码的一个序列!");
//                      break;
//                  } else if (Pattern.matches("^\\d*(0{3}|1{3}|2{3}|3{3}|4{3}|5{3}|6{3}|7{3}|8{3}|9{3})\\d*$", pwd)) {
//
//                      data.put("X_RESULTCODE", "-3");
//                      // 弱密码,重量数字位超过3位!
//                      data.put("X_RESULTINFO", "尊敬的客户您的密码过于简单,密码的重复数字不可以超过3位!");
//                      break;
//                  } else {
//
//                      data.put("X_RESULTCODE", "0");
//                      data.put("X_RESULTINFO", "强密码!");
//                      break;
//                  }
//              } else {
//                  data.put("X_RESULTCODE", "-4");
//                  data.put("X_RESULTINFO", "尊敬的客户,密码必须是6位的数字!");
//                  break;
//              }
//          } else {
//
//              data.put("X_RESULTCODE", "-5");
//              data.put("X_RESULTINFO", "尊敬的客户,密码不能为空!");
//              break;
//          }
//      }
//
//      return data;
//  }
//  /**
//   * 获取时间
//   * @param date
//   * @return
//   */
//  public static String getdayStr(String date) {
//      String return_str=date;
//      try{
//          String y_str = date.substring(0, 4);
//          String m_str= date.substring(4, 6);
//          String d_str = date.substring(date.length()-2);
//          return_str=y_str+"年"+m_str+"月"+d_str+"日";
//      }catch(Exception ex){
//          //log.error(ex);
//      }
//      return return_str;
//  }
//	public static String getProperty(String file, String prop){
//		String result = null;
//		try {
//			XMLConfig config = new XMLConfig(file);
//			result = config.getProperty(prop);
//		} catch (Exception e) {
//		}
//		return result;
//	}
//	/**
//	 * 根据关键词filter，筛选dataset对应的子序列
//	 * @param dataset
//	 * @param filter
//	 * @return
//	 * @throws Exception
//	 */
//	public static JSONArray filter(JSONArray dataset,String filter)
//			throws Exception
//	{
//		if ((filter == null) || ("".equals(filter))) return dataset;
//
//		JSONObject ftdt = new JSONObject();
//		String[] fts = filter.split(",");
//		String[] ftdtNames = new String[fts.length];
//		for (int i = 0; i < fts.length; i++) {
//			String[] ft = fts[i].split("=");
//			ftdt.put(ft[0], ft[1]);
//			ftdtNames[i]=ft[0];
//		}
//
//		JSONArray subset = new JSONArray();
//		for (int i = 0; i < dataset.size(); i++) {
//			JSONObject subdata = dataset.getJSONObject(i);
//			boolean include = true;
//			for (int j = 0; j < ftdtNames.length; j++) {
//				String subvalue = (String)subdata.get(ftdtNames[j]);
//				if ((subvalue == null) || (!subvalue.equals(ftdt.get(ftdtNames[j])))) {
//					include = false;
//					break;
//				}
//			}
//			if (!include) continue; subset.add(subdata);
//		}
//
//		return subset;
//	}
//	/**
//	 * 得到随机验证码
//	 *
//	 * @return 六位数的在随机数
//	 */
//	public static String randomSms() {
//		return String.valueOf(RandomUtils.nextLong(100000, 999999));
//	}
//
//	/**
//	 * 根据键名去重
//	 * @param list
//	 * @param fieldNames
//	 * @param token
//	 * @return
//	 * @throws Exception
//	 */
//	public static JSONArray distinct(JSONArray list,String fieldNames, String token)
//			throws Exception
//	{
//		if ("".equals(fieldNames)) return list;
//
//		List fieldValues = new ArrayList();
//		JSONArray subset = new JSONArray();
//		String theToken = (token == null) || ("".equals(token)) ? "," : token;
//
//		String[] keys = fieldNames.split(theToken);
//		for (int i = 0; i < list.size(); i++) {
//			String fieldValue = "";
//			for (int j = 0; j < keys.length; j++) {
//				fieldValue = fieldValue + (String)get(list,i, keys[j]) + theToken;
//			}
//			if (("".equals(fieldValue)) ||
//					(fieldValues.contains(fieldValue))) continue;
//			fieldValues.add(fieldValue);
//			subset.add(list.get(i));
//		}
//
//		return subset;
//	}
//
//	public static JSONArray distinct(JSONArray list,String fieldNames)
//			throws Exception
//	{
//		return distinct(list,fieldNames, ",");
//	}
//	public static Object get(JSONArray list,int index, String name)
//	{
//		JSONObject data = list.getJSONObject(index);
//		return data == null ? null : data.get(name);
//	}
//	public interface UserType{
//		//普通用户:通过http://wap.cq.10086.cn登录访问系统
//        int NORMAL_USER=0;
//        //导购员:通过http://wap.cq.10086.cn/dg登录访问系统
//        int  SHOPPING_GUIDE = 1;
//        //营业员:通过http://wap.cq.10086.cn/yyt登录访问系统
//        int CLERK = 2;
//        /**
//         * 直销员推荐用户：由直销员通过CqmcClient.apk登录后
//         * 推荐的用户，该数据用于营销酬金统计
//         */
//        int SELLER_RECOMMENDED_USER=3;
//        /**
//         * 直销员：通过CqmcClient.apk登录后
//         * 经过校验是直销员的用户
//         */
//        int SELLER_APP=4;
//
//        int DongGan_APP=5;//动感app用户
//	}
//
//	/**
//	 * 流量赠送
//	 *
//	 * @param serialNumber
//	 * @param product_type
//	 * @param channel_id
//	 * @param channel_pwd
//	 * @param chan_id
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public static JSONObject addflow(String serialNumber, String product_type, String channel_id, String channel_pwd, String chan_id) {
//		try{
//			//String severAddr = "http://10.189.220.53:8080/pubsrv/ecui/addproduct.do"; // 测试环境地址，订购产品(用于赠送)
//			String severAddr = "http://10.191.16.13:9000/web/ecui/addproduct.do"; // 正式环境地址
//			URL urlObj = new URL(severAddr);
//			HttpURLConnection conn = (HttpURLConnection)urlObj.openConnection();
//			conn.setRequestMethod("POST");
//			conn.setDoOutput(true);// 是否输入参数
//			StringBuffer params = new StringBuffer();
//			String msg_id = chan_id + String.valueOf(System.currentTimeMillis());
//			String msg = "<?xml version='1.0' encoding='UTF-8' ?>"
//					+"<DATA>"
//					+	"<HEAD>"
//					+		"<CHANNEL_ID>%CHANNEL_ID%</CHANNEL_ID>"
//					+		"<CHANNEL_PWD>%CHANNEL_PWD%</CHANNEL_PWD>"
//					+		"<MSG_ID>%MSG_ID%</MSG_ID>"
//					+	"</HEAD>"
//					+	"<BODY>"
//					+		"<BIND_USER_ID>TELNUM</BIND_USER_ID>"
//					+		"<MSISDN>TELNUM</MSISDN>"
//					+		"<PRODUCT_TYPE>%PRODUCT_TYPE%</PRODUCT_TYPE>"
//					+	"</BODY>"
//					+"</DATA>";
//			msg = msg.replace("%CHANNEL_ID%",channel_id);
//			msg = msg.replace("%CHANNEL_PWD%",channel_pwd);
//			msg = msg.replace("%MSG_ID%",msg_id);
//			msg = msg.replace("TELNUM", serialNumber);
//			msg = msg.replace("%PRODUCT_TYPE%", product_type);
//			//log.error("流量赠送传入参数：" + msg);
//			params.append("msg").append("=").append(msg);
//			byte[] bypes = params.toString().getBytes();
//			OutputStream outputStream = conn.getOutputStream();
//			outputStream.write(bypes);
//			outputStream.flush();
//			outputStream.close();
//
//			// 将返回的输入流转换成字符串
//			InputStream inputStream = conn.getInputStream();
//			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//			String str = null;
//			StringBuffer buffer = new StringBuffer();
//			while ((str = bufferedReader.readLine()) != null) {
//				buffer.append(str);
//			}
//			bufferedReader.close();
//			inputStreamReader.close();
//			inputStream.close();
//			inputStream = null;
//			conn.disconnect();
//			Document document = DocumentHelper.parseText(buffer.toString());
//			Element root = document.getRootElement();
//			JSONObject headMap = new JSONObject();
//			Element node_head = root.element("HEAD");
//			Iterator<Element> it = node_head.elementIterator();
//			while(it.hasNext()) {
//				Element e = it.next();
//				headMap.put(e.getName(), e.getTextTrim());
//			}
//			return headMap;
//		}catch(Exception e){
//			//log.error(e.getMessage());
//		}
//		return null;
//	}
//	public interface Number{
//		String NumberLockPrefix="malllockNum";//号码商城选定锁定前缀
//		String NumberCacheKey = "NumberCacheKey_1";// 选择购买号码缓存
//		String SuccNumberCacheKey = "SuccNumberCacheKey";// 购买成功 缓存key
//		String schoolNumberCacheKey = "schoolNumberCacheKey";//选择购买号码缓存
//		String VisitorCacheKey = "VisitorCacheKey";//选择购买号码缓存
//		String Number_SaveFlag_List = "SL";//列表保存类型
//		String Number_SaveFlag_Detail = "SD";//详情保存类型
//		String Number_SaveFlag_NEW_PACKAGE = "NSP";//新版号码商城保存类型
//		String Number_SaveFlag_NEW_LIST = "NSL";//新版号码商城保存类型
//		String Number_SaveFlag_NEW_CHECK = "CHECK";//校验
//		String isNumListToDetail = "ListToDetail";//先选号码再选套餐标识类型
//		String NumberZF_28 = "28";//套餐资费24元/月（优酷）
//		String NumberZF_58 = "58";//套餐资费24元/月（PPTV）
//		String NumberZF_29 = "29";//套餐资费9元/月（优酷）
//		String NumberZF_59 = "59";//套餐资费9元/月（PPTV）
//		String OtherNetNumberCacheKey = "OtherNetNumberCacheKey";//异网号码缓存key
//		String APP_ITF_EMP_NUMBER_LIST_OTHERNET = "APP_ITF_EMP_NUMBER_LIST_OTHERNET";
//	}
//	/**
//	 * 字符串是否是纯数字
//	 * @param str String
//	 * @return boolean
//	 */
//	public static  boolean isNumeric(String str){
//		Pattern pattern = Pattern.compile("[0-9]*");
//		Matcher isNum = pattern.matcher(str);
//		if(!isNum.matches()){
//			return false;
//		}
//		return true;
//	}
//
//	/**
//	 * 咪咕视频相关参数
//	 */
//	public interface MIGU{
//		String ncode_miguyouhuibao = "gl_empty_101";// 2017咪咕视频优惠包
//		String ncode_migumianliuliang = "gl_mgspmll_tq";// 咪咕视频免流量特权
//	}
//	public  static final JSONObject MIGU_fix_ncode = new JSONObject();
//	static {
//		MIGU_fix_ncode.put("1", MIGU.ncode_miguyouhuibao);// 2017咪咕视频优惠包
//		MIGU_fix_ncode.put("2", MIGU.ncode_migumianliuliang);// 咪咕视频免流量特权
//	}
}
