package bigDecimalMethod;

/**
 * @author llf
 * @type
 * @create 2020/6/21 0:00
 * @description Bigdecimal 使用
 */

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 对于不需要准确计算精度的数字，可以使用double或者float，但是二者会损失精度
 * 实际开发中，如果需要准确精度数字，需要用到Bigdecimal
 * 由于Bigdecimal是创建的对象，所以我们不能用传统的+-*等进行预算
 * 应该调用相对应的方法
 */
public class BigDecimalMethod {
    private static BigDecimal bigDecimal1 = new BigDecimal(0.1);
    private static BigDecimal bigDecimal2 = new BigDecimal(0.2);

    //构造犯法
    public void constructorMethod(){
        //构造方法中，参数可为int double float String
        BigDecimal bigDecimal = new BigDecimal(0.1);
    }
    //常用方法
    public void commonMethod(){
        BigDecimal add = bigDecimal1.add(bigDecimal2);  //值相加
        BigDecimal subtract = bigDecimal1.subtract(bigDecimal2);    //值相减
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);    //值相乘
        BigDecimal divide = bigDecimal1.divide(bigDecimal2);        //值相除

        bigDecimal1.toString();     //值转为字符串
        bigDecimal1.intValue();     //值转为整数
        bigDecimal1.doubleValue();
        bigDecimal1.floatValue();
        bigDecimal1.doubleValue();
    }

    /**方法返回值是个int值
     * int =-1 小于
     * int = 0 等于
     * int = 1 大于
     */
    public void compareBigDemcimal(){
        int compare = bigDecimal1.compareTo(bigDecimal2);
    }

    //对货币和百分百进行格式化
    public void formatBigDecimal() {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(); //建立货币格式引用
        NumberFormat percentInstance = NumberFormat.getPercentInstance();   //建立百分百各式引用

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘

        System.out.println("贷款金额:\t" + currencyInstance.format(loanAmount));
        System.out.println("利率:\t" + percentInstance.format(interestRate));
        System.out.println("利息:\t" + currencyInstance.format(interest));
    }

    //除法时出现的异常
    public void exceptionBigDecimal(){
        /**
         * BigDecimal的divide方法进行除法时当不整除，出现无限循环小数时，就会抛异常
         * java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
         * divide方法设置精确的小数点，如：divide(xxxxx,2)
         */

    }

}
