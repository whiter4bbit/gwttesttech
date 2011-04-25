package info.whiter4bbit.gwt.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface ExpenseRemoveEventHandler extends EventHandler {
    void onRemove(ExpenseRemoveEvent event);
}
