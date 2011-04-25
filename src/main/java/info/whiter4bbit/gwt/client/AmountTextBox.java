package info.whiter4bbit.gwt.client;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;

public class AmountTextBox extends TextBox {

    private String previousText;

    public AmountTextBox() {
        super();
        this.previousText = getText();

        addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                String amount = getText() + event.getCharCode();
                try {
                    Float.parseFloat(amount);
                } catch (NumberFormatException e) {
                    event.preventDefault();
                }
            }
        });

    }

    @Override
    public void setText(String text) {
        try {
            Float.parseFloat(text);
            previousText = text;
            super.setText(text);
        } catch (NumberFormatException e) {
            super.setText(previousText);
        }
    }
}