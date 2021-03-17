package com.arifahmadalfian.thesportsdb.favorite

import android.content.Context
import com.arifahmadalfian.thesportsdb.di.DynamicFeatureDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [DynamicFeatureDependencies::class])
interface FavoriteComponent {
    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(dynamicModuleDependencies: DynamicFeatureDependencies): Builder
        fun build(): FavoriteComponent
    }

}
