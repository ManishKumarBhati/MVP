package com.bmk.daggerproject.di.component;

import com.bmk.daggerproject.BaseApplication;
import com.bmk.daggerproject.di.module.FragmentModule;
import com.bmk.daggerproject.di.module.NetworkModule;
import com.bmk.daggerproject.di.module.TModuel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, FragmentModule.class, NetworkModule.class, TModuel.class})
public interface ApplicationComponent extends AndroidInjector<BaseApplication> {


    @Override
    void inject(BaseApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(BaseApplication application);

        ApplicationComponent build();
    }
}