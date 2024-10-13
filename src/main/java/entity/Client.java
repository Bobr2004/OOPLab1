package entity;

public class Client extends Human {

    private float mainIncome = 0;

    private float additionalIncome = 0;

    private float rewards = 0;

    private float salesIncome = 0;

    private float giftedIncome = 0;

    private float foreignTransactionsIncome = 0;

    private float childrenPrivilege = 0;

    private float governmentRewards = 0;

    public Client(String name) {
        super(name);
    }

    @Override
    public void declareSocialStatus(){
        System.out.println("My name is " + this.name + " and I am forced to pay taxes😭");
    }

    public void setMainIncome(float mainIncome) {
        this.mainIncome = mainIncome;
    }

    public void setAdditionalIncome(float additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public void setRewards(float rewards) {
        this.rewards = rewards;
    }

    public void setSalesIncome(float salesIncome) {
        this.salesIncome = salesIncome;
    }

    public void setGiftedIncome(float giftedIncome) {
        this.giftedIncome = giftedIncome;
    }

    public void setForeignTransactionsIncome(float foreignTransactionsIncome) {
        this.foreignTransactionsIncome = foreignTransactionsIncome;
    }

    public void setChildrenPrivilege(float childrenPrivilege) {
        this.childrenPrivilege = childrenPrivilege;
    }

    public void setGovernmentRewards(float governmentRewards) {
        this.governmentRewards = governmentRewards;
    }

    public float getMainIncome() {
        return mainIncome;
    }

    public float getAdditionalIncome() {
        return additionalIncome;
    }

    public float getRewards() {
        return rewards;
    }

    public float getSalesIncome() {
        return salesIncome;
    }

    public float getGiftedIncome() {
        return giftedIncome;
    }

    public float getForeignTransactionsIncome() {
        return foreignTransactionsIncome;
    }

    public float getChildrenPrivilege() {
        return childrenPrivilege;
    }

    public float getGovernmentRewards() {
        return governmentRewards;
    }
}
