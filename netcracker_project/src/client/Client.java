package client;

import builder.CarFormBuilder;
import builder.OwnerFormBuilder;
import builder.TradeFormBuilder;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by antonyvol on 07.04.16.
 */
public class Client implements EntryPoint {
    public void onModuleLoad() {
        CarFormBuilder cb = new CarFormBuilder();
        OwnerFormBuilder ob = new OwnerFormBuilder();
        TradeFormBuilder tb = new TradeFormBuilder();

        RootPanel.get("car-form").add(cb.getForm());
        RootPanel.get("owner-form").add(ob.getForm());
        RootPanel.get("sell-form").add(tb.getForm());
    }
}
