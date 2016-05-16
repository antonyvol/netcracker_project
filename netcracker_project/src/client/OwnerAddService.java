package client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by Антон on 14.05.2016.
 */
@RemoteServiceRelativePath("OwnerAddService")
public interface OwnerAddService extends RemoteService {
    void update();
    /**
     * Utility/Convenience class.
     * Use OwnerAddService.App.getInstance() to access static instance of OwnerAddServiceAsync
     */
    public static class App {
        private static final OwnerAddServiceAsync ourInstance = (OwnerAddServiceAsync) GWT.create(OwnerAddService.class);

        public static OwnerAddServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
