package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by Антон on 14.05.2016.
 */
@RemoteServiceRelativePath("CarAddService")
public interface CarAddService extends RemoteService {
    void update();
    
    /**
     * Utility/Convenience class.
     * Use CarAddService.App.getInstance() to access static instance of CarAddServiceAsync
     */
    public static class App {
        private static final CarAddServiceAsync ourInstance = (CarAddServiceAsync) GWT.create(CarAddService.class);

        public static CarAddServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
