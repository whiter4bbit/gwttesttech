package info.whiter4bbit.gwt.client.data;

import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import info.whiter4bbit.gwt.shared.Expense;

public class ExpensesDataProviderImpl implements ExpensesDataProvider {

    private ListDataProvider<Expense> dataProvider = new ListDataProvider<Expense>();

    @Override
    public void bind(HasData<Expense> table) {
        dataProvider.addDataDisplay(table);
    }

    @Override
    public void add(Expense expense) {
        dataProvider.getList().add(expense);
    }
}
