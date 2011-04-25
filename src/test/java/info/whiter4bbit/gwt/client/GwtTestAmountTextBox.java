package info.whiter4bbit.gwt.client;

import com.google.gwt.junit.client.GWTTestCase;

public class GwtTestAmountTextBox extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "info.whiter4bbit.gwt.SampleTestProject";
    }

    public void testSetExpense() {
        AmountTextBox amount = new AmountTextBox();
        amount.setText("28289.21");
        assertEquals("28289.21", amount.getText());
        amount.setText("1234,21");
        assertEquals("28289.21", amount.getText());
    }
}
