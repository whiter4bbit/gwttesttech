package info.whiter4bbit.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import info.whiter4bbit.gwt.client.data.ExpensesDataProviderImpl;

public class Main implements EntryPoint {

    public void onModuleLoad() {
        BudgetPresenter presenter = new BudgetPresenter(new ExpensesDataProviderImpl(), new BudgetViewImpl());
        presenter.go(RootPanel.get("mainPanel"));
    }

}
