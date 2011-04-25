package info.whiter4bbit.gwt.client;

import info.whiter4bbit.gwt.client.events.AddExpenseHandler;

public interface ExpensePanel extends HasUserData {
    void addAddExpenseHandler(AddExpenseHandler handler);
}
