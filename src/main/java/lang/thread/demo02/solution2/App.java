package lang.thread.demo02.solution2;

import lang.thread.demo02.biz.ChuJu;
import lang.thread.demo02.biz.ShiCai;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        cookprogress();
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime - startTime) + " ms.");
    }

    private static void cookprogress() throws InterruptedException, ExecutionException {
        FutureTask<ChuJu> chujuTask = new FutureTask<>(new ShopChuju());
        FutureTask<ShiCai> shicaiTask = new FutureTask<>(new ShopShicai());
        new Thread(chujuTask).start();
        new Thread(shicaiTask).start();

        if (!chujuTask.isDone()) {
            System.out.println("厨具未到，请稍等！");
        }
        if (!shicaiTask.isDone()) {
            System.out.println("食材未准备好，请等待一下。");
        }

        ChuJu chuju = chujuTask.get();
        ShiCai shicai = shicaiTask.get();
        chuju.cook(shicai);
    }
}
