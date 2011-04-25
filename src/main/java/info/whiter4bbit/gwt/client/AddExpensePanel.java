package info.whiter4bbit.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.whiter4bbit.gwt.client.events.AddExpenseEvent;
import info.whiter4bbit.gwt.client.events.AddExpenseHandler;

public class AddExpensePanel extends PopupPanel implements ExpensePanel {
    interface AddExpensePanelUiBinder extends UiBinder<VerticalPanel, AddExpensePanel> {
    }

    private static AddExpensePanelUiBinder ourUiBinder = GWT.create(AddExpensePanelUiBinder.class);

    @UiField
    TextBox description;

    @UiField
    AmountTextBox amount;

    @UiField
    Button addButton;

    @UiField
    Button cancelButton;

    public AddExpensePanel() {
        VerticalPanel rootElement = ourUiBinder.createAndBindUi(this);
        setWidget(rootElement);
    }

    @UiHandler("addButton")
    public void handleAdd(ClickEvent event) {
        hide();
        fireEvent(new AddExpenseEvent());
    }

    @UiHandler("cancelButton")
    public void handleCancel(ClickEvent event) {
        hide();
    }

    @Override
    public String getAmount() {
        return amount.getText();
    }

    @Override
    public String getDescription() {
        return description.getText();
    }

    @Override
    public void addAddExpenseHandler(AddExpenseHandler handler) {
        addHandler(handler, AddExpenseEvent.TYPE);
    }
}