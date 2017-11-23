import android.app.Application;
import android.content.Context;

/**
 * @author zyl
 * @version 1.0
 * @date 2017/11/23
 */
@SuppressWarnings("unused")
public class JdApp extends Application {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = base;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
