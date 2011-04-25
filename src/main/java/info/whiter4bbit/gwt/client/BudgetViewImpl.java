package info.whiter4bbit.gwt.client;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.HasData;
import info.whiter4bbit.gwt.client.events.ExpenseRemoveEvent;
import info.whiter4bbit.gwt.shared.Expense;


public class BudgetViewImpl extends Composite implements BudgetView {
    interface BudgetViewImplUiBinder extends UiBinder<VerticalPanel, BudgetViewImpl> {
    }

    private static BudgetViewImplUiBinder ourUiBinder = GWT.create(BudgetViewImplUiBinder.class);

    @UiField
    CellTable<Expense> cellTable;

    @UiField
    Button addExpense;

    public BudgetViewImpl() {
        VerticalPanel rootElement = ourUiBinder.createAndBindUi(this);
        initWidget(rootElement);
    }

    @UiFactory
    public CellTable<Expense> createCellTable() {
        final CellTable<Expense> table = new CellTable<Expense>();
        table.addColumn(new TextColumn<Expense>() {
            @Override
            public String getValue(Expense object) {
                return object.getDescription();
            }
        }, "Description");
        table.addColumn(new TextColumn<Expense>() {
            @Override
            public String getValue(Expense object) {
                return String.valueOf(object.getAmount());
            }
        }, "Amount");
        Column<Expense, String> removeColumn = new Column<Expense, String>(new ClickableTextCell()) {
            @Override
            public String getValue(Expense object) {
                return "Remove";
            }
        };
        table.addColumn(removeColumn);
        removeColumn.setFieldUpdater(new FieldUpdater<Expense, String>() {
            @Override
            public void update(int index, Expense object, String value) {
                fireEvent(new ExpenseRemoveEvent(index));
            }
        });
        return table;
    }

    public HasData<Expense> getTable() {
        return cellTable;
    }

    public HasClickHandlers getAddButton() {
        return addExpense;
    }

    public ExpensePanel showExpensePanel() {
        AddExpensePanel panel = new AddExpensePanel();
        panel.center();
        panel.show();
        return panel;
    }
}