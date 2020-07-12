package com.wufeng.WKbatis.v2.plugin.myPlugin.v1;


public class V1Test {
    public static void main(String[] args) {
        IntecepteChain intecepteChain = new IntecepteChain();
        intecepteChain.addIntecepe(new SimplePlugin());
        intecepteChain.addIntecepe(new SimplePlugin2());

        Handler handler = (Handler) intecepteChain.pluginAll(new ExplicitHandler());
        handler.handle();
    }
}
