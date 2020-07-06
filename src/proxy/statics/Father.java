package proxy.statics;

public class Father {
    private Son proxyee;

    public Father(Son proxyee) {
        this.proxyee = proxyee;
    }

    public void searchGirl() {
        System.out.println("qian");
        proxyee.searchGirl();
        System.out.println("hou");
    }

}
