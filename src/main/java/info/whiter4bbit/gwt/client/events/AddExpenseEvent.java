package info.whiter4bbit.gwt.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class AddExpenseEvent extends GwtEvent<AddExpenseHandler> {

    public static final Type<AddExpenseHandler> TYPE = new Type<AddExpenseHandler>();

    @Override
    public Type<AddExpenseHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddExpenseHandler handler) {
        handler.onAdd(this);
    }
}
