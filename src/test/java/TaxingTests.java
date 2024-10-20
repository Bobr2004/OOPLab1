

import entity.Client;
import entity.TaxList;
import entity.Taxman;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        Map<String, Float> expectedTaxes = Map.of(
    "MainIncomeTax", client.getMainIncome() * taxes.mainIncomeTax(),
    "AdditionalIncomeTax", client.getAdditionalIncome() * taxes.additionalIncomeTax(),
    "RewardsTax", client.getRewards() * taxes.rewardsTax(),
    "ForeignTransactionsIncomeTax", client.getForeignTransactionsIncome() * taxes.foreignTransactionsIncomeTax(),
    "SalesIncomeTax", client.getSalesIncome() * taxes.salesIncomeTax()
);

expectedTaxes.forEach((taxType, expectedValue) -> {
    double actualValue = report.get(taxType);
    assertEquals(expectedValue, actualValue, 0.0001, taxType + " comparison failed."); // Adjust delta if necessary
});

    }
}
