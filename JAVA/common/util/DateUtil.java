package common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <b>class : </b> DateUtil
 * <b>Class Description</b><br>
 * Date를 처리하는 Util Class
 * <b>History</b><br>
 */
public class DateUtil{
	
	public DateUtil(){}
	
	public static int getCurrentDayType(){
		return 0;
	}
	
	/**
	 * 포멧을 Long타입으로 변환해주는 메소드
	 *
	 * @param format
	 * @return long
	 * @throws java.Exception
	 */
	public static long getCurrentTimeAsLong(int format) throws Exception{
		return Long.parseLong(get(format));
	}
	
	/**
	 * 포멧을 Int타입으로 변환해주는 메소드
	 *
	 * @param format
	 * @return int
	 * @throws java.Exception
	 */
	public static int getCurrentTimeAsInt(int format) throws Exception{
		return Integer.parseInt(get(format));
	}
	
	/**
	 * 날짜를 "yyMMddmmssSSS"형식으로 발생시켜주는 메소드
	 *
	 * @return long
	 */
	public static long getDupCheckDigit(){
		return Long.parseLong( (new SimpleDateFormat("yyMMddmmssSSS")).format(new Date()));
	}
	
	/**
	 * 포맷형식의 데이터를 발생시켜주는 메소드
	 *
	 * @param format
	 * @return String
	 */
	public static String get(int format){
		return get(new Date(), format);
	}
	
	/**
	 * 포맷형식의 데이터를 currentTimeMillis형태로 발생시켜주는 메소드
	 *
	 * @param currentTimeMillis
	 * @param format
	 * @return String
	 */
	public static String get(long currentTimeMillis, int format){
		return get(new Date(currentTimeMillis), format);
	}
	
	/**
	 *
	 * 현재 날짜와 시각을 yyyy-MM-dd hh:mm:ss.fffffffff Format의 Timestamp 로  Return한다.
	 *
	 * <pre>
	 *
	 * [사용 예제]
	 *
	 * CDateUtil.getCurrentTimeStamp()	===> 2004-02-24 13:22:11.734
	 *
	 * </pre>
	 *
	 * @return Timestamp
	 */
	public static Timestamp getCurrentTimeStamp()   {
		return  new Timestamp(new GregorianCalendar().getTime().getTime());
	}
	
