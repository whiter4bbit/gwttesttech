package info.whiter4bbit.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;
import info.whiter4bbit.gwt.client.data.ExpensesDataProvider;
import info.whiter4bbit.gwt.client.events.AddExpenseEvent;
import info.whiter4bbit.gwt.client.events.AddExpenseHandler;
import info.whiter4bbit.gwt.shared.Expense;

public class BudgetPresenter {
    private BudgetView budgetView;
    private ExpensesDataProvider dataProvider;

    public BudgetPresenter(ExpensesDataProvider dataProvider, BudgetView budgetView) {
        this.dataProvider = dataProvider;
        this.budgetView = budgetView;

        this.dataProvider.bind(budgetView.getTable());
        addHandlers();
    }

    private void addHandlers() {
        this.budgetView.getAddButton().addClickHandler(new ClickHandler() {
            public void onClick(final ClickEvent event) {
                final ExpensePanel expensePanel = budgetView.showExpensePanel();
                expensePanel.addAddExpenseHandler(new AddExpenseHandler() {
                    @Override
                    public void onAdd(AddExpenseEvent event) {
                        final String description = expensePanel.getDescription();
                        final Float amount = Float.parseFloat(expensePanel.getAmount());
                        dataProvider.add(new Expense(description, "", amount));
                    }
                });
            }
        });
    }

    public void go(HasWidgets panel) {
        SimplePanel viewContainer = new SimplePanel();
        viewContainer.setWidget(budgetView);
        panel.add(viewContainer);
    }
}
