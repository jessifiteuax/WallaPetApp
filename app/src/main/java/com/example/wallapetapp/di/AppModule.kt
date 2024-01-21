package com.example.wallapetapp.di

import android.content.Context
import androidx.room.Room
import com.example.wallapetapp.room.MascotasBBDD
import com.example.wallapetapp.room.MascotasBBDDDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesMascotasDao(mascotasBBDD: MascotasBBDD): MascotasBBDDDao{
        return mascotasBBDD.mascotasDao()
    }

    @Singleton
    @Provides
    fun providesMascotasBBDD(@ApplicationContext context: Context): MascotasBBDD{
        return Room. databaseBuilder(
            context,
            MascotasBBDD::class.java,"Mascotas_bbdd"
        ).fallbackToDestructiveMigration()
            .build()
    }


}