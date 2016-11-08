package br.com.marcellogalhardo.challenge.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class BrowserUtils {

  public void open(Context context, String url) {
    Uri uri = Uri.parse(url);
    open(context, uri);
  }

  public void open(Context context, Uri uri) {
    Intent intentWeb = new Intent(Intent.ACTION_VIEW);
    intentWeb.setData(uri);
    context.startActivity(intentWeb);
  }
}
