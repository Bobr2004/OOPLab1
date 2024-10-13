

import entity.Client;
import entity.TaxList;
import entity.Taxman;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaxingTests {
    @Test 
    public void polymorphismTest(){
        Client client = new Client("TestOleg");

        Taxman taxman = new Taxman("TestAnton");

        boolean differentSocialStatus = !client.getSocialStatus().equals(taxman.getSocialStatus());

        
        assertTrue(differentSocialStatus);
    }

    @Test
    public void taxingTest() {
        Client client = new Client("TestOleg");
        client.setForeignTransactionsIncome(100);
        client.setAdditionalIncome(30000);
        client.setGovernmentRewards(0);
        client.setChildrenPrivilege(0);
        client.setMainIncome(1000000);
        client.setGiftedIncome(1703);
        client.setRewards(10000);
        client.setSalesIncome(100);

        Taxman taxman = new Taxman("taxmanTest");

        TaxList taxes = new TaxList(
                0.1f,
                0.05f,
                0.01f,
                0.1f,
                0.01f);

        Map<String, Float> report = taxman.countTax(client, taxes).getValues();

        boolean mainTax = (client.getMainIncome() * taxes.mainIncomeTax() == report.get("MainIncomeTax"));
        boolean additionalTax = (client.getAdditionalIncome() * taxes.additionalIncomeTax() == report.get("AdditionalIncomeTax"));
        boolean rewardsTax = (client.getRewards() * taxes.rewardsTax() == report.get("RewardsTax"));
        boolean transactionTax = (client.getForeignTransactionsIncome() * taxes.foreignTransactionsIncomeTax() == report.get("ForeignTransactionsIncomeTax"));
        boolean salesTax = (client.getSalesIncome() * taxes.salesIncomeTax() == report.get("SalesIncomeTax"));
        assertTrue(mainTax);
        assertTrue(additionalTax);
        assertTrue(rewardsTax);
        assertTrue(transactionTax);
        assertTrue(salesTax);

    }
}
