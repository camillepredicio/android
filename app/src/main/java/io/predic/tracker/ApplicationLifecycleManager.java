package io.predic.tracker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

class ApplicationLifecycleManager implements Application.ActivityLifecycleCallbacks {
    private int nbRunningActivities = 0;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        nbRunningActivities++;
        if (nbRunningActivities == 1) {
            Log.d("PREDICIO", "Application in foreground.");
            PredicIO.getInstance().sendHttpForegroundRequest();
        }
    }

    @Override
    public void onActivityStopped(Activity activity) {
        nbRunningActivities--;
        if (nbRunningActivities == 0) {
            Log.d("PREDICIO", "Application in background.");
        }
    }
}
