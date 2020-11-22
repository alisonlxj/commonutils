package com.alison.commonutils.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author lixianjun02
 * @ClassName BigDecimalUtils
 * @Description ...
 * @Date 2020/11/22 10:02 上午
 **/
public class BigDecimalUtils {


    private BigDecimalUtils() {
    }


    private void ___________cbd______________() {
    }

    /**
     * 字符串 -> 创建BigDecimal对象
     *
     * @param numberString
     * @return
     */
    public static BigDecimal cbd(String numberString) {
        return new BigDecimal(numberString);
    }


    /**
     * 数字 -> 创建BigDecimal对象
     *
     * @param number
     * @param <N>    any object extended Number
     * @return
     */
    public static <N extends Number> BigDecimal cbd(N number) {
        if (null == number) {
            return null;
        }
        return cbd(String.valueOf(number));
    }


    private void ___________arithmetic______________() {
    }

    /**
     * 累加计数
     * @param numbers
     * @return
     */
    public static BigDecimal add(Number... numbers) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (Number number : numbers) {
            bigDecimal = bigDecimal.add(cbd(number));
        }
        return bigDecimal;
    }

    /**
     * 减法计数
     * @param number1
     * @param number2
     * @param <N1>
     * @param <N2>
     * @return
     */
    public static <N1 extends Number, N2 extends Number> BigDecimal subtract(N1 number1, N2 number2) {
        return cbd(number1).subtract(cbd(number2));
    }

    public static BigDecimal multiply(Number... numbers) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (Number number : numbers) {
            bigDecimal = bigDecimal.multiply(cbd(number));
        }
        return bigDecimal;
    }

    /**
     * 相除计数（默认四舍五入保留2位小数）
     * @param number1
     * @param number2
     * @param <N1>
     * @param <N2>
     * @return
     */
    public static <N1 extends Number, N2 extends Number> BigDecimal divide(N1 number1, N2 number2) {
        return divide(number1, number2, 2, RoundingMode.HALF_UP);
    }

    /**
     * 相除计数（默认四舍五入）
     * @param number1
     * @param number2
     * @param scale 保留的小数位数
     * @param <N1>
     * @param <N2>
     * @return
     */
    public static <N1 extends Number, N2 extends Number> BigDecimal divide(N1 number1, N2 number2, int scale) {
        return divide(number1, number2, scale, RoundingMode.HALF_UP);
    }

    /**
     * 相除计数
     * @param number1
     * @param number2
     * @param scale 保留小数位数
     * @param roundingMode 保留算法
     * @param <N1>
     * @param <N2>
     * @return
     */
    public static <N1 extends Number, N2 extends Number> BigDecimal divide(N1 number1, N2 number2, int scale, RoundingMode roundingMode) {
        return cbd(number1).divide(cbd(number2), scale, roundingMode);
    }


    /**
     * 取相反数
     * @param number
     * @param <N>
     * @return
     */
    public static <N extends Number> BigDecimal opposite(N number) {
        return multiply(number, -1);
    }



    private void ___________trim_round______________() {
    }

    /**
     * 保留小数位数 2位
     * @param number
     * @param <N>
     * @return
     */
    public static <N extends Number> BigDecimal round(N number) {
        return round(number, 2);
    }

    /**
     * 保留小数位数
     * @param number
     * @param scale 保留的小数位数
     * @param <N>
     * @return
     */
    public static <N extends Number> BigDecimal round(N number, int scale) {
        return round(number, scale, RoundingMode.HALF_UP);
    }

    /**
     * 保留小数位数
     * @param number
     * @param scale 保留的小数位数
     * @param roundingMode 保留算法
     * @param <N>
     * @return
     */
    public static <N extends Number> BigDecimal round(N number, int scale, RoundingMode roundingMode) {
        return cbd(number).setScale(scale, roundingMode);
    }


}




