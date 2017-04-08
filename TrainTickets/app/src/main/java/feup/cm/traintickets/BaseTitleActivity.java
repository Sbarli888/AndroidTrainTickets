package feup.cm.traintickets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.util.Date;

import feup.cm.traintickets.activities.LoginActivity;
import feup.cm.traintickets.runnables.TokenRefreshTask;

public class BaseTitleActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!tokenValid()) {
            refreshToken();
        }
    }

    protected boolean tokenValid() {
        sharedPrefs = getSharedPreferences("feup.cm.traintickets", Context.MODE_PRIVATE);
        this.token = sharedPrefs.getString("LOGIN_TOKEN", "");
        Date expires = new Date(sharedPrefs.getLong("LOGIN_EXPIRES", 0L));

        return !(token.isEmpty() || expires.before(new Date()));
    }

    protected void refreshToken() {
        String refresh = sharedPrefs.getString("LOGIN_REFRESH", "");
        TokenRefreshTask task = new TokenRefreshTask(refresh) {
            @Override
            protected void onPostExecute(Boolean success) {
                if(success) {
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("LOGIN_TOKEN", getToken().getToken());
                    editor.putLong("LOGIN_EXPIRES", getToken().getExpires().getTime());
                    editor.apply();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            protected void onCancelled() {

            }
        };
        task.execute((Void) null);
    }

    protected SharedPreferences getSharedPrefs() {
        return sharedPrefs;
    }

    protected String getToken() { return token; }
}