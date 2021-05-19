package com.model;

/**
 * 抽奖活动结束
 */
public class DispenseOutState extends State{
    private RaffleActicity raffleActicity;

    public DispenseOutState(RaffleActicity raffleActicity) {
        this.raffleActicity = raffleActicity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("奖品发完了，无法扣钱");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发完了，无法抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发完了");
    }
}
