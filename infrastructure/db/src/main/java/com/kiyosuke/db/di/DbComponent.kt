package com.kiyosuke.db.di

import android.content.Context
import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.db.di.internal.DbModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class
    ]
)
interface DbComponent {

    fun todoDatabase(): TodoDatabase

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance fileName: String?
        ): DbComponent
    }

    companion object {
        fun factory(): Factory = DaggerDbComponent.factory()
    }
}