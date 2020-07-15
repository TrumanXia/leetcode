package mybatis.plugin.myPlugin.v1;

public class ExplicitHandler implements Handler {
    @Override
    public void handle() {
        System.out.println("simple handle");
    }
}
