package lang.thread.demo02.solution2;

import lang.thread.demo02.biz.ShiCai;

import java.util.concurrent.Callable;

import static lang.thread.demo02.biz.BizMocker.mockStep;

public class ShopShicai implements Callable<ShiCai> {

    @Override
    public ShiCai call() throws Exception {
        String name = "shopping-shicai";
        Thread.currentThread().setName(name);
        mockStep(name, 1, "1. 超市买食材");
        mockStep(name, 1, "2. 处理食材");
        return new ShiCai();
    }


}
