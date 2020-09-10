package com.example.delivery_fit.Entity;

public class TipsEntity {
    String tipsRupee;
    int foodIcon;

    public TipsEntity(String tipsRupee, int foodIcon) {
        this.tipsRupee = tipsRupee;
        this.foodIcon = foodIcon;
    }

    public String getTipsRupee() {
        return tipsRupee;
    }

    public void setTipsRupee(String tipsRupee) {
        this.tipsRupee = tipsRupee;
    }

    public int getFoodIcon() {
        return foodIcon;
    }

    public void setFoodIcon(int foodIcon) {
        this.foodIcon = foodIcon;
    }

    @Override
    public String toString() {
        return "TipsEntity{" +
                "tipsRupee='" + tipsRupee + '\'' +
                ", foodIcon=" + foodIcon +
                '}';
    }
}
