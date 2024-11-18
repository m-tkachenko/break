package ua.salo.abreak.app.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ua.salo.abreak.data.local.dao.BreaksDao
import ua.salo.abreak.data.local.database.BreaksDatabase
import ua.salo.abreak.data.local.datasource.BreaksLocalDataSource
import ua.salo.abreak.data.repository.BreaksRepositoryImpl
import ua.salo.abreak.domain.usecases.AddNewBreakUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): BreaksDatabase {
        return Room.databaseBuilder(
            appContext,
            BreaksDatabase::class.java,
            "weronika_database"
        ).build()
    }

    @Provides
    fun providesDao(
        database: BreaksDatabase
    ) = database.breaksDao()

    @Provides
    fun providesBreaksLocalDataSource(
        breaksDao: BreaksDao
    ) = BreaksLocalDataSource(breaksDao)

    @Provides
    fun providesBreaksRepository(
        dataSource: BreaksLocalDataSource
    ) = BreaksRepositoryImpl(dataSource)

    @Provides
    fun providesAddBreakUseCase(
        repositoryImpl: BreaksRepositoryImpl
    ) = AddNewBreakUseCase(repositoryImpl)
}
