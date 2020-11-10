package common.util;

// java API
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <b>class : </b> StringUtil
 * <b>Class Description</b><br>
 * String에 관한 처리를 담당하는 Util Class
 * <b>History</b><br>
 */
public class StringUtil {

    public StringUtil() {}

    /**
     * null 값을 "" 형태로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 문자열
     */
    public static String null2void(Object param) {
        if (( (String) param).trim().equals("null"))
            return "";
        if (param == null)
            return "";
        if ( ( (String) param).trim().equals(""))
            return "";
        else
            return trim( ( (String) param).trim());
    }

	/**
	 * 스트링 인자값이 null일경우 원하는 스트링 결과값으로 리턴한다.
	 * @param object : check 값
	 * @param result : str이 null일경우 원하는 값
	 */
	public static String null2void(String str, String result)
	{
		String returnStr = "";
		try{
			if(str==null || str.equals("null") || str.equals(""))
			{
				returnStr = result;
			}
			else
			{
				returnStr = str;
			}
		}catch(Exception e){
			returnStr = result;
		}finally{
			return delReq(returnStr);
		}
	}

    /**
     * null값을 0으로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 숫자
     */
    public static String null2zeroString(Object param) {
        if (param == null)
            return "0";
        if ( ( (String) param).trim().equals(""))
            return "0";
        else
            return (String) param;
    }

    /**
     * null값을 0으로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 숫자
     */
    public static int null2zeroint(Object param) {
        if (param == null)
            return 0;
        if ( ( (String) param).trim().equals(""))
            return 0;
        else
            return Integer.parseInt( (String) param);
    }

    /**
     * null값을 0으로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 숫자
     */
    public static double null2zerodbl(Object param) {
        if (param == null)
            return 0;
        if ( ( (String) param).trim().equals(""))
            return 0;
        else
            return Double.parseDouble( (String) param);
    }

    /**
     * null값을 0으로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 숫자
     */
    public static Integer null2zeroInt(Object param) {
        if (param == null)
            return Integer.getInteger("0");
        if ( ( (String) param).trim().equals(""))
            return Integer.getInteger("0");
        else
            return Integer.getInteger( (String) param);
    }

    /**
     * null값을 0으로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 숫자
     */
    public static long null2zerolong(Object param) {
        if (param == null)
            return 0;
        if ( ( (String) param).trim().equals(""))
            return 0;
        else
            return Long.parseLong( (String) param);
    }

    /**
     * null값을 0으로 치환해주는 메소드
     *
     * @param param     Object 유형의 치환 대상
     * @return          치환된 숫자
     */
    public static Long null2zeroLong(Object param) {
        if (param == null) {
            return Long.getLong("0");
        }

        if ( ( (String) param).trim().equals("")) {
            return Long.getLong("0");
        }
        else {
            return Long.getLong( (String) param);
        }
    }

    /**
     * 입력받은 문자열을 세자리마다 끊어 화폐단위표기형식으로 변환해주는 메소드
     *
     * @param str   처리대상 문자열
     * @return      화폐단위형식표기로 치환되어진 문자열
     */
    public static String getMoneyForm(String str) {
        if (str == null)
            return "";

        int offset = str.indexOf(".");
        String work_str = "";
        String nonwork_str = "";

        if (offset > 0) {
            work_str = str.substring(0, offset);
            nonwork_str = str.substring(offset, str.length());
        }
        else {
            work_str = str;
        }

        DecimalFormat df = new DecimalFormat("###,##0");
        double d = 0.0D;

        try {
            d = Double.valueOf(work_str).doubleValue();
        }
        catch (Exception e) {
            d = 0.0D;
        }
        return df.format(d) + nonwork_str;
    }

