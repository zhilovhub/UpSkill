package com.example.upskill.di

import dagger.Module


@Module(includes = [DataBaseModule::class, ViewModelModule::class])
class AppModule
