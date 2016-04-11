package builder;

import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by antonyvol on 11.04.16.
 */
public class CarFormBuilder {
    final static String TEXTBOX_LENGTH = "220";
    private FormPanel form;
    private VerticalPanel vpanel;

    public CarFormBuilder() {
        form = new FormPanel();
        vpanel = new VerticalPanel();

        vpanel.add(setFormRow("Car model"));
        vpanel.add(setFormRow("Car regpalte"));
        vpanel.add(setFormRow("Car year"));
        vpanel.add(setFormRow("Car price"));

        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        form.setWidget(vpanel);
        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                // validation goes here
            }
        });
        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // code goes here
            }
        });

        // add rootpanel code
    }

    TextBox setFormRow(String str) {
        TextBox tb = new TextBox();
        tb.setWidth(TEXTBOX_LENGTH);
        tb.getElement().setPropertyString("placeholder", str);
        return tb;
    }
}
