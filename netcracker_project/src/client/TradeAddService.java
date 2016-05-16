package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by Антон on 14.05.2016.
 */
@RemoteServiceRelativePath("TradeAddService")
public interface TradeAddService extends RemoteService {
    void update();
    /**
     * Utility/Convenience class.
     * Use TradeAddService.App.getInstance() to access static instance of TradeAddServiceAsync
     */
    public static class App {
        private static final TradeAddServiceAsync ourInstance = (TradeAddServiceAsync) GWT.create(TradeAddService.class);

        public static TradeAddServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