	/**
	 * 포맷형식의 데이터를 currentTime형태로 발생시켜주는 메소드
	 *
	 * @param currentTime
	 * @param format
	 * @return String
	 */
	public static String get(Date currentTime, int format){
		String ret_val = null;
		switch(format){
		case 601:
			ret_val = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(currentTime);
			break;
		case 602:
			ret_val = (new SimpleDateFormat("yyyyMMddHHmm")).format(currentTime);
			break;
		case 10: // '\n'
			ret_val = (new SimpleDateFormat("yyyyMMdd")).format(currentTime);
			break;
		case 11: // '\013'
			ret_val = (new SimpleDateFormat("yyyy")).format(currentTime);
			break;
		case 12: // '\f'
			ret_val = (new SimpleDateFormat("MM")).format(currentTime);
			break;
		case 13: // '\r'
			ret_val = (new SimpleDateFormat("dd")).format(currentTime);
			break;
		case 20: // '\024'
			ret_val = (new SimpleDateFormat("HHmmss")).format(currentTime);
			break;
		case 21: // '\025'
			ret_val = (new SimpleDateFormat("HH")).format(currentTime);
			break;
		case 22: // '\026'
			ret_val = (new SimpleDateFormat("mm")).format(currentTime);
			break;
		case 23: // '\027'
			ret_val = (new SimpleDateFormat("ss")).format(currentTime);
			break;
		case 24: // '\030'
			ret_val = (new SimpleDateFormat("HHmm")).format(currentTime);
			break;
		case 99: // 'c'
			ret_val = (new SimpleDateFormat("yyyyMMddHHmmss")).format(
					currentTime);
			break;
		case 101: // 'e'
			ret_val = (new SimpleDateFormat("yyyy'-'MM'-'dd a HH:mm:ss")).
			format(currentTime);
			break;
		case 102: // 'f'
			ret_val = (new SimpleDateFormat(
			"yyyy'\uB144' MM'\uC6D4' dd'\uC77C' a HH:mm:ss")).format(currentTime);
			break;
		case 109: // 'm'
			ret_val = (new SimpleDateFormat("HH:mm:ss MM'-'dd' 'yyyy")).
			format(currentTime);
			break;
		case 201:
			ret_val = (new SimpleDateFormat("yyyy'/'MM'/'dd")).format(currentTime);
			break;
		case 301:
			ret_val = (new SimpleDateFormat("yyyyMMdd'/'HH':'mm':'ss")).format(currentTime);
			break;
		case 302:
			ret_val = (new SimpleDateFormat("yyyyMMdd'/'HH':'mm':'ss':'SS")).format(currentTime);
			break;
		case 401:
			ret_val = (new SimpleDateFormat("yyMMddmmssSSS")).format(currentTime);
			break;
		case 501:
			ret_val = (new SimpleDateFormat("HHmmssSSS")).format(currentTime);
			break;
		case 502:
			ret_val = (new SimpleDateFormat("yyMMdd")).format(currentTime);
			break;
		case 503:
			ret_val = (new SimpleDateFormat("yyyyMM")).format(currentTime);
			break;
		case 1: // '\001'
			ret_val = (new SimpleDateFormat("yyyy'.'MM'.'dd")).format(currentTime);
			break;
		case 2: // '\002'
			ret_val = (new SimpleDateFormat("yyyy'-'MM'-'dd")).format(currentTime);
			break;
		default:
			(new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss a zzz")).format(currentTime);
		ret_val = "";
		break;
		}
		return ret_val;
	}
	
	/**
	 * 포맷형태로 현재날짜를 발생시켜주는 메소드
	 *
	 * @param format
	 * @return String
	 */
	public static String getDate(String format){
		try{
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(now);
		} catch(Exception ex){
			return "00000000";
		}
	}
	
	/**
	 * 포맷형태로 date에 해당하는 날짜를 발생시켜주는 메소드
	 *
	 * @param format
	 * @return String
	 */
	public static String getDate(String format, Date date){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch(Exception ex){
			return "00000000";
		}
	}
	
	/**
	 *
	 * @param format
	 * @param dayCount
	 * @return
	 */
	public static String getDateFrom(String format, int dayCount){
		try{
			Calendar cdate = Calendar.getInstance();
			cdate.add(5, dayCount);
			Date date = cdate.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch(Exception ex){
			return "00000000";
		}
	}
	
	/**
	 *
	 * @param format
	 * @param data1
	 * @param dayCount
	 * @return
	 */
	public static String getDateFormatFrom(int format, String data1,
			int dayCount){
		String data = delDot(data1);
		try{
			int year = 0;
			int month = 0;
			int day = 0;
			if(data == null || data.length() < 8){
				return "00000000";
			}
			try{
				year = Integer.parseInt(data.substring(0, 4));
				month = Integer.parseInt(data.substring(4, 6)) - 1;
				day = Integer.parseInt(data.substring(6, 8));
			} catch(NumberFormatException nfe){
				return "00000000";
			}
			Calendar cdate = new GregorianCalendar(year, month, day);
			cdate.add(5, dayCount);
			Date date = cdate.getTime();
			SimpleDateFormat sdf;
			switch(format){
			case 601:
				sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				break;
			case 602:
				sdf = new SimpleDateFormat("yyyyMMddHHmm");
				break;
			case 10: // '\n'
				sdf = new SimpleDateFormat("yyyyMMdd");
				break;
			case 11: // '\013'
				sdf = new SimpleDateFormat("yyyy");
				break;
			case 12: // '\f'
				sdf = new SimpleDateFormat("MM");
				break;
			case 13: // '\r'
				sdf = new SimpleDateFormat("dd");
				break;
			case 20: // '\024'
				sdf = new SimpleDateFormat("HHmmss");
				break;
			case 21: // '\025'
				sdf = new SimpleDateFormat("HH");
				break;
			case 22: // '\026'
				sdf = new SimpleDateFormat("mm");
				break;
			case 23: // '\027'
				sdf = new SimpleDateFormat("ss");
				break;
			case 24: // '\030'
				sdf = new SimpleDateFormat("HHmm");
				break;
			case 99: // 'c'
				sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				break;
			case 101: // 'e'
				sdf = new SimpleDateFormat("yyyy'-'MM'-'dd a HH:mm:ss");
				break;
			case 102: // 'f'
				sdf = new SimpleDateFormat(
				"yyyy'\uB144' MM'\uC6D4' dd'\uC77C' a HH:mm:ss");
				break;
			case 109: // 'm'
				sdf = new SimpleDateFormat("HH:mm:ss MM'-'dd' 'yyyy");
				break;
			case 201:
				sdf = new SimpleDateFormat("yyyy'/'MM'/'dd");
				break;
			case 301:
				sdf = new SimpleDateFormat("yyyyMMdd'/'HH':'mm':'ss");
				break;
			case 302:
				sdf = new SimpleDateFormat("yyyyMMdd'/'HH':'mm':'ss':'SS");
				break;
			case 401:
				sdf = new SimpleDateFormat("yyMMddmmssSSS");
				break;
			case 501:
				sdf = new SimpleDateFormat("HHmmssSSS");
				break;
			case 502:
				sdf = new SimpleDateFormat("yyMMdd");
				break;
			case 503:
				sdf = new SimpleDateFormat("yyyyMM");
				break;
			case 1: // '\001'
				sdf = new SimpleDateFormat("yyyy'.'MM'.'dd");
				break;
			case 2: // '\002'
				sdf = new SimpleDateFormat("yyyy'-'MM'-'dd");
				break;
			default:
				sdf = new SimpleDateFormat(
				"yyyy.MM.dd G 'at' HH:mm:ss a zzz");
			break;
			}
			return sdf.format(date);
		} catch(Exception ex){
			return "00000000";
		}
	}
	
	/**
	 *
	 * @param format
	 * @param dayFormat
	 * @return
	 */
	public static String getDateFrom(String format, String dayFormat){
		try{
			int dayCount = Integer.parseInt(dayFormat.substring(0,
					dayFormat.length() - 1));
			char ymd = dayFormat.charAt(dayFormat.length() - 1);
			Calendar cdate = Calendar.getInstance();
			switch(ymd){
			case 121: // 'y'
				cdate.add(1, dayCount);
				break;
			case 109: // 'm'
				cdate.add(2, dayCount);
				break;
			case 119: // 'w'
				cdate.add(5, dayCount * 7);
				break;
			case 100: // 'd'
				cdate.add(5, dayCount);
				break;
			}
			Date date = cdate.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch(Exception ex){
			return ex.toString();
		}
	}
	
	/**
	 * 날짜를 포맷형식으로 치환해주는 메소드
	 *
	 * @param format        포맷 형식
	 * @param data          날짜
	 * @return String       포맷형식으로 치환된 날짜 값
	 */
	public static String getDateFormat(int format, String data){
		try{
			int year = 0;
			int month = 0;
			int day = 0;
			if(data == null || data.length() < 8){
				return "00000000";
			}
			if(data == "00000000"){
				return "";
			}
			try{
				year = Integer.parseInt(data.substring(0, 4));
				month = Integer.parseInt(data.substring(4, 6)) - 1;
				day = Integer.parseInt(data.substring(6, 8));
			} catch(NumberFormatException nfe){
				return "00000000";
			}
			Calendar cdate = new GregorianCalendar(year, month, day);
			Date date = cdate.getTime();
			SimpleDateFormat sdf;
			switch(format){
			case 601:
				sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				break;
			case 602:
				sdf = new SimpleDateFormat("yyyyMMddHHmm");
				break;
			case 10: // '\n'
				sdf = new SimpleDateFormat("yyyyMMdd");
				break;
			case 11: // '\013'
				sdf = new SimpleDateFormat("yyyy");
				break;
			case 12: // '\f'
				sdf = new SimpleDateFormat("MM");
				break;
			case 13: // '\r'
				sdf = new SimpleDateFormat("dd");
				break;
			case 20: // '\024'
				sdf = new SimpleDateFormat("HHmmss");
				break;
			case 21: // '\025'
				sdf = new SimpleDateFormat("HH");
				break;
			case 22: // '\026'
				sdf = new SimpleDateFormat("mm");
				break;
			case 23: // '\027'
				sdf = new SimpleDateFormat("ss");
				break;
			case 24: // '\030'
				sdf = new SimpleDateFormat("HHmm");
				break;
			case 99: // 'c'
				sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				break;
			case 101: // 'e'
				sdf = new SimpleDateFormat("yyyy'-'MM'-'dd a HH:mm:ss");
				break;
			case 102: // 'f'
				sdf = new SimpleDateFormat(
				"yyyy'년' MM'월' dd'일' a HH:mm:ss");
				break;
			case 109: // 'm'
				sdf = new SimpleDateFormat("HH:mm:ss MM'-'dd' 'yyyy");
				break;
			case 201:
				sdf = new SimpleDateFormat("yyyy'/'MM'/'dd");
				break;
			case 301:
				sdf = new SimpleDateFormat("yyyyMMdd'/'HH':'mm':'ss");
				break;
			case 302:
				sdf = new SimpleDateFormat("yyyyMMdd'/'HH':'mm':'ss':'SS");
				break;
			case 401:
				sdf = new SimpleDateFormat("yyMMddmmssSSS");
				break;
			case 501:
				sdf = new SimpleDateFormat("HHmmssSSS");
				break;
			case 502:
				sdf = new SimpleDateFormat("yyMMdd");
				break;
			case 503:
				sdf = new SimpleDateFormat("yyyyMM");
				break;
			case 1: // '\001'
				sdf = new SimpleDateFormat("yyyy'.'MM'.'dd");
				break;
			case 2: // '\002'
				sdf = new SimpleDateFormat("yyyy'-'MM'-'dd");
				break;
			default:
				sdf = new SimpleDateFormat(
				"yyyy.MM.dd G 'at' HH:mm:ss a zzz");
			break;
			}
			return sdf.format(date);
		} catch(Exception ex){
			return "00000000";
		}
	}
	
	/**
	 * 요일을 int형식으로 표현해주는 메소드
	 *
	 * @param data
	 * @return int      해당 날짜를 표현한 int
	 */
	public static int getDayOfWeek(String data){
		try{
			int year = 0;
			int month = 0;
			int day = 0;
			if(data == null || data.length() < 8){
				return -1;
			}
			try{
				year = Integer.parseInt(data.substring(0, 4));
				month = Integer.parseInt(data.substring(4, 6)) - 1;
				day = Integer.parseInt(data.substring(6, 8));
			} catch(NumberFormatException nfe){
				return -1;
			}
			Calendar cdate = new GregorianCalendar(year, month, day);
			return cdate.get(7);
		} catch(Exception ex){
			return -1;
		}
	}
	
	/**
	 * 두 날짜 사이의 차를 리턴해주는 문자열
	 *
	 * @param strYYYYMMDD11
	 * @param strYYYYMMDD22
	 * @return int      날짜 사이의 차
	 */
	public static int days_between(String strYYYYMMDD11, String strYYYYMMDD22){
		String strYYYYMMDD1 = delDot(strYYYYMMDD11);
		String strYYYYMMDD2 = delDot(strYYYYMMDD22);
		try{
			int year = Integer.parseInt(strYYYYMMDD1.substring(0, 4));
			int month = Integer.parseInt(strYYYYMMDD1.substring(4, 6));
			int day = Integer.parseInt(strYYYYMMDD1.substring(6));
			int year2 = Integer.parseInt(strYYYYMMDD2.substring(0, 4));
			int month2 = Integer.parseInt(strYYYYMMDD2.substring(4, 6));
			int day2 = Integer.parseInt(strYYYYMMDD2.substring(6));
			return days_between(year, month, day, year2, month2, day2);
		} catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 나이 계산
	 *
	 * @param strYYYYMMDD
	 * @return int      나이
	 */
	public static int old_between(String strYYYYMMDD){
		String strYYYYMMDD1 = delDot(strYYYYMMDD);
		String strYYYYMMDD2 = getDate("yyyyMMdd");
		
		try{
			int iage = 0;
			
			int year = Integer.parseInt(strYYYYMMDD1.substring(0, 4));
			int month = Integer.parseInt(strYYYYMMDD1.substring(4, 6));
			int day = Integer.parseInt(strYYYYMMDD1.substring(6));
			int year2 = Integer.parseInt(strYYYYMMDD2.substring(0, 4));
			int month2 = Integer.parseInt(strYYYYMMDD2.substring(4, 6));
			int day2 = Integer.parseInt(strYYYYMMDD2.substring(6));
			
			iage = year2 - year;
			
			if ( month > month2)
			{
				iage = iage - 1;
			}
			else if ( month == month2)
			{
				if ( day > day2)
				{
					iage = iage - 1;
				}
			}
			return iage;
		} catch(Exception e){
			e.printStackTrace();
		}
		return -1;
		
		/**
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy");
		java.util.Date currentDate = new java.util.Date();
		
		try{
			int sysdate = Integer.parseInt(dateFormat.format(currentDate));
			int age = 0;
			
			age = sysdate - Integer.parseInt(strYYYYMMDD.substring(0, 4));
		
			return age;
		} catch(Exception e){
			e.printStackTrace();
		}
		return -1;
		*/
	}
	
	/**
	 * 두 날짜 사이의 차를 리턴해주는 문자열
	 * @param year1
	 * @param month1
	 * @param day1
	 * @param year2
	 * @param month2
	 * @param day2
	 * @return int      날짜 사이의 차
	 */
	public static int days_between(int year1, int month1, int day1, int year2,
			int month2, int day2){
		try{
			Calendar temp = Calendar.getInstance();
			int M1 = month1 - 1;
			int M2 = month2 - 1;
			int sum_of_years = ( (year2 - year1) * 365 +
					number_of_addyear(year2)) -
					number_of_addyear(year1);
			temp.set(year2, M2, day2);
			int sum_of_day2 = temp.get(6);
			temp.set(year1, M1, day1);
			int sum_of_day1 = temp.get(6);
			int sum_of_days = sum_of_day2 - sum_of_day1;
			int sum = sum_of_years + sum_of_days;
			return sum;
		} catch(Exception e){
			return 0;
		}
	}
	
	/**
	 *
	 * @param year
	 * @return int
	 */
	public static int number_of_addyear(int year){
		return( (year - 1) / 4 - (year - 1) / 100) + (year - 1) / 400;
	}
	
	/**
	 *  문자열에서 '.'을 제거하는 메소드
	 *
	 * @param str       치환대상 문자열
	 * @return String   '.'이 제거된 문자열
	 */
	public static String delDot(String str){
		if(str == null){
			return "";
		}
		StringBuffer dest = new StringBuffer();
		for(int i = 0; i < str.length(); ){
			int c = str.charAt(i);
			switch(c){
			default:
				dest.append( (char) c);
			// fall through
			case 46: // '.'
				i++;
				break;
			}
		}
		return dest.toString();
	}
	
	/**
	 * 요일을 int형식으로 표현해주는 메소드
	 *
	 * @return int  해당 날짜를 표현한 int
	 */
	public static int getDayOfWeek(){
		try{
			Calendar cdate = Calendar.getInstance();
			return cdate.get(7);
		} catch(Exception ex){
			return -1;
		}
	}
	
	/**
	 * Date를 입력받아 음력으로 치환해주는 메소드
	 *
	 * @param year1
	 * @param month1
	 * @param day1
	 * @return String   음력으로 치환된 Date 문자열
	 */
	public static String calcToLunar(String year1, String month1, String day1){
		String sResult = "";
		for(i = 0; i < 163; i++){
			dt[i] = 0;
			for(j = 0; j < 12; j++){
				switch(monthDigit[i * 13 + j]){
				case 1: // '\001'
				case 3: // '\003'
					dt[i] = dt[i] + 29;
					break;
				case 2: // '\002'
				case 4: // '\004'
					dt[i] = dt[i] + 30;
					break;
				}
			}
			switch(monthDigit[i * 13 + 12]){
			case 1: // '\001'
			case 3: // '\003'
				dt[i] = dt[i] + 29;
				break;
			case 2: // '\002'
			case 4: // '\004'
				dt[i] = dt[i] + 30;
				break;
			}
		}
		td1 = 0xa7a5eL;
		sunYear = Integer.parseInt(year1);
		sunMonth = Integer.parseInt(month1);
		sunDay = Integer.parseInt(day1);
		if(!verifyDate(sunYear, sunMonth, sunDay)){
			return
			"날짜 형식이 맞지 않습니다.";
		}
		k11 = sunYear - 1;
		td2 = ( (k11 * 365L + k11 / 4L) - k11 / 100L) + k11 / 400L;
		ll = sunYear % 400 == 0 || sunYear % 100 != 0 && sunYear % 4 == 0;
		if(ll) {
			monthLen[1] = 29;
		} else{
			monthLen[1] = 28;
		}
		for(i = 0; i < sunMonth - 1; i++) {
			td2 += monthLen[i];
		}
		td2 += sunDay;
		td = (td2 - td1) + 1L;
		td0 = dt[0];
		for(i = 0; i < 163; i++){
			if(td <= td0){
				break;
			}
			td0 += dt[i + 1];
		}
		lunarYear = i + 1881;
		td0 -= dt[i];
		td -= td0;
		if(monthDigit[i * 13 + 12] != 0) {
			jcount = 13;
		} else{
			jcount = 12;
		}
		m2 = 0;
		for(j = 0; j < jcount; j++){
			if(monthDigit[i * 13 + j] <= 2) {
				m2++;
			}
			if(monthDigit[i * 13 + j] <= 2) {
				m1 = monthDigit[i * 13 + j] + 28;
			} else{
				m1 = monthDigit[i * 13 + j] + 26;
			}
			if(td <= (long) m1){
				break;
			}
			td -= m1;
		}
		m0 = j;
		lunarMonth = m2;
		lunarDay = (int) td;
		w = (short) (int) (td2 % 7L);
		i = (int) ( (td2 + 4L) % 10L);
		j = (int) ( (td2 + 2L) % 12L);
		i1 = (lunarYear + 6) % 10;
		j1 = (lunarYear + 8) % 12;
		String retMonth = "";
		String retDay = "";
		if(lunarMonth < 10) {
			retMonth = "0" + lunarMonth;
		} else{
			retMonth = Integer.toString(lunarMonth);
		}
		if(lunarDay < 10) {
			retDay = "0" + lunarDay;
		} else{
			retDay = Integer.toString(lunarDay);
		}
		sResult = Integer.toString(lunarYear) + retMonth + retDay;
		return sResult;
	}
	
	/**
	 * 날짜를 검증해주는 메소드
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return Boolean
	 */
	private static boolean verifyDate(int year, int month, int day){
		if(year < 1881 || year > 2043 || month < 1 || month > 12){
			return false;
		}
		return day <= monthLen[month - 1];
	}
	
	public static final int YYYYMMDD_DOT = 1;
	public static final int YYYYMMDD_HYPHEN = 2;
	public static final int YYYYMMDD = 10;
	public static final int YYYY = 11;
	public static final int MM = 12;
	public static final int DD = 13;
	public static final int hhmmss = 20;
	public static final int hh = 21;
	public static final int mm = 22;
	public static final int ss = 23;
	public static final int hhmm = 24;
	public static final int YYYYMMDDhhmmss = 99;
	public static final int STYLE1 = 101;
	public static final int STYLE2 = 102;
	public static final int STYLE3 = 103;
	public static final int STYLE9 = 109;
	public static final int YYYYMMDD_SLASH = 201;
	public static final int LOG_FORMAT1 = 301;
	public static final int LOG_FORMAT2 = 302;
	public static final int DUP_CHECK = 401;
	public static final int hhmmssmil = 501;
	public static final int YYMMDD = 502;
	public static final int YYYYMM = 503;
	public static final int YYYYMMDDhhmmssmil = 601;
	public static final int YYYYMMDDhhmm = 602;
	public static final int BUSINESS_DAY = 10001;
	public static final int HALF_HOLIDAY = 10002;
	public static final int HOLIDAY = 10003;
	private static Date initDate = null;
	private static final String errMsg = "날짜 형식이 맞지 않습니다.";
	private static int sunYear;
	private static int sunMonth;
	private static int sunDay;
	private static int lunarYear;
	private static int lunarMonth;
	private static int lunarDay;
	private static int m1;
	private static int m2;
	private static int i;
	private static int j;
	private static int i1;
	private static int j1;
	private static int jcount;
	private static int w;
	private static int m0;
	private static int k1;
	private static int k2;
	private static int n2;
	private static boolean ll;
	private static boolean leapyes;
	private static boolean leap;
	private static int dt[] = new int[163];
	private static long td;
	private static long td0;
	private static long td1;
	private static long td2;
	private static long k11;
	private static long y;
	private static final String saGan[] = {
		"\uAC11", "\uC744", "\uBCD1", "\uC815", "\uBB34", "\uAE30", "\uACBD",
		"\uC2E0", "\uC784", "\uACC4"
	};
	private static final String saJi[] = {
		"1월", "2월", "3월", "4월", "5월", "6월", "7월",
		"8월", "9월", "10월",
		"11월", "12월"
	};
	private static final String saJiNm[] = {
		"\uC950", "\uC18C", "\uD638\uB791\uC774", "\uD1A0\uB07C", "\uC6A9",
		"\uBC40", "\uB9D0", "\uC591", "\uC6D0\uC22D\uC774", "\uB2ED",
		"\uAC1C", "\uB3FC\uC9C0"
	};
	private static final int monthLen[] = {
		31, 29, 31, 30, 31, 30, 31, 31, 30, 31,
		30, 31
	};
	private static final String week[] = {
		"일", "월", "화", "수", "목", "금", "토"
	};
	private static final int monthDigit[] = {
		1, 2, 1, 2, 1, 2, 2, 3, 2, 2,
		1, 2, 1, 1, 2, 1, 2, 1, 2, 1,
		2, 2, 1, 2, 2, 0, 1, 1, 2, 1,
		1, 2, 1, 2, 2, 2, 1, 2, 0, 2,
		1, 1, 2, 1, 3, 2, 1, 2, 2, 1,
		2, 2, 2, 1, 1, 2, 1, 1, 2, 1,
		2, 1, 2, 2, 0, 2, 1, 2, 1, 2,
		1, 1, 2, 1, 2, 1, 2, 0, 2, 2,
		1, 2, 3, 2, 1, 1, 2, 1, 2, 1,
		2, 2, 1, 2, 2, 1, 2, 1, 1, 2,
		1, 2, 1, 0, 2, 1, 2, 2, 1, 2,
		1, 2, 1, 2, 1, 2, 0, 1, 2, 3,
		2, 1, 2, 2, 1, 2, 1, 2, 1, 2,
		1, 2, 1, 2, 1, 2, 1, 2, 2, 1,
		2, 2, 0, 1, 1, 2, 1, 1, 2, 3,
		2, 2, 1, 2, 2, 2, 1, 1, 2, 1,
		1, 2, 1, 2, 1, 2, 2, 2, 0, 1,
		2, 1, 2, 1, 1, 2, 1, 2, 1, 2,
		2, 0, 2, 1, 2, 1, 2, 3, 1, 2,
		1, 2, 1, 2, 1, 2, 2, 2, 1, 2,
		1, 1, 2, 1, 2, 1, 2, 0, 1, 2,
		2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
		0, 2, 1, 2, 3, 2, 2, 1, 2, 1,
		2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
		2, 2, 1, 2, 1, 2, 0, 1, 2, 1,
		1, 2, 1, 2, 2, 3, 2, 2, 1, 2,
		1, 2, 1, 1, 2, 1, 2, 1, 2, 2,
		2, 1, 0, 2, 1, 2, 1, 1, 2, 1,
		2, 1, 2, 2, 2, 0, 1, 2, 1, 2,
		1, 3, 2, 1, 1, 2, 2, 1, 2, 2,
		2, 1, 2, 1, 1, 2, 1, 1, 2, 2,
		1, 0, 2, 2, 1, 2, 2, 1, 1, 2,
		1, 2, 1, 2, 0, 1, 2, 2, 1, 4,
		1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
		1, 2, 1, 2, 2, 1, 2, 1, 2, 1,
		0, 2, 1, 1, 2, 2, 1, 2, 1, 2,
		2, 1, 2, 0, 1, 2, 3, 1, 2, 1,
		2, 1, 2, 2, 2, 1, 2, 1, 2, 1,
		1, 2, 1, 2, 1, 2, 2, 2, 1, 0,
		2, 1, 2, 1, 1, 2, 3, 1, 2, 2,
		1, 2, 2, 2, 1, 2, 1, 1, 2, 1,
		1, 2, 2, 1, 2, 0, 2, 2, 1, 2,
		1, 1, 2, 1, 1, 2, 1, 2, 0, 2,
		2, 1, 2, 2, 3, 1, 2, 1, 2, 1,
		1, 2, 2, 1, 2, 2, 1, 2, 1, 2,
		1, 2, 1, 2, 0, 1, 2, 1, 2, 1,
		2, 2, 1, 2, 1, 2, 1, 0, 2, 1,
		3, 2, 1, 2, 2, 1, 2, 2, 1, 2,
		1, 2, 1, 1, 2, 1, 2, 1, 2, 2,
		2, 1, 2, 0, 1, 2, 1, 1, 2, 1,
		2, 3, 2, 2, 1, 2, 2, 1, 2, 1,
		1, 2, 1, 1, 2, 2, 1, 2, 2, 0,
		2, 1, 2, 1, 1, 2, 1, 1, 2, 1,
		2, 2, 0, 2, 1, 2, 2, 1, 3, 2,
		1, 1, 2, 1, 2, 2, 1, 2, 2, 1,
		2, 1, 2, 1, 2, 1, 1, 2, 0, 2,
		1, 2, 1, 2, 2, 1, 2, 1, 2, 1,
		1, 0, 2, 1, 2, 2, 3, 2, 1, 2,
		2, 1, 2, 1, 2, 1, 1, 2, 1, 2,
		1, 2, 2, 1, 2, 2, 1, 0, 2, 1,
		1, 2, 1, 2, 1, 2, 2, 1, 2, 2,
		0, 1, 2, 3, 1, 2, 1, 1, 2, 2,
		1, 2, 2, 2, 1, 2, 1, 1, 2, 1,
		1, 2, 1, 2, 2, 2, 0, 1, 2, 2,
		1, 1, 2, 3, 1, 2, 1, 2, 2, 1,
		2, 2, 2, 1, 1, 2, 1, 1, 2, 1,
		2, 1, 0, 2, 2, 2, 1, 2, 1, 2,
		1, 1, 2, 1, 2, 0, 1, 2, 2, 1,
		2, 4, 1, 2, 1, 2, 1, 1, 2, 1,
		2, 1, 2, 2, 1, 2, 2, 1, 2, 1,
		2, 0, 1, 1, 2, 1, 2, 1, 2, 2,
		1, 2, 2, 1, 0, 2, 1, 1, 4, 1,
		2, 1, 2, 1, 2, 2, 2, 1, 2, 1,
		1, 2, 1, 1, 2, 1, 2, 2, 2, 1,
		0, 2, 2, 1, 1, 2, 1, 1, 4, 1,
		2, 2, 1, 2, 2, 2, 1, 1, 2, 1,
		1, 2, 1, 2, 1, 2, 0, 2, 2, 1,
		2, 1, 2, 1, 1, 2, 1, 2, 1, 0,
		2, 2, 1, 2, 2, 1, 4, 1, 1, 2,
		1, 2, 1, 2, 1, 2, 2, 1, 2, 2,
		1, 2, 1, 1, 2, 0, 1, 2, 1, 2,
		1, 2, 2, 1, 2, 2, 1, 2, 0, 1,
		1, 2, 1, 4, 1, 2, 1, 2, 2, 1,
		2, 2, 1, 1, 2, 1, 1, 2, 1, 2,
		2, 2, 1, 2, 0, 2, 1, 1, 2, 1,
		1, 2, 1, 2, 2, 1, 2, 0, 2, 2,
		3, 1, 2, 1, 1, 2, 1, 2, 1, 2,
		2, 2, 1, 2, 1, 2, 1, 1, 2, 1,
		2, 1, 2, 0, 2, 2, 1, 2, 1, 2,
		1, 3, 2, 1, 2, 1, 2, 2, 1, 2,
		2, 1, 2, 1, 1, 2, 1, 2, 1, 0,
		2, 1, 2, 2, 1, 2, 1, 2, 1, 2,
		1, 2, 0, 1, 2, 1, 2, 1, 4, 2,
		1, 2, 1, 2, 1, 2, 1, 2, 1, 1,
		2, 2, 1, 2, 2, 1, 2, 2, 0, 1,
		1, 2, 1, 1, 2, 1, 2, 2, 1, 2,
		2, 0, 2, 1, 1, 4, 1, 1, 2, 1,
		2, 1, 2, 2, 2, 1, 2, 1, 2, 1,
		1, 2, 1, 2, 1, 2, 2, 0, 2, 1,
		2, 1, 2, 1, 1, 2, 3, 2, 1, 2,
		2, 1, 2, 2, 1, 2, 1, 1, 2, 1,
		2, 1, 2, 0, 1, 2, 2, 1, 2, 1,
		2, 1, 2, 1, 2, 1, 0, 2, 1, 2,
		1, 2, 2, 3, 2, 1, 2, 1, 2, 1,
		2, 1, 2, 1, 2, 1, 2, 2, 1, 2,
		1, 2, 0, 1, 2, 1, 1, 2, 1, 2,
		2, 1, 2, 2, 1, 0, 2, 1, 2, 1,
		3, 2, 1, 2, 1, 2, 2, 2, 1, 2,
		1, 2, 1, 1, 2, 1, 2, 1, 2, 2,
		2, 0, 1, 2, 1, 2, 1, 1, 2, 1,
		1, 2, 2, 1, 0, 2, 2, 2, 3, 2,
		1, 1, 2, 1, 1, 2, 2, 1, 2, 2,
		1, 2, 2, 1, 1, 2, 1, 2, 1, 2,
		0, 1, 2, 2, 1, 2, 1, 2, 3, 2,
		1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
		2, 1, 2, 1, 2, 1, 0, 2, 1, 1,
		2, 2, 1, 2, 1, 2, 2, 1, 2, 0,
		1, 2, 1, 1, 2, 3, 2, 1, 2, 2,
		2, 1, 2, 1, 2, 1, 1, 2, 1, 2,
		1, 2, 2, 2, 1, 0, 2, 1, 2, 1,
		1, 2, 1, 1, 2, 2, 2, 1, 0, 2,
		2, 1, 2, 3, 1, 2, 1, 1, 2, 2,
		1, 2, 2, 2, 1, 2, 1, 1, 2, 1,
		1, 2, 1, 2, 0, 2, 2, 1, 2, 1,
		2, 1, 2, 3, 2, 1, 1, 2, 2, 1,
		2, 2, 1, 2, 1, 2, 1, 2, 1, 1,
		0, 2, 2, 1, 2, 1, 2, 2, 1, 2,
		1, 2, 1, 0, 2, 1, 1, 2, 1, 2,
		4, 1, 2, 2, 1, 2, 1, 2, 1, 1,
		2, 1, 2, 1, 2, 2, 1, 2, 2, 0,
		1, 2, 1, 1, 2, 1, 1, 2, 2, 1,
		2, 2, 0, 2, 1, 2, 1, 3, 2, 1,
		1, 2, 2, 1, 2, 2, 2, 1, 2, 1,
		1, 2, 1, 1, 2, 1, 2, 2, 0, 2,
		1, 2, 2, 1, 1, 2, 1, 1, 2, 3,
		2, 2, 1, 2, 2, 1, 2, 1, 2, 1,
		1, 2, 1, 2, 0, 1, 2, 2, 1, 2,
		2, 1, 2, 1, 2, 1, 1, 0, 2, 1,
		2, 2, 1, 2, 3, 2, 2, 1, 2, 1,
		2, 1, 1, 2, 1, 2, 1, 2, 2, 1,
		2, 2, 1, 0, 2, 1, 1, 2, 1, 2,
		1, 2, 2, 1, 2, 2, 0, 1, 2, 1,
		1, 2, 3, 1, 2, 1, 2, 2, 2, 2,
		1, 2, 1, 1, 2, 1, 1, 2, 1, 2,
		2, 2, 0, 1, 2, 2, 1, 1, 2, 1,
		1, 2, 1, 2, 2, 0, 1, 2, 2, 3,
		2, 1, 2, 1, 1, 2, 1, 2, 1, 2,
		2, 2, 1, 2, 1, 2, 1, 1, 2, 1,
		2, 0, 1, 2, 2, 1, 2, 2, 1, 2,
		3, 2, 1, 1, 2, 1, 2, 1, 2, 2,
		1, 2, 1, 2, 2, 1, 2, 0, 1, 1,
		2, 1, 2, 1, 2, 2, 1, 2, 2, 1,
		0, 2, 1, 1, 2, 1, 3, 2, 2, 1,
		2, 2, 2, 1, 2, 1, 1, 2, 1, 1,
		2, 1, 2, 2, 2, 1, 0, 2, 2, 1,
		1, 2, 1, 1, 2, 1, 2, 2, 1, 0,
		2, 2, 2, 1, 3, 2, 1, 1, 2, 1,
		2, 1, 2, 2, 2, 1, 2, 1, 2, 1,
		1, 2, 1, 2, 1, 0, 2, 2, 1, 2,
		2, 1, 2, 1, 1, 2, 1, 2, 0, 1,
		2, 3, 2, 2, 1, 2, 1, 2, 2, 1,
		1, 2, 1, 2, 1, 2, 1, 2, 2, 1,
		2, 2, 1, 2, 0, 1, 1, 2, 1, 2,
		1, 2, 3, 2, 2, 1, 2, 2, 1, 1,
		2, 1, 1, 2, 1, 2, 2, 2, 1, 2,
		0, 2, 1, 1, 2, 1, 1, 2, 1, 2,
		2, 1, 2, 0, 2, 2, 1, 1, 2, 3,
		1, 2, 1, 2, 1, 2, 2, 2, 1, 2,
		1, 2, 1, 1, 2, 1, 2, 1, 2, 0,
		2, 1, 2, 2, 1, 2, 1, 1, 2, 1,
		2, 1, 0, 2, 1, 2, 4, 2, 1, 2,
		1, 1, 2, 1, 2, 1, 2, 1, 2, 2,
		1, 2, 1, 2, 1, 2, 1, 2, 0, 1,
		2, 1, 2, 1, 2, 1, 2, 2, 3, 2,
		1, 2, 1, 2, 1, 1, 2, 1, 2, 2,
		2, 1, 2, 2, 0, 1, 1, 2, 1, 1,
		2, 1, 2, 2, 1, 2, 2, 0, 2, 1,
		1, 2, 1, 3, 2, 1, 2, 1, 2, 2,
		2, 1, 2, 1, 2, 1, 1, 2, 1, 2,
		1, 2, 2, 0, 2, 1, 2, 1, 2, 1,
		1, 2, 1, 2, 1, 2, 0, 2, 1, 2,
		2, 3, 2, 1, 1, 2, 1, 2, 1, 2,
		1, 2, 2, 1, 2, 1, 2, 1, 2, 1,
		2, 1, 0, 2, 1, 2, 1, 2, 2, 1,
		2, 1, 2, 1, 2, 0, 1, 2, 3, 2,
		1, 2, 1, 2, 2, 1, 2, 1, 2, 1,
		2, 1, 1, 2, 1, 2, 2, 1, 2, 2,
		1, 0, 2, 1, 2, 1, 1, 2, 3, 2,
		1, 2, 2, 2, 1, 2, 1, 2, 1, 1,
		2, 1, 2, 1, 2, 2, 2, 0, 1, 2,
		1, 2, 1, 1, 2, 1, 1, 2, 2, 2,
		0, 1, 2, 2, 1, 2, 3, 1, 2, 1,
		1, 2, 2, 1, 2, 2, 1, 2, 2, 1,
		1, 2, 1, 1, 2, 2, 0, 1, 2, 1,
		2, 2, 1, 2, 1, 2, 1, 2, 1, 0,
		2, 1, 2, 3, 2, 1, 2, 2, 1, 2,
		1, 2, 1, 2, 1, 1, 2, 1, 2, 2,
		1, 2, 2, 1, 2, 0, 1, 2, 1, 1,
		2, 1, 2, 3, 2, 2, 2, 1, 2, 1,
		2, 1, 1, 2, 1, 2, 1, 2, 2, 2,
		1, 0, 2, 1, 2, 1, 1, 2, 1, 1,
		2, 2, 1, 2, 0, 2, 2, 1, 2, 1,
		1, 4, 1, 1, 2, 1, 2, 2, 2, 2,
		1, 2, 1, 1, 2, 1, 1, 2, 1, 2,
		0, 2, 2, 1, 2, 1, 2, 1, 2, 1,
		1, 2, 1, 0, 2, 2, 1, 2, 2, 3,
		2, 1, 2, 1, 2, 1, 1, 2, 1, 2,
		2, 1, 2, 2, 1, 2, 1, 2, 1, 0,
		2, 1, 1, 2, 1, 2, 2, 1, 2, 2,
		1, 2, 0, 1, 2, 3, 1, 2, 1, 2,
		1, 2, 2, 2, 1, 2, 1, 2, 1, 1,
		2, 1, 1, 2, 2, 1, 2, 2, 0
	};
	
	/**
	 * VISIT DATE 를 검증해주는 메소드
	 *
	 * @param Visit 순번
	 * @param visit date
	 */
	public static int visitdateCheck(int visitday, String visitDate){
		if ( visitDate.length() != 8)	return 0;
		
		int iDays = 0;
		int iOverDay = 0;
		String sFinalDate = ""; 
		
		if ( visitday == 1){
			iDays = 30;
		} else if (visitday == 2){
			iDays = 180;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd" );
        Calendar cVisitDate = Calendar.getInstance();
        
        cVisitDate.set( Integer.parseInt( visitDate.substring( 0, 4 ) ),
                   Integer.parseInt( visitDate.substring( 4, 6 ) ) - 1,
                   Integer.parseInt( visitDate.substring( 6 ) ) );
        
        cVisitDate.add( Calendar.DATE, iDays );
               
        sFinalDate = formatter.format( cVisitDate.getTime() );
        
        iOverDay = days_between(sFinalDate, get(10));
        
        return iOverDay;
	}
	
	/**
	 * VISIT DATE 를 검증해주는 메소드
	 *
	 * @param Visit 순번
	 * @param visit date
	 */
	public static String visitdate(int visitday, String visitDate){
		if ( visitDate.length() != 8)	return "";
		
		int iDays = 0;
		String sFinalDate = ""; 
		
		if ( visitday == 1){
			iDays = 30;
		} else if (visitday == 2){
			iDays = 180;
		} else if (visitday == 3){
			iDays = 270;
		} else if (visitday == 4){
			iDays = 360;
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd" );
        Calendar cVisitDate = Calendar.getInstance();
        
        cVisitDate.set( Integer.parseInt( visitDate.substring( 0, 4 ) ),
                   Integer.parseInt( visitDate.substring( 4, 6 ) ) - 1,
                   Integer.parseInt( visitDate.substring( 6 ) ) );
        
        cVisitDate.add( Calendar.DATE, iDays );
               
        sFinalDate = formatter.format( cVisitDate.getTime() );
        
        return sFinalDate;
	}
	
	public static String getCurrentDate(){
		java.util.Calendar date = java.util.Calendar.getInstance();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		String CurrentDate = formatDate.format(date.getTime());
		
		return NullTrim(CurrentDate);
	}

	public static String NullTrim(String str) {
        String strTmp;
        if ((str == null)||(str.equals(""))||(str.toLowerCase().equals("null"))){
            strTmp = "";
        }else{
            strTmp = str.trim();
		}
        return strTmp;
    }

	public static String getCurrentWeek(){
		java.util.Calendar date = java.util.Calendar.getInstance();
		
		String CurrentWeek = Integer.toString(date.get(date.WEEK_OF_MONTH));
		
		return NullTrim(CurrentWeek);
	}

	public static String getMonth(String strYYYYMM, String strValue){
		Calendar cal = new GregorianCalendar();
		
		int YYYY = Integer.parseInt(strYYYYMM.substring(0,4)) ;	
	    int MM   = Integer.parseInt(strYYYYMM.substring(4,6)) ;	
	    
		cal.set(cal.YEAR, YYYY);
	    if("+".equals(strValue)){
			cal.set(cal.MONTH, MM+1);
			MM = cal.get(cal.MONTH);
			if(MM > 12){
				MM = 1;
				cal.set(cal.YEAR, YYYY+1);
			}
			YYYY = cal.get(cal.YEAR);
	    }else{
			cal.set(cal.MONTH, MM-1);
			MM = cal.get(cal.MONTH);
			if(MM < 1){
				MM = 12;
				cal.set(cal.YEAR, YYYY-1);
			}
			YYYY = cal.get(cal.YEAR);
	    }

	    String sMM = ((MM<10)?"0":"")+MM; 
	    String sYYYYMM = YYYY + sMM;
	    
		return NullTrim(sYYYYMM);
	}

	public static String getDay(String strYMD, String strValue){
		Calendar cal = new GregorianCalendar();
		
		int YYYY = Integer.parseInt(strYMD.substring(0,4)) ;	
	    int MM   = Integer.parseInt(strYMD.substring(4,6)) ;	
	    int DD   = Integer.parseInt(strYMD.substring(6,8)) ;	
	    
		cal.set(cal.YEAR, YYYY);
		cal.set(cal.MONTH, MM-1);
		cal.set(cal.DATE, DD);
	    if("+".equals(strValue)){
			cal.set(cal.DATE, DD+1);
	    }else{
			cal.set(cal.DATE, DD-1);
	    }
		Date nextDay = cal.getTime();
		String next_val = (new SimpleDateFormat("yyyyMMdd")).format(nextDay);
	    
		return NullTrim(next_val);
	}

	public static String getCurrentDate(int day){
		Calendar cal = new GregorianCalendar();

		java.util.Calendar date = java.util.Calendar.getInstance();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		String CurrentDate = formatDate.format(date.getTime());

		int YYYY = Integer.parseInt(CurrentDate.substring(0,4)) ;	
	    int MM   = Integer.parseInt(CurrentDate.substring(4,6)) ;	
	    int DD   = Integer.parseInt(CurrentDate.substring(6,8)) ;	
	    
		cal.set(cal.YEAR, YYYY);
		cal.set(cal.MONTH, MM-1);
		cal.set(cal.DATE, DD);

		cal.set(cal.DATE, DD+day);
		Date nextDay = cal.getTime();
		String next_val = (new SimpleDateFormat("yyyyMMdd")).format(nextDay);

		return NullTrim(next_val);
	}

}