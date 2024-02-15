package com.example.wallapetapp.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.wallapetapp.R

class Notificacion(var context: Context){
    val title = context.getString(R.string.gracias)
    val msg = context.getString(R.string.por_ayudar_a_encontrar_su_familia_a_la_mascota)
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

