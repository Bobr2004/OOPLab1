package entity;

import java.util.HashMap;
import java.util.Map;

public class Taxman extends Human {

    public Taxman(String name) {
        super(name);
    }

    @Override
    public void declareSocialStatus(){
        System.out.println("I am the one who legally steals your money🤑😈");
    }

    public TaxReport countTax(Client client, TaxList tax) {

        float taxedMainIncome = client.getMainIncome() * tax.mainIncomeTax();

        float taxedAdditionalIncome = client.getAdditionalIncome() * tax.additionalIncomeTax();

        float taxedRewards = client.getRewards() * tax.rewardsTax();

        float taxedSalesIncome = client.getSalesIncome() * tax.salesIncomeTax();

        float taxedForeignTransactionsIncome = client.getForeignTransactionsIncome() * tax.foreignTransactionsIncomeTax();

        Map<String,Float> report = new HashMap<>();

        float taxSum = taxedMainIncome + taxedAdditionalIncome + taxedRewards + taxedSalesIncome + taxedForeignTransactionsIncome;

        report.put("MainIncomeTax",taxedMainIncome);
        report.put("AdditionalIncomeTax",taxedAdditionalIncome);
        report.put("RewardsTax",taxedRewards);
        report.put("SalesIncomeTax",taxedSalesIncome);
        report.put("ForeignTransactionsIncomeTax",taxedForeignTransactionsIncome);
        report.put("GiftedIncome",client.getGiftedIncome());
        report.put("ChildrenPrivilegeIncome",client.getChildrenPrivilege());
        report.put("GovernmentRewardsIncome",client.getGovernmentRewards());
        report.put("TaxSum", taxSum);


        return new TaxReport(report);
    }

}
