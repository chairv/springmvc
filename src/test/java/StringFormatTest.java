import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

import org.junit.Test;

/**
 * Created by tancw on 2016/1/18.
 */
public class StringFormatTest {


    /**
     * %s:字符串类型
     * %b:布尔类型
     * %d:整数类型
     * %f:浮点类型
     * %%:百分比类型
     * %n:换行符
     */
    @Test
	public void test1() {
		String str = null;
		str = String.format("Hi,%s", "林可林");
		System.out.println(str);
//        System.out.printf("3>7的结果是:%b %n",3>7);
        System.out.printf("上面的折扣是%02d",14);
        BigDecimal oldOnceLimit = new BigDecimal("110.10");
        System.out.println(String.format("单笔%s万、单日%s万、单月100万",oldOnceLimit.toPlainString(),oldOnceLimit));

        System.out.println(MessageFormat.format("{0}",oldOnceLimit));
    }

    /**
     *
     *   常见日期时间格式化
         c: 包括全部日期和时间信息 星期六 十月 27 14:21:20 CST 2007
         F: "年-月-日"格式，如：2007-10-27
         D: "月/日/年"格式，如：10/27/07
         r: "HH:MM:SS PM"格式(12时制)，如：02:25:51 下午
         T: "HH:MM:SS"格式(24时制)，如：14:28:16
         R: "HH:MM"格式(24时制)，如：14:28
     */

    @Test
    public void test2(){
        Date date=new Date(); // 创建日期对象
        System.out.printf("全部日期和时间信息:%tc%n",date);
        System.out.printf("年-月-日格式:%tF%n",date);
        System.out.printf("月/日/年格式:%tD%n",date);
        System.out.printf("HH:MM:SS格式(24时制):%tT%n",date);
        System.out.println(String.format("%tF",date));
        System.out.println(String.format("%tY%tm%td",date,date,date));
    }

    /**
     * 3、格式化日期字符串
     b或者h: 月份简称，如
     中：十月
     英：Oct

     B: 月份全称，如
     中：十月
     英：October

     a: 星期的简称，如
     中：星期六
     英：Sat

     A: 星期的全称，如：
     中：星期六
     英：Saturday

     C: 年的前两位数字(不足两位前面补0)，如：20
     y: 年的后两位数字(不足两位前面补0)，如：07
     Y: 4位数字的年份(不足4位前面补0)，如：2007
     j: 一年中的天数(即年的第几天)，如：300
     m: 两位数字的月份(不足两位前面补0)，如：10
     d: 两位数字的日(不足两位前面补0)，如：27
     e: 月份的日(前面不补0)，如：5
     */

    @Test
	public void test3() {
		Date date = new Date();
		System.out.printf("月份的日(前面不补0):%te", date);
		System.out.printf("\n月份:%tm", date);
		System.out.printf("\n%tY", date);
	}

    /*
    4、格式化时间字符串
    H: 2位数字24时制的小时(不足2位前面补0)，如：15
    I: 2位数字12时制的小时(不足2位前面补0)，如：03
    k: 2位数字24时制的小时(前面不补0)，如：15
    l: 2位数字12时制的小时(前面不补0)，如：3
    M: 2位数字的分钟(不足2位前面补0)，如：03
    S: 2位数字的秒(不足2位前面补0)，如：09
    L: 3位数字的毫秒(不足3位前面补0)，如：015
    N: 9位数字的毫秒数(不足9位前面补0)，如：562000000

    p: 小写字母的上午或下午标记，如：
    中：下午
    英：pm

    z: 相对于GMT的RFC822时区的偏移量，如：+0800
    Z: 时区缩写字符串，如：CST
    s: 1970-1-1 00:00:00 到现在所经过的秒数，如：1193468128
    Q: 1970-1-1 00:00:00 到现在所经过的毫秒数，如：1193468128984
    */

    @Test
    public void test(){
        String str = "date";
        String getName = String.format("get%s%s",str.substring(0,1).toUpperCase(),str.substring(1));
        System.out.println(getName);
    }



}