    /**
     * 소숫점이 들어간 str을 받아서 소숫점 아래 자리를 cnt수로 맞춰주는 메소드
     *
     * @param str       소숫점을 포함한 치환대상
     * @param cnt       치환이 될 소숫점 아래 자릿수
     * @return          str를 소숫점 아래 cnt자리로 맞춘 문자열
     */
    public static String getRateForm(String str, int cnt) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        if (str.indexOf(".") < 0) {
            sb.append(".");
            for (; cnt > 0; cnt--) {
                sb.append("0");
            }
        }
        else {
            for (; cnt >= str.length() - str.indexOf("."); cnt--) {
                sb.append("0");
                System.out.println(cnt);
            }
        }
        return sb.toString();
    }

    /**
     * 문자열을 입력받아 문자열 앞의 0을 제거하는 메소드
     *
     * @param str       치환대상 문자열
     * @return String   문자열의 앞에 포함된 0을 제거한 문자열
     */
    public static String rmZero(String str) {
        if (str == null)
            return "";

        char indexChr = ' ';
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == '0') {
                index++;
                continue;
            }
            indexChr = str.charAt(index);
            break;
        }
        if (index < str.length())
            return str.substring(indexChr != '.' ? index : index - 1);
        else
            return "0";
    }

    /**
     * 입력받은 문자열을 은행계좌번호 형식으로 변경시켜주는 메소드
     * @param acct      치환 대상 문자열
     * @return          은행계좌번호 형식으로 치환된 문자열
     */
    public static String getAcctForm(String acct) {
        if (acct == null)
            return "";

        acct = acct.trim();
        if (acct.length() < 12)
            return acct;
        else
            return putDash(acct, 3, 7, 2);
    }

    /**
     * 입력받은 문자열을 카드번호 형식으로 변경시켜주는 메소드
     * @param card      치환대상 문자열
     * @return          카드번호 형식으로 치환된 문자열
     */
    public static String getCardForm(String card) {
        if (card == null)
            return "";

        card = card.trim();
        if (card.length() < 16)
            return card;
        else
            return putDash(card, 4, 4, 4);
    }

    /**
     * str의 offset 자리 뒤에 '-'문자를 넣어주는 메소드
     *
     * @param str       치환대상 문자열
     * @param offset    치환대상 문자열 '-'문자를 넣어줄 위치
     * @return          str의 offset자리 뒤에 '-'를 첨가시킨 문자열
     */
    public static String putDash(String str, int offset) {
        if (str == null)
            return "";

        if (str.length() < offset || offset <= 0)
            return str;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == offset) {
                sb.append("-");
            }
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * str의 offset1 자리뒤와 offset1+cnt2자리 뒤에 '-'문자를 넣어주는 메소드
     * @param str       치환대상 문자열
     * @param offset1   첫번째 '-'가 들어갈 위치
     * @param cnt2      offset1 뒤에 두번째 '-'가 들어갈 위치
     * @return          str에 offset1, cnt2 자리 뒤에 '-'를 추가한 문자열
     */
    public static String putDash(String str, int offset1, int cnt2) {
        if (str == null)
            return "";

        int offset2 = offset1 + cnt2;
        if (str.length() < offset2 || offset2 <= 0)
            return str;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == offset1 || i == offset2)
                sb.append("-");
            if (c != ' ')
                sb.append(c);
        }
        return sb.toString();
    }

    /**
     * str의 offset1 자리뒤와 offset1+cnt2자리 뒤, offset1+cnt2+cnt3자리뒤에 '-'문자를 넣어주는 메소드
     * @param str       치환대상 문자열
     * @param offset1   첫번째 '-'가 들어갈 위치
     * @param cnt2      offset1 뒤에 두번째 '-'가 들어갈 위치
     * @param cnt3      cnt3 뒤에 세번째 '-'가 들어갈 위치
     * @return          str에 offset1, cnt2, cnt3위치 뒤에 '-'를 추가한 문자열
     */
    public static String putDash(String str, int offset1, int cnt2, int cnt3) {
        if (str == null)
            return "";

        int offset2 = offset1 + cnt2;
        int offset3 = offset2 + cnt3;
        if (str.length() < offset3 || offset3 <= 0)
            return str;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == offset1 || i == offset2 || i == offset3)
                sb.append("-");
            if (c != ' ')
                sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 문자열 앞뒤의 공백을 잘라주는 메소드
     * @param s     치환대상 문자열
     * @return      공백을 잘라낸 문자열
     */
    public static String trim(String s) {
        if (s == null)
            return "";

        int st = 0;
        char val[] = s.toCharArray();
        int count = val.length;
        int len;
        for (len = count; st < len && (val[st] <= ' ' || val[st] == '\u3000'); st++) {
            ;
        }
        for (; st < len && (val[len - 1] <= ' ' || val[len - 1] == '\u3000'); len--) {
            ;
        }
        return st <= 0 && len >= count ? s : s.substring(st, len);
    }

    /**
     * 입력받은 문자열을 length가 될때까지 빈 공백을 붙여주는 메소드
     * @param str       치환대상 문자열
     * @param length    공백을 덧붙여 완성할 문자열의 길이
     * @return          공백을 붙여 length의 길이가 된 문자열
     */
    public static String getANstring(String str, int length) {
        if (str == null)
            return "";

        for (int i = length - str.length(); i > 0; i--) {
            str = str + " ";
        }
        return str;
    }

    /**
     * 입력받은 숫자를 length가 될때까지 빈 공백을 붙여주는 메소드
     * @param intstr        치환대상 숫자열
     * @param length        공백을 덧붙여 완성할 숫자열의 길이
     * @return              공백을 붙여 length의 길이가 된 문자열
     */
    public static String getNstring(int intstr, int length) {
        String str = Integer.toString(intstr);
        for (int i = length - str.length(); i > 0; i--) {
            str = "0" + str;
        }
        return str;
    }

    /**
     * 계좌번호 형식의 문자열에서 '-'문자를 제거해주는 메소드
     * @param str       치환 대상 문자열
     * @return String   '-'가 제거된 문자열
     */
    public static String delDashAccNo(String str) {
        String temp = null;
        str = str.trim();
        int len = str.length();
        switch (len) {
            case 17: // '\021'
                temp = str.substring(0, 3) + str.substring(4, 10) +
                    str.substring(11, 13) + str.substring(14, 17);
                break;
            case 13: // '\r'
                temp = str.substring(0, 3) + str.substring(4, 6) +
                    str.substring(7, 13);
                break;
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            default:
                temp = str;
                break;
        }
        return temp;
    }

    /**
     * 화폐단위 표기법대로 문자열 사이에 ','를 추가해주는 메소드
     *
     * @param str       치환 대상 문자열
     * @return String   화폐단위 표기법대로 ','가 추가된 문자열
     */
    public static String addComma(String str) {
        String temp = null;
        if (str == null) {
            temp = "0";
        }
        else {
            double change = Double.valueOf(str.trim()).doubleValue();
            DecimalFormat decimal = new DecimalFormat("###,###,###,###");
            temp = decimal.format(change);
        }
        return temp;
    }

    /**
     * 소숫점이 포함된 문자열의 소숫점 앞자리를 화폐단위 표기법대로 치환해주는 메소드
     * @param str       치환 대상 문자열
     * @return String   화폐단위 표기법대로 소숫점 앞자리에 ','가 추가된 문자열
     */
    public static String eRateFormat(String str) {
        String temp = null;
        if (str == null) {
            temp = "0";
        }
        else {
            double change = Double.valueOf(str.trim()).doubleValue();
            DecimalFormat decimal = new DecimalFormat("###,###,###.##");
            temp = decimal.format(change);
        }
        return temp;
    }

    /**
     * 문자열에서 ','를 제거해주는 메소드
     *
     * @param str       치환대상 문자열
     * @return String   ','를 제거한 문자열
     */
    public static String delComma(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < str.length(); ) {
            int c = str.charAt(i);
            switch (c) {
                default:
                    dest.append( (char) c);
                    // fall through
                case 44: // ','
                    i++;
                    break;
            }
        }
        return dest.toString();
    }

    /**
     * 문자열에서 '-'를 제거해주는 문자열
     * @param s         치환대상 문자열
     * @return String   '-'를 제거한 문자열
     */
    public static String delDash(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '-') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 문자열에서 '/'를 제거해주는 문자열
     * @param s         치환대상 문자열
     * @return String   '-'를 제거한 문자열
     */
    public static String delSlash(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '/') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    
    /**
     * 문자열에서 '.'를 제거해주는 문자열
     * @param str       치환대상 문자열
     * @return String   '.'를 제거한 문자열
     */
    public static String delDot(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < str.length(); ) {
            int c = str.charAt(i);
            switch (c) {
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
     * 문자열에서 ' '를 제거해주는 문자열
     * @param s       치환대상 문자열
     * @return String   ' '를 제거한 문자열
     */
    public static String delSpace(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 문자열에서 특정 char를 제거해주는 메소드
     * @param str       치환대상 문자열
     * @return String   '-',' ',':'이 제거된 문자열
     */
    public static String delChar(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '-' && c != ' ' && c != ':') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 공백을 &nbsp태그로 치환해주는 메소드
     * @param str       치환대상 문자열
     * @return String   공백을 &nbsp로 치환한 문자열
     */
    public static String nullToNbsp(String str) {
        String ret = null;
        try {
            ret = str;
            if (str == null)
                ret = "&nbsp;";
        }
        catch (NullPointerException e) {
            ret = "&nbsp;";
            return ret;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Enter를 br태그로 변경해주는 메소드
     *
     * @param str       치환대상 문자열
     * @return String   Enter가 br태그로 변경된 문자열
     */
    public static String enterToBr(String str) {
        String ret = "";
        try {
            for (StringTokenizer st = new StringTokenizer(str, "\n"); st.hasMoreTokens(); ) {
                ret = ret + st.nextToken() + "<br>";
            }
            return ret;
        }
        catch (Exception e) {
            return str;
        }
    }

    /**
     * 문자열에 포함된 공백을 제거해주는 메소드
     * @param param     치환 대상 문자열
     * @return String   공백이 제거된 문자열
     */
    public static String mTrim(String param) {
        try {
            for (int i = 0; i < param.length(); ) {
                if (param.substring(i, i + 1).equals(" ") || param.substring(i, i + 1).equals("-"))
                    param = param.substring(0, i) + param.substring(i + 1, param.length());
                else
                    i++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return param;
    }

    /**
     * 전화번호를 입력받아 v_flag 단계에 해당하는 값을 리턴해주는 메소드
     * @param v_telno       처리대상 문자열
     * @param v_flag        리턴을 원하는 문자열 단계
     * @return String       v_flag 단계에 해당하는 문자열
     */
    public static String getTelSep(String v_telno, int v_flag) {
        String telno = "";
        String d_telno = "";
        String r_telno = "";
        String telno1 = "";
        String telno2 = "";
        String telno3 = "";
        try {
            if (v_telno != null) {
                telno = mTrim(v_telno);
                if (telno.length() >= 9) {
                    d_telno = telno.substring(0, 2);
                    if (d_telno.equals("02")) {
                        telno1 = telno.substring(0, 2);
                    }
                    else {
                        telno1 = telno.substring(0, 3);
                    }
                    telno2 = telno.substring(telno1.length(),
                                             telno.length() - 4);
                    telno3 = telno.substring(telno.length() - 4, telno.length());
                    if (v_flag == 1) {
                        r_telno = telno1;
                    }
                    else
                    if (v_flag == 2) {
                        r_telno = telno2;
                    }
                    else
                    if (v_flag == 3) {
                        r_telno = telno3;
                    }
                    else
                    if (v_flag == 4) {
                        r_telno = telno1 + "-" + telno2 + "-" + telno3;
                    }
                }
                else {
                    r_telno = telno;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return r_telno;
    }

    /**
     * 입력받은 문자열에서 out_len의 길이만큼 문자열을 잘라 리턴하는 메소드
     *
     * @param str           치환 대상 문자열
     * @param out_len       잘라낼 문자열의 길이
     * @return String       잘라낸 문자열
     */
    public static String getFixLen(String str, int out_len) {
        if (str == null || str.trim().equals("") || str.equals(null)) {
            return "치환 대상 문자열이 없습니다.";
        }
        byte input[] = str.getBytes();
        byte temp[] = new byte[out_len];
        int in_len = input.length;
        if (in_len > out_len)
            return bytesToText(input, 0, out_len);
        else
            return str;
    }

    /**
     * byte를 문자열로 치환해주는 메소드
     *
     * @param b             바이트 배열
     * @param bytesStart
     * @param textLength
     * @return String       문자열로 치환된 결과값
     */
    public static String bytesToText(byte b[], int bytesStart, int textLength) {
        int len = 0;
        int i;
        for (i = bytesStart; i < b.length && len < textLength; i++) {
            if (b[i] >= 0 && b[i] <= 255) {
                len++;
                continue;
            }
            if ( ( -95 > b[i] || b[i] > -84) && ( -80 > b[i] || b[i] > -56) &&
                ( -54 > b[i] || b[i] > -3)) {
                break;
            }
            i++;
            try {
                if ( -95 <= b[i] && b[i] <= -2) {
                    len++;
                    continue;
                }
                i--;
            }
            catch (Exception e) {
                i--;
            }
            break;
        }
        if (i == bytesStart) {
            return "";
        }
        else {
            return new String(b, bytesStart, i);
        }
    }

    /**
     * 입력받은 문자열의 숫자.영어.문자 여부를 비교하는 메소드
     *
     * @param input     치환대상 문자열
     * @return String   검사 결과
     */
    public static String isEngDigitOrLetter(String input) {
        if (input == null || input.equals(""))
            return "";

        byte binput[] = input.getBytes();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch) && !Character.isLetter(ch) && !Character.isWhitespace(ch)) {
                return "";
            }
        }
        for (int i = 0; i < binput.length; i++) {
            if ( (binput[i] < 0 || binput[i] > 255) &&
                ( -95 <= binput[i] && binput[i] <= -84 ||
                 -80 <= binput[i] && binput[i] <= -56 ||
                 -54 <= binput[i] && binput[i] <= -3)) {
                return "";
            }
        }
        return input;
    }

    /**
     * 문자열 속의 특정 값을 대체문자로 변경해주는 메소드
     *
     * @param in        치환 대상 문자열
     * @param from      치환 대상 문자
     * @param to        치환 될 문자
     * @return String   치환된 문자열
     */
    public static String replace(String in, String from, String to) {
        StringBuffer sb = new StringBuffer(in.length() * 2);
        String posString = in.toLowerCase();
        String cmpString = from.toLowerCase();
        int i = 0;
        for (boolean done = false; i < in.length() && !done; ) {
            int start = posString.indexOf(cmpString, i);
            if (start == -1) {
                done = true;
            }
            else {
                sb.append(in.substring(i, start) + to);
                i = start + from.length();
            }
        }
        if (i < in.length()) {
            sb.append(in.substring(i));
        }
        return sb.toString();
    }

    /**
     * 입력받은 문자열을 정의한 문자열로 변환해주는 메소드
     * @param sTagString    치환 대상 문자열
     * @return String       치환 결과 문자열
     */
    public static String replaceStr(String sTagString) {
        String sTextString = null;
        sTextString = replace(sTagString, "\"", "&quot;");
        sTextString = replace(sTextString, "& ", "&amp; ");
        sTextString = replace(sTextString, "<", "&lt;");
        sTextString = replace(sTextString, ">", "&gt;");
        sTextString = replace(sTextString, "\n", "<br>\n");
        return sTextString;
    }

	/**
	 * 스트링의 인자값을 HTML 테그형태나 반대로 변환한다.
	 * @param str 변환하고자 하는 텍스트
	 * @param n 타입
	 * @return 변환된 텍스트를 리턴한다.
	 */
  public static String convertText(String str,String n) {
  
      if(n.equals("1"))
      {
          if(str != null)
          {
              str = str.replaceAll("<", "&lt;");
              str = str.replaceAll("\n", "<br>");
              str = str.replaceAll("  ", "&nbsp;&nbsp;");
          }
      } else
      if(n.equals("2"))
      {
          if(str != null)
          {
              str = str.replaceAll("\b", "'");
              str = str.replaceAll("&quot;", "\"");
              str = str.replaceAll("\n", "<br>");
          }
      }
  	return str;
  }

  public static String convertHtml(String str) {
	  
      if(str != null)
      {
          str = str.replaceAll("&#38quot;", "\"");
          str = str.replaceAll("&lt;", "<");
          str = str.replaceAll("&gt;", ">");
//        str = str.replaceAll("&nbsp;", " ");
          str = str.replaceAll("&#38nbsp;", "&nbsp;");
          str = str.replaceAll("&#38amp;", "&");
      }
  	return str;
  }
	
  public static String convertSpace(String str) {
	  
      if(str != null)
      {
          str = str.replaceAll("\n", "");
          str = str.replaceAll("<br>", "");
          str = str.replaceAll("&nbsp;", "");
          str = str.replaceAll("<", "&lt;"); 
          str = str.replaceAll(">", "&gt;"); 
          str = str.replaceAll(" ", "");	
          str = str.replaceAll("chr(13)", "");
          str = str.replaceAll("chr(10)", "");
          str = str.replaceAll("chr(13)||chr(10)", "");
          str = str.replaceAll("\n\r", "");
      }
  	return str;
  }

	public static String chkLimit(String title,int maxNum)
	{	
		int re_level = 2;
	    int blankLen = 0;
	    int count = 0;
	    char c;
	    int tLen =title.length();
	    int s=0;
	    
	    if(re_level != 0){
	      blankLen = (re_level +1)*2;
	    }
	    
	    for(s=0;s<tLen;s++){
	      c = title.charAt(s);
	      if((int)(count) > (int)(maxNum-blankLen)){
	        break;
	      }
	      
	      if(c>127) count +=2 ;
	      else count ++;
	    }     
	    return (tLen >s)? title.substring(0,s)+"" : title;
	}

    /**
     * 구분값 사이에 값이 없을 때 존재하는 값만 리턴
     *
     * @param strSplit_String       치환 대상 문자열
     * @param chrGubun_Character    구분값
     * @return Vector               구분값을 기준으로 나눈 문자열을 담고 있는 벡터
     */
    public static Vector split(String strSplit_String, char chrGubun_Character) {
        int intFrom = 0; // substring시에 From 자리
        int intTo = 0; // substing시에 To 자리
        int index = 0;
        Vector vc = new Vector();
        for (intTo = 0; intTo < strSplit_String.length(); intTo++) {
            if (strSplit_String.charAt(intTo) == chrGubun_Character) {
                if (intFrom < intTo) {
                    vc.addElement(strSplit_String.substring(intFrom, intTo));
                    index++;
                    intFrom = intTo + 1;
                }
            }
        }
        vc.addElement(strSplit_String.substring(intFrom, strSplit_String.length()));
        return vc;
    }

    /**
     * 구분값 사이에 값이 없을 때 공백값도 같이 리턴
     *
     * @param strSplit_String       치환 대상 문자열
     * @param chrGubun_Character    구분값
     * @return Vector               구분값을 기준으로 나눈 문자열을 담고 있는 벡터
     */
    public static Vector null2split(String strSplit_String, char chrGubun_Character) {
        int intFrom = 0; // substring시에 From 자리
        int intTo = 0; // substing시에 To 자리
        int index = 0;
        Vector vc = new Vector();
        for (intTo = 0; intTo < strSplit_String.length(); intTo++) {
            if (strSplit_String.charAt(intTo) == chrGubun_Character) {
                vc.addElement(strSplit_String.substring(intFrom, intTo));
                index++;
                intFrom = intTo + 1;
            }
        }
        vc.addElement(strSplit_String.substring(intFrom, strSplit_String.length()));
        return vc;
    }

    /**
     *
     * 입력된 스트링에서 구분자(delimiter)에 나열된 모든 문자를 기준으로 문자열을 분리하고 분리된 문자열을 배열에 할당하여 반환한다.
     *
     * <pre>
     *
     * [사용 예제]
     *
     * split2Array("ABCDEABCDE", "BE")
     * ===> A
     *         CD
     *         A
     *         CD
     *
     * </pre>
     *
     * @param strTarget
     * @param delimiter
     * @return java.NATIONAL_CD.String[]
     * @roseuid 403A9A6E036B
     */
    public static String[] split2Array(String strTarget, String delimiter) {
        if(strTarget == null) return null;

        StringTokenizer st = new StringTokenizer(strTarget, delimiter);
        String[] names = new String[st.countTokens()];
        for(int i = 0; i < names.length; i++) {
            names[i] = st.nextToken().trim();
        }

        return names;
    }

    /**
     *
     * 입력된 스트링에서 구분자(delimiter)를 하나의 단어로 인식하고 이 단어를 기준으로 문자열을 분리, 분리된 문자열을 배열에 할당하여 반환한다.
     *
     * <pre>
     *
     * [사용 예제]
     *
     * split2Array("AA-BBB--DDDD", "-",true)
     * ===> AA
     *         BBB
     *
     *         DDDD
     *
     * split2Array("AA-BBB--DDDD", "-", false);
     * ===> AA
     *         BBB
      *         DDDD
     *
     * split2Array("ABCDEABCDE", "BE", true)
     * ===> ABCDEABCDE
     *
     * </pre>
     *
     * @param strTarget
     * @param delimiter 구분자(delimiter)로 인식할 단어로서 결과 문자열에는 포함되지 않는다.
     * @param isIncludedNull 구분자로 구분된 문자열이 Null일 경우 결과값에 포함여부 ( true : 포함, false : 포함하지 않음. )
     * @return java.NATIONAL_CD.String[]
     * @roseuid 403A9A6E0399
     */
    public static String[] split2Array(String strTarget, String delimiter, boolean isIncludedNull) {

        int index = 0;
        String[] resultStrArray = null;

        try {
            Vector v =  new Vector();

            String strCheck = new String(strTarget);
            while (strCheck.length() != 0) {
                int begin = strCheck.indexOf(delimiter);
                if (begin == -1) {
                    v.add(strCheck);
                    break;
                } else {
                    int end = begin + delimiter.length();
                    //	StringTokenizer는 구분자가 연속으로 중첩되어 있을 경우 공백 문자열을 반환하지 않음.
                    // 따라서 아래와 같이 작성함.
                    if (isIncludedNull) {
                        v.add(strCheck.substring(0, begin));
                        strCheck = strCheck.substring(end);
                        if (strCheck.length() == 0 ) {
                            v.add(strCheck);
                            break;
                        }
                    } else{
                        if (! CommonUtil.isEmpty(strCheck.substring(0, begin))){
                            v.add(strCheck.substring(0, begin));
                        }
                        strCheck = strCheck.substring(end);
                    }

                }
            }

            String[] tempString = new String[0];
            resultStrArray = (String[]) v.toArray(tempString);

        } catch (Exception e) {
            return resultStrArray;
        }

        return resultStrArray;
    }

    /**
     *
     * 입력된 스트링에서 제거할 문자(elimination)에 나열한 모든 문자를 제거한다.
     *
     * <pre>
     *
     * [사용 예제]
     *
     * stringRemove("02)2344-5555", "-# /)(:;")	===> 0223445555
     * stringRemove("ABCDEABCDE", "BE")		===> ACDACD
     *
     * </pre>
     * @param strTarget
     * @param elimination
     * @return java.NATIONAL_CD.String
     */
    public static String stringRemove(String strTarget, String elimination) {
        if (strTarget == null || strTarget.length() == 0 || elimination == null)
            return strTarget;
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(strTarget, elimination);
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
        }
        return sb.toString();
    }

    /**
     *
     * 입력한 문자열 앞뒤에  특정문자를 Left Padding한 문자열을 반환한다.
     *
     * <pre>
     *
     * [사용 예제]
     *
     * padLeft("AAAAAA", 'Z', 10) )	===> ZZZZAAAAAA
     *
     * </pre>
     *
     * @param str
     * @param padValue
     * @param length
     * @param value
     * @return java.NATIONAL_CD.String
     */
    public static String padLeft(String value, char padValue, int length) {

        if (value == null)
            value = "";

        byte[] orgByte = value.getBytes();
        int orglength = orgByte.length;

        if (orglength < length) { //add Padding character
            byte[] paddedBytes = new byte[length];

            int padlength = length - orglength;

            for (int i = 0; i < padlength; i++) {
                paddedBytes[i] = (byte) padValue;
            }

            System.arraycopy(orgByte, 0, paddedBytes, padlength, orglength);

            return new String(paddedBytes);
        }
        else if (orglength > length) { //주어진 길이보다 남는다면, 주어진 길이만큼만 잘른다.
            byte[] paddedBytes = new byte[length];
            System.arraycopy(orgByte, 0, paddedBytes, 0, length);
            return new String(paddedBytes);
        }

        return new String(orgByte);
    }

    /**
     *
     * 입력한 문자열 앞뒤에  특정문자를 Right Pading한 문자열을 반환한다.
     *
     * <pre>
     *
     * [사용 예제]
     *
     * padRight("AAAAAA", 'Z', 10) )	===> AAAAAAZZZZ
     *
     * </pre>
     *
     * @param str
     * @param padValue
     * @param length
     * @param value
     * @return java.NATIONAL_CD.String
     */
    public static String padRight(String value, char padValue, int length) {

        if (value == null)
            value = "";

        byte[] orgByte = value.getBytes();
        int orglength = orgByte.length;

        if (orglength < length) { //add Padding character
            byte[] paddedBytes = new byte[length];

            System.arraycopy(orgByte, 0, paddedBytes, 0, orglength);
            while (orglength < length) {
                paddedBytes[orglength++] = (byte) padValue;
            }
            return new String(paddedBytes);
        }
        else if (orglength > length) { //주어진 길이보다 남는다면, 주어진 길이만큼만 잘른다
            byte[] paddedBytes = new byte[length];
            System.arraycopy(orgByte, 0, paddedBytes, 0, length);
            return new String(paddedBytes);
        }

        return new String(orgByte);
    }

   
	/**
	 * 문자열 치환 XSS 취약공격
	 * 인수로 받은 문자열에서 <, > 을 치환함
	 * @param str
	 * @return
	 */
	public static String getScriptReplace(String str,String gubun){
		str = (str == null)? "" : str;
		if("tag".equals(gubun)){
			str = str.replaceAll("<+[S,s][C,c][R,r][I,i][P,p][T,t]", "<s-cript")
					 .replaceAll("[S,s][C,c][R,r][I,i][P,p][T,t]+>", "s-cript>")
					 .replaceAll("&lt;+[S,s][C,c][R,r][I,i][P,p][T,t]", "&lt;s-cript")
					 .replaceAll("[S,s][C,c][R,r][I,i][P,p][T,t]+&gt;", "s-cript&gt;");
		}else if("html".equals(gubun)){
			str = str.replaceAll("\"","&quot;")
					 .replaceAll("&","&#38")
					 .replaceAll("<","&lt;")
					 .replaceAll(">","&gt;")
					 .replaceAll("&lt;+[S,s][C,c][R,r][I,i][P,p][T,t]", "&lt;script")
					 .replaceAll("[S,s][C,c][R,r][I,i][P,p][T,t]+&gt;", "script&gt;");
		}
    	return str;
    }

	/**
	 * CharacterSet 변환
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String changeCharSet(String s, String IO) {
		try {
			if(s==null){
				s = "";
			} else {
				if ("O".equals(IO)) {
					//System.out.println("I'm OUTPUT");
					s = new String(s.getBytes("8859_1"), "KSC5601");
				} else if ("I".equals(IO)) {
					//System.out.println("I'm INPUT");
					s = new String(s.getBytes("KSC5601"), "8859_1");
					//System.out.println(s);
				}
			}
			return s;
		} catch (Exception e){
			return "changeCharSet Error"; 
		}
	}	

	/**
	 * 스트링을 토큰에 따라 나눠서 백터에 넣어 반환한다.
	 */
	public static String[] explode(String token, String input_str) {
		int size = 0;
		String[] ret_str = null;
		if(input_str.equals("")) {
			return null;
		}

		StringTokenizer stz = new StringTokenizer(input_str, token);
		size = stz.countTokens();

		if(size>0) {
			ret_str = new String[size];

			for(int i=0; i<size; i++) {
				ret_str[i] = stz.nextElement().toString();
			}

		}
		return ret_str;
	}

	/**
	 * 날짜값을 년,월,일을 붙혀서 리턴하는 메서드
	 * @param str 8자리의 날짜문자열
	 * @return 날짜값을 년,월,일을 붙혀서 리턴
	 */
	public static String convertDate(String str)
	{
		StringBuffer result = new StringBuffer();
		if(str != null && str.length()==8){
		  result.append(str.substring(0,4))
		  		.append("년 ")
		  		.append(str.substring(4,6))
		  		.append("월 ")
		  		.append(str.substring(6))
		  		.append("일");
		  return result.toString();
		}else{
		  return null2void(str);
		}
	}

	/**
	 * 날짜값을 -를 붙혀서 리턴하는 메서드
	 * @param str 8자리의 날짜문자열
	 * @return 날짜값을 년,월,일을 붙혀서 리턴
	 */
	public static String convertDashDate(String str)
	{
		StringBuffer result = new StringBuffer();
		if(str != null && str.length()==8){
		  result.append(str.substring(0,4))
		  		.append("-")
		  		.append(str.substring(4,6))
		  		.append("-")
		  		.append(str.substring(6));
		  return result.toString();
		}else{
		  return null2void(str);
		}
	}
	
	/**
	 * 시간 값을 :를 붙혀서 리턴하는 메서드
	 * @param str 4자리의 날짜문자열
	 * @return 시간 값을 시,분을 붙혀서 리턴
	 */
	public static String convertDashTime(String str)
	{
		StringBuffer result = new StringBuffer();
		if(str != null && str.length()==4){
		  result.append(str.substring(0,2))
		  		.append(":")
		  		.append(str.substring(2,4));
		  return result.toString();
		  
		}else{
		  return null2void(str);
		}
	}

	/**
	 * 날짜값을 원하는 타입으로 붙혀서 리턴하는 메서드
	 * @param str 8자리의 날짜문자열
	 * @return 날짜값을 원하는 타입으로 붙혀서 리턴
	 */
	public static String convertDate(String str, String oper)
	{
		StringBuffer result = new StringBuffer();
		if(str != null && str.length()==8){
		  result.append(str.substring(0,4))
		  		.append(oper)
		  		.append(str.substring(4,6))
		  		.append(oper)
		  		.append(str.substring(6))
		  		.append(oper);
		  return result.toString();
		}else{
		  return null2void(str);
		}
	}
	
	/**
	 * 우편번호 6자리를 3자리 끊어서 '-'를 삽입해서 리턴한다.
	 * @param str 6자리 우편번호
	 * @return 끊어서 연결된 우편번호
	 */
	public static String convertAddr(String str)
	{
		StringBuffer result = new StringBuffer();
		if(str != null && str.length()==6){
		  result.append(str.substring(0,3))
		  		.append("-")
		  		.append(str.substring(3));
		  return result.toString();
		}else{
		  return null2void(str);
		}
	}

	/**
	 * 사업자  10자리를 사업자 번호 체계에 끊어서 '-'를 삽입해서 리턴한다.
	 * @param str 사업자 등록번호 10자리
	 * @return 끊어서 연결된 사업자 등록번호
	 */
	public static String convertSaupja(String str)
	{
		StringBuffer result = new StringBuffer();
		if(str != null && str.length()==10){
		  result.append(str.substring(0,3))
		  		.append("-")
		  		.append(str.substring(3,5))
		  		.append("-")
		  		.append(str.substring(5));
		  return result.toString();
		}else{
		  return null2void(str);
		}
	}

	/**
	 * 주어진 문자열에서 html태그를 삭제 한다..
	 * @param str
	 * @return String
	 */
	public static String delHtml(String str){
		try{
		 Pattern p = Pattern.compile("\\<(\\/?)(\\w+)*([^<>]*)>");
		 Matcher m = p.matcher(str);
		 str = m.replaceAll("");
		}catch(Exception e){
			
		}
		return str;
	}
	
	/**
	 * 주어진 문자열에서 html태그를 삭제 한다..
	 * @param str
	 * @return String
	 */
	public static String delReq(String str){
		try{
			str = str.replaceAll("\"", "").replaceAll("'", "").replaceAll("--", "").replaceAll("##", "").replaceAll(";", "");
		}catch(Exception e){
			
		}
		return str;
	}
	
	/**
	  * % 값으로 변환한다.
	  * @param str , int
	  * @param n 타입
	  * @return 계산된 Percent 값 리턴한다.
	  */
	  public static int getPercent(String isum, String sValue) {
	  
	   int iSum = 0;
	   String sSum = isum;
	   
	   int fSum = (int) (Float.parseFloat(sValue) / Float.parseFloat(isum)*100);
	   
	   iSum = fSum;

	   if(iSum == 0) iSum = 1;
	   
	   return iSum;
	  }
	  
}