import DataModel.Dataset;
import Utilites.JsonUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstTest extends BaseTest {

    InvoiceAddress invoiceAddress = new InvoiceAddress();
    PriceEntity priceEntity = new PriceEntity();

    String actualCompanyName = "TEST CUSTOMER";
    String actualGrade = "Mixed Municipal Waste";
    String actualWeight = "0.460 T";

    static class InvoiceAddress {
        String street = "TEST ADDRESS";
        String town = "TEST TOWN";
        String postCode = "111111";
    }

    static class PriceEntity {
        String flatCharge = "£100.00";
        String perTonne = "£4.60";
        String totalPrice = "110.00";
    }

    public FirstTest() {
        super(JsonUtils.readConfigurationResource(
                "TestData/TestDataForFirstTest.json",
                Dataset.class));
    }

    @Test
    public void firstTest() {
        assertThat(actualCompanyName).isEqualTo(expectedCompanyName);

        assertThat(actualGrade).isEqualTo(expectedGrade);

        assertThat(actualWeight).isEqualTo(expectedWeight);

        assertThat(invoiceAddress.postCode).isEqualTo(expectedInvoiceAddress.postCode);
        assertThat(invoiceAddress.street).isEqualTo(expectedInvoiceAddress.street);
        assertThat(invoiceAddress.town).isEqualTo(expectedInvoiceAddress.town);

        assertThat(priceEntity.flatCharge).isEqualTo(expectedPriceEntity.flatCharge);
        assertThat(priceEntity.perTonne).isEqualTo(expectedPriceEntity.perTonne);
        assertThat(priceEntity.totalPrice).isEqualTo(expectedPriceEntity.totalPrice);
    }
}
