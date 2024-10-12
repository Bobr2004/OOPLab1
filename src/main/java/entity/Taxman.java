package entity;

import java.util.HashMap;
import java.util.Map;

public class Taxman extends Human {

    public Taxman(String name) {
        super(name);
    }

    public TaxReport countTax(Client client, TaxList tax) {

        float taxedMainIncome = client.getMainIncome() * tax.mainIncomeTax();

        float taxedAdditionalIncome = client.getAdditionalIncome() * tax.additionalIncomeTax();

        float taxedRewards = client.getRewards() * tax.rewardsTax();

        float taxedSalesIncome = client.getSalesIncome() * tax.salesIncomeTax();

        float taxedForeignTransactionsIncome = client.getForeignTransactionsIncome() * tax.foreignTransactionsIncomeTax();

        Map<String,Float> report = new HashMap<>();

        report.put("MainIncomeTax",taxedMainIncome);
        report.put("AdditionalIncomeTax",taxedAdditionalIncome);
        report.put("RewardsTax",taxedRewards);
        report.put("SalesIncomeTax",taxedSalesIncome);
        report.put("ForeignTransactionsIncomeTax",taxedForeignTransactionsIncome);
        report.put("GiftedIncome",client.getGiftedIncome());
        report.put("ChildrenPrivilegeIncome",client.getChildrenPrivilege());
        report.put("GovernmentRewardsIncome",client.getGovernmentRewards());


        return new TaxReport(report);
    }
}
