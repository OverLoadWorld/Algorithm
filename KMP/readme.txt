KMP算法:
KMP算法求解什么类型问题
字符串匹配。给你两个字符串，寻找其中一个字符串是否包含另一个字符串，如果包含，返回包含的起始位置。
    char *str = "bacbababadababacambabacaddababacasdsd";
    char *ptr = "ababaca";
    str有两处包含ptr 
    分别在str的下标10，26处包含ptr。
