package info.whiter4bbit.gwt.client.data;

import com.google.gwt.view.client.HasData;
import info.whiter4bbit.gwt.shared.Expense;

public interface ExpensesDataProvider {
    void bind(HasData<Expense> table);
    void add(Expense expense);
}
