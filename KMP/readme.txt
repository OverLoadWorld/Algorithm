KMP算法:
    1.KMP算法求解什么类型问题
        字符串匹配。给你两个字符串，寻找其中一个字符串是否包含另一个字符串，如果包含，返回包含的起始位置。
        char *str = "bacbababadababacambabacaddababacasdsd";
        char *ptr = "ababaca";
        str有两处包含ptr 
        分别在str的下标10，26处包含ptr。
    2.在匹配过程中一步重要的工作就是next数组的求解，next数组的求解代码就短短的几行，但是理解起来还得花费一点功夫，
      后续我会再补充next数组的详细解析，本例中的代码用F代表next数组，便于理解。          
