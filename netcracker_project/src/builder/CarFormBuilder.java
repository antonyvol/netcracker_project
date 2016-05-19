package builder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import server.CarAddServiceImpl;
import client.CarAddServiceAsync;
import client.CarAddService;

/**
 * Created by antonyvol on 11.04.16.
 */
public class CarFormBuilder {
    final String TEXTBOX_LENGTH = "220";
    private FormPanel form;
    private VerticalPanel vpanel;
    private Button button;

    public CarFormBuilder() {
        form = new FormPanel();
        vpanel = new VerticalPanel();
        button = new Button("Submit");

        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                form.submit();
            }
        });

        vpanel.setSpacing(10);
        vpanel.add(setFormRow("Car model", "model"));
        vpanel.add(setFormRow("Car regplate", "regplate"));
        vpanel.add(setFormRow("Car year", "year"));
        vpanel.add(setFormRow("Car price", "price"));
        vpanel.add(button);

        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_GET);
        form.setAction("CarAddService");
        form.setWidget(vpanel);
        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                // validation goes here
                CarAddServiceAsync addSvc = GWT.create(CarAddService.class);
                addSvc.update(new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {

                    }
                    @Override
                    public void onSuccess(Void result) {

                    }
                });
            }
        });
        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // code goes here
            }
        });
    }

    private TextBox setFormRow(String str, String name) {
        TextBox tb = new TextBox();
        tb.setWidth(TEXTBOX_LENGTH);
        tb.setName(name);
        tb.getElement().setPropertyString("placeholder", str);
        return tb;
    }

    public FormPanel getForm() {
        return form;
    }
}
