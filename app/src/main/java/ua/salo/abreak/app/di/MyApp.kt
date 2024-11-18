package ua.salo.abreak.app.di

import android.app.Application
import androidx.room.Room
import dagger.Provides
import dagger.hilt.android.HiltAndroidApp
import ua.salo.abreak.data.local.dao.BreaksDao
import ua.salo.abreak.data.local.database.BreaksDatabase
import ua.salo.abreak.data.local.datasource.BreaksLocalDataSource
import ua.salo.abreak.data.repository.BreaksRepositoryImpl
import ua.salo.abreak.domain.usecases.AddNewBreakUseCase
import javax.inject.Singleton

@HiltAndroidApp
class MyApp: Application()
