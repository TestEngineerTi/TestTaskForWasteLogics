import DataModel.Dataset;
import Utilites.JsonUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.*;

public class FirstTest extends BaseTest {

    String expectedAddress = expectedInvoiceAddress.street
            + ", "
            + expectedInvoiceAddress.town
            + ", "
            + expectedInvoiceAddress.postCode;

    String orderId = "146566";


    public FirstTest() {
        super(JsonUtils.readConfigurationResource(
                "TestData/TestDataForFirstTest.json",
                Dataset.class));
    }

    @Test
    @DisplayName("Check that results page contains valid data for 146566 record")
    public void firstTest() {
        openSearchPage();

        invoiceSearch.invoiceAddress(orderId)
                .shouldBe(visible, ofSeconds(5))
                .scrollIntoView(true);

        invoiceSearch.invoiceAddress(orderId)
                .shouldHave(exactTextCaseSensitive(expectedAddress), ofSeconds(5));

        invoiceSearch.grade(orderId)
                .shouldHave(exactTextCaseSensitive(expectedGrade), ofSeconds(5));

        invoiceSearch.company(orderId)
                .shouldHave(exactTextCaseSensitive(expectedCompanyName), ofSeconds(5));

        invoiceSearch.weight(orderId)
                .shouldHave(exactTextCaseSensitive(expectedWeight), ofSeconds(5));

        invoiceSearch.flatChargePrice(orderId)
                .shouldHave(exactTextCaseSensitive(expectedPriceEntity.flatCharge), ofSeconds(5));

        invoiceSearch.perTonnePrice(orderId)
                .shouldHave(exactTextCaseSensitive(expectedPriceEntity.perTonne), ofSeconds(5));

        invoiceSearch.itemPrice(orderId)
                .shouldHave(exactTextCaseSensitive(expectedPriceEntity.totalPrice), ofSeconds(5));
    }
}
