package proxy.gupao.com.gupao.vip.proxy.client;


/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
//        GpMeipo gpMeipo = new GpMeipo();
//        IPerson zhangsan = gpMeipo.getInstance(new Zhangsan());
//        zhangsan.findLove();

        GpMeipo gpMeipo = new GpMeipo();
        Animal zhangsan = gpMeipo.getInstance(new Dog());
        zhangsan.bark();
    }
}
