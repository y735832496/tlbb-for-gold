package com.model;

import java.util.Random;

/**
 * 可抽奖状态
 */
public class CanRaffleState extends State{

    private RaffleActicity raffleActicity;

    public CanRaffleState(RaffleActicity raffleActicity) {
        this.raffleActicity = raffleActicity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("已支付完毕");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖请稍后...");
        Random r = new Random();
        int num = r.nextInt(10);
        if(num == 0){
            raffleActicity.setState(raffleActicity.getDispenseState());
            return true;
        }else{
            raffleActicity.setState(raffleActicity.getNoRaffleState());
            System.out.println("很遗憾，没有抽中");
            return false;
        }
    }

    //发放奖品，不能
    @Override
    public void dispensePrize() {
        System.out.println("没中奖！不能发放奖品");
    }
}
