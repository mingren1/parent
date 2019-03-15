package com.rtmap.middle.framework.model.enumeration;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * @author jinjianjun
 * @project rtmap-scenes-crm
 * @date 2018/6/14
 */
public class CustomerType {

    /**
     * 1、注册会员
     2、银行卡支付
     3、微信粉丝
     4、支付宝会员
     5、mac感知会员
     6、idfa感知会员
     7、imei感知会员
     8、微信支付会员
     9、支付宝支付会员
     10、微信小程序会员
     */
    /*flag 备用 MINI_PROGRAM_FANS ALIPAY_PAYMENT FANS_PAYMENT  IMEI  IDFA  MAC  ALIPAY  FANS  BANK  MEMBER   备注
       1      0           0            0             0          0     0     0     0      0    0      1      只有注册
       2      0           0            0             0          0     0     0     0      0    1      0      只有银行卡
       4      0           0            0             0          0     0     0     0      1    0      0      只有粉丝
       8      0           0            0             0          0     0     0     1      0    0      0      只有支付宝
       16     0           0            0             0          0     0     1     0      0    0      0      只有MAC
       32     0           0            0             0          0     1     0     0      0    0      0      只有IDFA
       64     0           0            0             0          1     0     0     0      0    0      0      只有IMEI
       128    0           0            0             1          0     0     0     0      0    0      0      只有FANS_PAYMENT
       256    0           0            1             0          0     0     0     0      0    0      0     只有ALIPAY_PAYMENT
	   512	  0       	  1			   0			 0		    0	  0	    0	  0		 0	  0		 0	    只有MINI_PROGRAM_FANS
	   1024   1           0            0             0          0     0     0     0      0    0      0      备用
	*/

    /**
     * 注册类型，二进制第1位，0表示否，1表示是， 0000000001
     */
    public static final int MEMBER = 1 << 0;

    /**
     * 银行卡类型，二进制第2位，0表示否，1表示是， 0000000010
     */
    public static final int BANK = 1 << 1;

    /**
     * 微信粉丝类型，二进制第3位，0表示否，1表示是，0000000100
     */
    public static final int FANS = 1 << 2;
    /**
     * 支付宝类型，二进制第4位，0表示否，1表示是，0000001000
     */
    public static final int ALIPAY = 1 << 3;
    /**
     * 感知mac类型，二进制第5位，0表示否，1表示是，0000010000
     */
    public static final int MAC = 1 << 4;
    /**
     * 感知idfa类型，二进制第6位，0表示否，1表示是，0000100000
     */
    public static final int IDFA = 1 << 5;
    /**
     * 感知imei类型，二进制第7位，0表示否，1表示是，0001000000
     */
    public static final int IMEI = 1 << 6;
    /**
     * 微信支付会员类型，二进制第8位，0表示否，1表示是，0010000000
     */
    public static final int FANS_PAYMENT = 1 << 7;
    /**
     * 支付宝支付会员类型，二进制第8位，0表示否，1表示是，0100000000
     */
    public static final int ALIPAY_PAYMENT = 1 << 8;
    /**
     * 微信小程序会员类型，二进制第8位，0表示否，1表示是，1000000000
     */
    public static final int MINI_PROGRAM_FANS = 1 << 9;

    public static HashMap<Integer, String> map = new HashMap<>();
    static {

        map.put(MEMBER, "注册会员");
        map.put(BANK, "银行卡支付会员");
        map.put(FANS, "微信粉丝会员");
        map.put(ALIPAY, "支付宝会员");
        map.put(MAC, "mac会员");
        map.put(IDFA, "idfa会员");
        map.put(IMEI, "imei会员");
        map.put(FANS_PAYMENT, "微信支付会员");
        map.put(ALIPAY_PAYMENT, "支付宝支付会员");
        map.put(MINI_PROGRAM_FANS, "微信小程序会员");

    }
    /**
     * 存储目前的类型信息
     */
    private int flag;

    public CustomerType(){}

    public CustomerType(int flag){
        this.flag = flag;
    }


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * 重新设置泛会员类型
     */
    public void setType(int customerType) {
        flag = customerType;
    }

    /**
     * 添加一项或多项泛会员类型
     */
    public void addType(int customerType) {
        flag |= customerType;
    }

    /**
     * 删除一项或多项泛会员类型
     */
    public void delType(int customerType) {
        flag &= ~customerType;
    }

    /**
     * 是否拥某些泛会员类型
     */
    public boolean isExist(int customerType) {
        return (flag & customerType) == customerType;
    }
    /**
     * @Description: 是否支付会员
     * @Param: []
     * @return: boolean
     * @Author: jinjianjun
     * @Date: 2018/7/16
    */
    public boolean isPaymentCustomer(){
        return  (flag & BANK) == BANK ||
                (flag & FANS_PAYMENT) == FANS_PAYMENT ||
                (flag & ALIPAY_PAYMENT) == ALIPAY_PAYMENT;
    }

    /**
     * @Description: 是否感知会员
     * @Param: []
     * @return: boolean
     * @Author: jinjianjun
     * @Date: 2018/7/16
     */
    public boolean isApperceiveCustomer(){
        return  (flag & MAC) == MAC ||
                (flag & IDFA) == IDFA ||
                (flag & IMEI) == IMEI;
    }

    /**
     * 是否不拥有某些泛会员类型
     */
    public boolean isNotExist(int customerType) {
        return (flag & customerType) == 0;
    }

    /**
     * 是否仅仅拥有某些权限
     */
    public boolean isOnlyExist(int customerType) {
        return flag == customerType;
    }

    /**
     * 将会员类型转换成10位二进制字符串形式
     * @param customerType
     * @return
     */
    public String toBinaryString(int customerType){

        String binaryStr = Integer.toBinaryString(customerType);
        if(binaryStr.length()<10){
            for(int i=binaryStr.length();i<10;i++){
                binaryStr="0"+binaryStr;
            }
        }
        return binaryStr;
    }

    /**
     * 将会员类型转换成中文字符串形式,会员类型之间以,隔开
     * @return
     */
    public String toCN(){

        StringBuilder customerCN = new StringBuilder();

        map.forEach((key,val)->{
            if(this.isExist(key)){
                customerCN.append(val).append(",");
            }
        });
        String customerCNStr = customerCN.toString();
        if(StringUtils.isNotEmpty(customerCNStr)){
            customerCNStr = customerCNStr.substring(0,customerCNStr.lastIndexOf(","));
        }

        return customerCNStr;
    }

    public static void main(String[] args) {

        CustomerType customerType = new CustomerType();
        customerType.addType(MEMBER);
        customerType.addType(ALIPAY);
        customerType.addType(MAC);
        System.out.println("支付 = [" + customerType.isPaymentCustomer() + "]");
        System.out.println("感知 = [" + customerType.isApperceiveCustomer() + "]");
        System.out.println("=========================================================");
        customerType.addType(FANS_PAYMENT);
        customerType.delType(MAC);
        System.out.println("支付 = [" + customerType.isPaymentCustomer() + "]");
        System.out.println("感知 = [" + customerType.isApperceiveCustomer() + "]");


    }

}
