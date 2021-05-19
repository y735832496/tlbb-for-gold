package com.model;

/**
 * 不能抽奖状态
 */
public class NoRaffleState  extends State{
    private RaffleActicity raffleActicity;

    public NoRaffleState(RaffleActicity raffleActicity) {
        this.raffleActicity = raffleActicity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("扣钱成功 金额-50");
        raffleActicity.setState(raffleActicity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("需要交钱才能抽奖！");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("当前状态不能发放奖品");
    }
}
