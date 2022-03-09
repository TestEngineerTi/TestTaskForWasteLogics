package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InvoiceSearch {

    public SelenideElement invoiceAddress(String orderId) {
        return $x(String.format("(//td[text()='%s']//following-sibling::td)[4]", orderId));
    }

    public SelenideElement grade(String orderId) {
        return $x(String.format("(//td[text()='%s']/../../following-sibling::tbody//tr//td[2])[1]", orderId));
    }

    public SelenideElement company(String orderId) {
        return $x(String.format("(//th[text()='Company'])[1]/../../../tbody[6]/tr/td[text()='%s']/../../../tbody[5]/tr/td[5]", orderId));
    }

    public SelenideElement weight(String orderId) {
        return $x(String.format("(//td[text()='%s']/../../following-sibling::tbody//tr//td[3])[1]", orderId));
    }

    public SelenideElement flatChargePrice(String orderId) {
        return $x(String.format("(//td[text()='%s']/../../following-sibling::tbody//tr//td[8])[1]", orderId));
    }

    public SelenideElement perTonnePrice(String orderId) {
        return $x(String.format("(//td[text()='%s']/../../following-sibling::tbody//tr//td[8])[2]", orderId));
    }

    public SelenideElement itemPrice(String orderId) {
        return $x(String.format("(//td[text()='%s']/../../following-sibling::tbody//tr//td[8])[3]", orderId));
    }
}
