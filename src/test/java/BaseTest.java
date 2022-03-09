import DataModel.*;
import Page.InvoiceSearch;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    protected final Dataset data;

    protected final String expectedCompanyName;
    protected final String expectedGrade;
    protected final invoiceAddress expectedInvoiceAddress;
    protected final String expectedWeight;
    protected final PriceEntity expectedPriceEntity;

    InvoiceSearch invoiceSearch = new InvoiceSearch();

    public BaseTest(Dataset data) {
        this.data = data;

        expectedCompanyName = data.company;
        expectedGrade = data.grade;
        expectedInvoiceAddress = data.invoiceAddress;
        expectedWeight = data.weight;
        expectedPriceEntity = data.priceEntity;
    }

    protected void openSearchPage() {
        String path = System.getProperty("user.dir");
        open("file:///" + path + "/src/test/resources/PageSource/CompanyInvoices.mht");
    }
}
