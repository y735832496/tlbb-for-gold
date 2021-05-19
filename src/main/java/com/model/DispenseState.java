package com.model;

/**
 * 已中奖，发放奖品中
 */
public class DispenseState extends State{
    private RaffleActicity raffleActicity;

    public DispenseState(RaffleActicity raffleActicity) {
        this.raffleActicity = raffleActicity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("已支付，等待发奖");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        if(raffleActicity.getCount()>0){
            System.out.println("恭喜中奖！");
            raffleActicity.setState(raffleActicity.getNoRaffleState());
        }
        else{
            System.out.println("很遗憾，奖品发完了");
            raffleActicity.setState(raffleActicity.getDispenseOutState());
        }
    }
}
