package jvm.heap;

/**
 * new 的对象实体，不是变量是否在方法外使用
 */
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    /**
     * 发生
     * @return
     */
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    /**
     * 发生
     */
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }

    /**
     * 不发生
     */
    public void userE() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /**
     * 发生
     */
    public void userE1() {
        EscapeAnalysis e = getInstance();
    }
}
