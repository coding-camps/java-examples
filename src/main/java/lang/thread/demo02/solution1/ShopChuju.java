package lang.thread.demo02.solution1;

import lang.thread.demo02.biz.ChuJu;

import static lang.thread.demo02.biz.BizMocker.mockStep;

public class ShopChuju extends Thread {

    private ChuJu chuju;

    public ChuJu getChuju() {
        return chuju;
    }

    @Override
    public void run() {
        String who = "厨具购买者";
        Thread.currentThread().setName(who);
        mockStep(who, 1, "1. 下单");
        mockStep(who, 1, "2. 邮寄");
        mockStep(who, 1, "3. 收货");
        this.chuju = new ChuJu();
    }
}
