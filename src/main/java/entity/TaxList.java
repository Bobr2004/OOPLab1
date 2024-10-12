package entity;

public record TaxList(float mainIncomeTax, float additionalIncomeTax, float rewardsTax, float salesIncomeTax,
                      float foreignTransactionsIncomeTax) {
}
