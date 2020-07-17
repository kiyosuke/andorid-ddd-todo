package com.kiyosuke.dddsample.di

import android.app.Application
import com.kiyosuke.dddsample.App
import com.kiyosuke.dddsample.MainActivityModule
import com.kiyosuke.dddsample.ui.todo.edit.TodoEditFragmentModule
import com.kiyosuke.dddsample.ui.todo.list.TodoListFragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        DbComponentModule::class,
        DomainServiceComponentModule::class,
        FactoryComponentModule::class,
        RepositoryComponentModule::class,
        UseCaseComponentModule::class,
        MainActivityModule.MainActivityBuilder::class,
        ViewModelModule::class,
        TodoListFragmentModule::class,
        TodoEditFragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    override fun inject(instance: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

fun Application.createAppComponent(): AppComponent = DaggerAppComponent.factory().create(this)