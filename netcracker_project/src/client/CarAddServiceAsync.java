package client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Антон on 14.05.2016.
 */
public interface CarAddServiceAsync {
    void update(AsyncCallback<Void> async);
}
