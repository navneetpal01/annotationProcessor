package com.example.annotation_processor

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class MyRepositoryModule {


    @Binds
    abstract fun bindMyRepository(impl : MyRepositoryIml) : MyRepository




}


//The reason why we use abstract module imagine a scenario when we have multiple modules and we need database in our another module

// In app module (abstract class)
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class AppModule {
//
//    @Binds
//    abstract fun bindNetworkClient(client: MyNetworkClientImpl): MyNetworkClient
//
//}
//
//// In feature module (inherits and overrides)
//@Module
//@InstallIn(FeatureModuleComponent::class)
//class FeatureModule : AppModule() {
//
//    @Override
//    @Binds
//    abstract fun bindNetworkClient(client: FeatureNetworkClientImpl): MyNetworkClient
//
//}
