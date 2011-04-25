package info.whiter4bbit.gwt.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface AddExpenseHandler extends EventHandler {
    void onAdd(AddExpenseEvent event);
}
