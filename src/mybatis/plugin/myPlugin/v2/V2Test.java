package com.wufeng.WKbatis.v2.plugin.myPlugin.v2;

import com.wufeng.WKbatis.v2.plugin.myPlugin.v1.*;

/**
 * @author 97994
 * @since 2020-07-11
 */
public class V2Test {
    public static void main(String[] args) {
        IntecepteChainV2 intecepteChain = new IntecepteChainV2();
        intecepteChain.addIntecepe(new SimplePluginV2());
        intecepteChain.addIntecepe(new SimplePluginV22());

        Handler handler = (Handler) intecepteChain.pluginAll(new ExplicitHandler());
        handler.handle();
    }
}
