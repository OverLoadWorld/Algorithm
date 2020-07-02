package jvm.operatestack;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/30 17:39
 */
public class OperationStackTest {

    public void testAddOperation(){
        byte i = 15;
        int j = 8;
        int k = i + j;
        //int m = 800;
        /**
         *
         *  0 bipush 15     15压入操作数栈
         *  2 istore_1      操作数栈中15，弹出，放在索引为1的局部变量表位置， 0放着this
         *  3 bipush 8      8压入操作数栈
         *  5 istore_2      操作数栈中15，弹出，放在索引为2的局部变量表位置
         *  6 iload_1       从局部变量表总索引为1 的数字取出，到操作数栈中
         *  7 iload_2       从局部变量表总索引为2 的数字取出，到操作数栈中
         *  8 iadd          执行引擎 iadd 将两个数字做加和 23
         *  9 istore_3      操作数栈中23，弹出，放在索引为3的局部变量表位置
         * 10 return
         *
         */
    }

    public  int getSum() {
        int a = 10;
        int b = 20;
        return a + b;
    }

    public void testGetSum() {
        int i = getSum();
        int j = 10;
    }
}
