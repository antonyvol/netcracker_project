package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by antonyvol on 07.04.16.
 */
public class Client implements EntryPoint {
    public void onModuleLoad() {
        Label label = new Label("Hello Gleb!");
        RootPanel.get().add(label);
    }
}
