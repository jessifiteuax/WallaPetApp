package com.example.wallapetapp.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.wallapetapp.R

class Notificacion(var context: Context){
    val title = "Gracias"
    val msg = "Has entrado al sistema una nueva mascota que busca a sus dueños. Gracias por ayudarla"
    val channelId = "Canal1"
    val channelName = "Canal Wallapet"
    val notificationManager=context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: NotificationCompat.Builder

    fun lanzaNotificacion(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationChannel= NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        notificationBuilder=NotificationCompat.Builder(context,channelId)
        notificationBuilder.setSmallIcon(R.drawable.fotodefecto)
        notificationBuilder.setContentTitle(title)
        notificationBuilder.setContentText(msg)
        notificationBuilder.setAutoCancel(true)
        notificationManager.notify(1,notificationBuilder.build())
    }
}

