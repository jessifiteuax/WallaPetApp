package com.example.wallapetapp.notificaciones

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wallapetapp.R

@SuppressLint("MissingPermission")
//@Composable
fun Notificacion(idCanal: String, context: Context) {
    //val context = LocalContext.current
    //val idCanal = "CanalWallapet"
    val idNotificacion = 0
    val titulo = "Gracias"
    val texto = "Has entrado al sistema una nueva mascota que busca a sus dueños. Gracias por ayudarla"
    val icono = BitmapFactory.decodeResource(context.resources, R.drawable.logowallapet)
    val priority: Int = NotificationCompat.PRIORITY_DEFAULT

   /* LaunchedEffect(Unit){
        crearCanalNotificacion(idCanal, context)
    }*/
    var builder = NotificationCompat.Builder(context,idCanal)
        .setSmallIcon(R.drawable.logowallapet)
        .setContentTitle(titulo)
        .setContentText(texto)
        .setLargeIcon(icono)
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(texto)
        )
        .setPriority(priority)
    with(NotificationManagerCompat.from(context)){
        notify(idNotificacion, builder.build())
    }
}



fun crearCanalNotificacion(idCanal: String, context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val nombre = "CanalWallapet"
        val descripcion = "Canal de notificaciones Wallapet"
        val importancia = NotificationManager.IMPORTANCE_DEFAULT
        val canal = NotificationChannel(idCanal,nombre,importancia)
            .apply {
                description = descripcion
            }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(canal)
    }
}
