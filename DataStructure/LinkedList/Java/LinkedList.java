public class LinkedList{
    public static void main(String[] args){
        java.util.LinkedList<Object> param = new java.util.LinkedList<>();
        param.add("A");
        param.add("B");
        param.add("C");
        param.add("D");
        java.util.LinkedList<Object> ret = singleListReverse(param);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

    public static java.util.LinkedList singleListReverse(java.util.LinkedList<Object> p){
        if (p == null) {
            return null;
        }
        java.util.LinkedList<Object> ret = new java.util.LinkedList<>();
        while (!p.isEmpty()) {
            ret.push(p.removeFirst());
        }
        return ret;
    }
}