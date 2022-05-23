package com.qairym.presentation.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import com.qairym.R

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
) {
    //1. create remote view
    val remoteViews = RemoteViews(context.packageName, R.layout.new_app_widget)

    //2. define intent --> action which will be performed
    val intent = Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data = Uri.parse("https://www.youtube.com")

    val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

    //3. set pending intent on view
    remoteViews.setOnClickPendingIntent(R.id.widget_button, pendingIntent)

    //4. update the widget
    appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
}