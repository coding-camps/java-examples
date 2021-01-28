package lang.thread.demo02.solution1;

import lang.thread.demo02.biz.ChuJu;
import lang.thread.demo02.biz.ShiCai;

public class App {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        cookprogress();
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime - startTime) + " ms.");
    }

    private static void cookprogress() throws InterruptedException {
        ShopChuju chujuThread = new ShopChuju();
        ShopShicai shicaiThread = new ShopShicai();

        shicaiThread.start();
        shicaiThread.join();

        chujuThread.start();
        chujuThread.join();

        ChuJu chuju = chujuThread.getChuju();
        ShiCai shicai = shicaiThread.getSchicai();
        chuju.cook(shicai);
    }
}
