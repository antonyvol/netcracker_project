package builder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import client.OwnerAddService;
import client.OwnerAddServiceAsync;
import server.OwnerAddServiceImpl;

/**
 * Created by antonyvol on 12.04.16.
 */
public class OwnerFormBuilder {
    final String TEXTBOX_LENGTH = "220";
    private FormPanel form;
    private VerticalPanel vpanel;
    private Button button;

    public OwnerFormBuilder() {
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
        vpanel.add(setFormRow("Owner firstname"));
        vpanel.add(setFormRow("Owner lastname"));
        vpanel.add(setFormRow("Owner car"));
        vpanel.add(button);

        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        form.setWidget(vpanel);
        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                // validation goes here
                OwnerAddServiceAsync addSvc = GWT.create(OwnerAddService.class);
                addSvc.update(new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {

                    }

                    @Override
                    public void onSuccess(Void result) {
                        Window.alert("Owner added!");
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

    private TextBox setFormRow(String str) {
        TextBox tb = new TextBox();
        tb.setWidth(TEXTBOX_LENGTH);
        tb.getElement().setPropertyString("placeholder", str);
        return tb;
    }

    public FormPanel getForm() {
        return form;
    }
}
