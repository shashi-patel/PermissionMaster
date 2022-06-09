package lib.shashi.permissions;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Shashikant Patel on 09/06/2022 at 14:06
 */

@SuppressWarnings("WeakerAccess")
public abstract class PermissionHandler {

    public abstract void onGranted();

    public void onDenied(Context context, ArrayList<String> deniedPermissions) {
        if (Permissions.loggingEnabled) {
            StringBuilder builder = new StringBuilder();
            builder.append("Denied:");
            for (String permission : deniedPermissions) {
                builder.append(" ");
                builder.append(permission);
            }
            Permissions.log(builder.toString());
        }
        Toast.makeText(context, "Permission Denied.", Toast.LENGTH_SHORT).show();
    }

    @SuppressWarnings("UnusedParameters")
    public boolean onBlocked(Context context, ArrayList<String> blockedList) {
        if (Permissions.loggingEnabled) {
            StringBuilder builder = new StringBuilder();
            builder.append("Set not to ask again:");
            for (String permission : blockedList) {
                builder.append(" ");
                builder.append(permission);
            }
            Permissions.log(builder.toString());
        }
        return false;
    }

    public void onJustBlocked(Context context, ArrayList<String> justBlockedList,
                              ArrayList<String> deniedPermissions) {
        if (Permissions.loggingEnabled) {
            StringBuilder builder = new StringBuilder();
            builder.append("Just set not to ask again:");
            for (String permission : justBlockedList) {
                builder.append(" ");
                builder.append(permission);
            }
            Permissions.log(builder.toString());
        }
        onDenied(context, deniedPermissions);
    }

}
