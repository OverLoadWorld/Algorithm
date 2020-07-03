package jvm.heap;

/**
 * -XX:+PrintFlagsInitial  所有参数默认初始值
 * -XX:+PrintFlagsFinal  所有参数最终值，存在修改
 * -Xms 初始堆空间内存  默认物理内存的 1/64
 * -Xms 最大堆空间内存  默认物理内存的 1/4
 * -Xmn 设置新生代大小  ，初始值就是最大值
 * -XX:NewRatio 配置新生代与老年代在堆结构的占比
 * -XX:SurvivorRatio  设置心新生带中eden和s0 s1空间比例
 * -XX:MaxTenuringThreshold: 设置新生带垃圾的最大年龄
 * -XX:+PrintGCDetails 输出详细的GC处理日志
 * 打印gc简要信息：-XX:PrintGC  -verbose:gc
 * -XX:HandlePromotionFailure  是否设置空间担保
 */
public class HeapArgsTest {
    public static void main(String[] args) {

    }
}
