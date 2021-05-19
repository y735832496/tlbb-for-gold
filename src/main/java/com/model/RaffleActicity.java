package com.model;

public class RaffleActicity {
    private State state;
    private CanRaffleState canRaffleState = new CanRaffleState(this);
    private DispenseState dispenseState = new DispenseState(this);
    private DispenseOutState dispenseOutState = new DispenseOutState(this);
    private NoRaffleState noRaffleState = new NoRaffleState(this);
    private int count = 0;

    public RaffleActicity(int count) {
        this.state = new NoRaffleState(this);
        this.count = count;
    }
    //扣钱
    public void duductMoney(){
        state.deduceMoney();
    }
    //抽奖
    public void raffle(){
        if(state.raffle()){
            state.dispensePrize();
        }
    }
    public int getCount() {
        int countTemp= count;
        count--;
        return countTemp;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DispenseOutState getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(DispenseOutState dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }

    public CanRaffleState getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(CanRaffleState canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public NoRaffleState getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(NoRaffleState noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
