package info.whiter4bbit.gwt.client;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;
import info.whiter4bbit.gwt.shared.Expense;

public interface BudgetView extends IsWidget {
    HasData<Expense> getTable();
    HasClickHandlers getAddButton();
    ExpensePanel showExpensePanel();
}
