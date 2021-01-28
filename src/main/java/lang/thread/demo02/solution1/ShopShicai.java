package lang.thread.demo02.solution1;

import lang.thread.demo02.biz.ShiCai;

import static lang.thread.demo02.biz.BizMocker.mockStep;

public class ShopShicai extends Thread {

    private ShiCai shicai;

    public ShiCai getSchicai() {
        return shicai;
    }

    @Override
    public void run() {
        String who = "食材购买者";
        Thread.currentThread().setName(who);
        mockStep(who, 1, "1. 超市买食材");
        mockStep(who, 1, "2. 处理食材");
        this.shicai = new ShiCai();
    }

}
