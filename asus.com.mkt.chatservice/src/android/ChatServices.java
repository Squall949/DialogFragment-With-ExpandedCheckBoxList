package asus.com.mkt.chatservice;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.devpro.uimsdk.UIMClient;
import java.util.List;
import java.util.ArrayList;

/**

 */
public class ChatServices extends CordovaPlugin {

  /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("connect")){
        callbackContext.success(1);
    } else {
        callbackContext.error(0);
    }
      return true;
  }

  //--------------------------------------------------------------------------
  // LOCAL METHODS
  //--------------------------------------------------------------------------

}
