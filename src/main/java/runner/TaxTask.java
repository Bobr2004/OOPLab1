package runner;


import entity.Client;
import entity.TaxList;
import entity.TaxReport;
import entity.Taxman;

public class TaxTask {
    private static Client initClient(String name) {
        Client client = new Client(name);
        client.setForeignTransactionsIncome(100);
        client.setAdditionalIncome(30000);
        client.setGovernmentRewards(0);
        client.setChildrenPrivilege(0);
        client.setMainIncome(1000000);
        client.setGiftedIncome(1703);
        client.setSalesIncome(100);
        client.setRewards(10000);

        return client;
    }

    private static Taxman initTaxman(String name) {
        return new Taxman(name);
    }

    public static void main(String[] args) {
        Client client = initClient("Oleg");
        Taxman taxman = initTaxman("Anton");
        TaxList taxesRates = new TaxList(
                0.2f,
                0.2f,
                0.01f,
                0.1f,
                0.01f);

        TaxReport report = taxman.countTax(client, taxesRates);



        // Polymorphism example
        System.out.println("-------Polymorphism---------");
        client.declareSocialStatus();
        taxman.declareSocialStatus();
        System.out.println("-----------------------");



        // Sorting example
        System.out.println("-------Sorting---------");
        report.displayAsc();
        System.out.println("-----------------------");
        report.displayDesc();
    }
}
