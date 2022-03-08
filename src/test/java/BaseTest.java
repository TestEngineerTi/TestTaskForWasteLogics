import DataModel.*;

public abstract class BaseTest {

    protected final Dataset data;

    protected final String expectedCompanyName;
    protected final String expectedGrade;
    protected final invoiceAddress expectedInvoiceAddress;
    protected final String expectedWeight;
    protected final PriceEntity expectedPriceEntity;

    public BaseTest(Dataset data) {
        this.data = data;

        expectedCompanyName = data.company;
        expectedGrade = data.grade;
        expectedInvoiceAddress = data.invoiceAddress;
        expectedWeight = data.weight;
        expectedPriceEntity = data.priceEntity;
    }
}
