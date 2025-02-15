package me.ccrama.redditslide.Autocache;

/**
 * Created by carlo_000 on 10/13/2015.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import me.ccrama.redditslide.CommentCacheAsync;
import ltd.ucode.slide.App;
import me.ccrama.redditslide.util.NetworkUtil;

public class CacheAll extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (NetworkUtil.isConnectedNoOverride(context)) {
            if (App.cachedData.getBoolean("wifiOnly", false) && !NetworkUtil.isConnectedWifi(context))
                return;
            new CommentCacheAsync(context, null, null, App.cachedData.getString("toCache", "").split(",")).executeOnExecutor(
                    AsyncTask.THREAD_POOL_EXECUTOR);

        }
    }
}
