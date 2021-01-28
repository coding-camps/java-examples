package lang.thread.demo02.solution2;

import lang.thread.demo02.biz.ChuJu;

import java.util.concurrent.Callable;

import static lang.thread.demo02.biz.BizMocker.mockStep;

public class ShopChuju implements Callable<ChuJu> {

    @Override
    public ChuJu call() throws Exception {
        String name = "shopping-chuju";
        Thread.currentThread().setName(name);
        mockStep(name, 1, "1. 下单");
        mockStep(name, 1, "2. 邮寄");
        mockStep(name, 1, "3. 收货");
        return new ChuJu();
    }

}
