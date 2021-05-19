package com.model;

public abstract class State {
    //扣钱
    public abstract void deduceMoney();
    //是否中奖
    public abstract boolean raffle();
    // 发放奖品
    public abstract void dispensePrize();


}
