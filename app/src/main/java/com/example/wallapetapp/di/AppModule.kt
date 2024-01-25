package com.example.wallapetapp.di

import android.content.Context
import androidx.room.Room
import com.example.wallapetapp.data.network.MascotaDB
import com.example.wallapetapp.data.network.MascotaDao
import com.example.wallapetapp.data.repository.MascotaRepositoryImpl
import com.example.wallapetapp.domain.repository.MascotaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideMascotaDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        MascotaDB::class.java,
        "mascotasTable"
    ).build()

    @Provides
    fun provideMascotaDao(
        mascotaDB: MascotaDB
    ) = mascotaDB.mascotaDao()

    @Provides
    fun provideMascotaRepository(
        mascotaDao: MascotaDao
    ):MascotaRepository = MascotaRepositoryImpl(
        mascotaDao=mascotaDao
    )



}