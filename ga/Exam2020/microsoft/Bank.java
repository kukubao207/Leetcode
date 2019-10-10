package Exam2020.microsoft;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    //把所有用户账号的锁存在一个map里面，key为用户的id,value为这个用户的钱款锁
    private Map<String, Lock> lockMap = new ConcurrentHashMap<>();
    //把所有用户账号和他的余额放在一个map里面，key为用户的id,value为这个用户的存款余额
    private Map<String, Integer> moneyMap = new ConcurrentHashMap<>();

    //存钱
    public void addMoney(String userid, int money) {
        //拿到这个用户账号的锁
        if (lockMap.get(userid) == null) {
            lockMap.put(userid, new ReentrantLock());
        }
        Lock lock = lockMap.get(userid);
        //上锁
        lock.lock();
        try {
            int currentMoney = moneyMap.get(userid);
            moneyMap.put(userid, currentMoney + money);
            System.out.println("存入钱" + money);
        } catch (Exception e) {
            System.out.println(e);
        } finally {//解锁 必须释放
            lock.unlock();
        }
    }

    //取钱
    public void subMoney(String userid, int money) {
        //拿锁
        if (lockMap.get(userid) == null) {
            lockMap.put(userid, new ReentrantLock());
        }
        Lock lock = lockMap.get(userid);
        //上锁
        lock.lock();
        try {
            int currentMoney = moneyMap.get(userid);
            if (currentMoney - money < 0) {//余额不足
                System.out.println("余额不足");
                return;
            } else {
                moneyMap.put(userid, currentMoney - money);
                System.out.println("取出钱" + money);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {//解锁 必须释放
            lock.unlock();
        }
    }

}