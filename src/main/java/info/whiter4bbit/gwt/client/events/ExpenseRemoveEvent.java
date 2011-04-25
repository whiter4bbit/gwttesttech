package info.whiter4bbit.gwt.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class ExpenseRemoveEvent extends GwtEvent<ExpenseRemoveEventHandler> {

    public static final Type<ExpenseRemoveEventHandler> TYPE = new Type<ExpenseRemoveEventHandler>();

    private int index;

    public ExpenseRemoveEvent(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Type<ExpenseRemoveEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ExpenseRemoveEventHandler handler) {
        handler.onRemove(this);
    }
}
