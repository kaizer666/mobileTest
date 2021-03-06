package pro.myburse.android.myburse;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import pro.myburse.android.myburse.Model.User;
import pro.myburse.android.myburse.Utils.Firebase.Config;

public class App extends Application {

    public final static int SOCIAL_ID_VK = 1;
    public final static int SOCIAL_ID_OK = 2;
    public final static int SOCIAL_ID_FB = 3;
    public final static String URL_BASE = "https://api.myburse.pro/";
    //public final static String URL_BASE = "https://api-test.myburse.pro/";
    public final static int COUNT_CARDS=20;
    private static Bus Otto;
    private User mUser;
    private String mDeviceId;
    private String mLogin;

    @Override
    public void onCreate() {
        super.onCreate();
        Otto = new Bus(ThreadEnforcer.MAIN);
    }

    public Bus getOtto(){
        return  Otto;
    }

    public User getUser() {
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        String user = pref.getString("user",null);
        mUser = (user==null)?User.getInstance(): new Gson().fromJson(user, User.class);
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("user", new Gson().toJson(mUser)).apply();
    }

    public String getLogin() {
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        mLogin = pref.getString("login","");
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("login", login).apply();
    }
    public String getDeviceId() {
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        mDeviceId = pref.getString("device_id",null);
        return mDeviceId;
    }

    public void setDeviceId(String mDeviceId) {
        this.mDeviceId = mDeviceId;
        SharedPreferences pref = getSharedPreferences(Config.SHARED_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("device_id", mDeviceId).apply();
    }
}
