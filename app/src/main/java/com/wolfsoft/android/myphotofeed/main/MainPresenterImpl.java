package com.wolfsoft.android.myphotofeed.main;

import android.location.Location;

import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.main.events.MainEvent;
import com.wolfsoft.android.myphotofeed.main.ui.MainView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by farithjhg on 30/06/2016.
 */
public class MainPresenterImpl implements MainPresenter{
    private MainView view;
    private EventBus eventBus;
    private UploadInteractor uploadInteractor;
    private SessionInteractor sessionInteractor;

    public MainPresenterImpl(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        this.view = view;
        this.eventBus = eventBus;
        this.uploadInteractor = uploadInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void uploadPhoto(Location location, String path) {
        uploadInteractor.execute(location, path);
    }

    @Override
    @Subscribe
    public void onEventMainThread(MainEvent event) {
        if (this.view != null) {
            switch (event.getType()) {
                case MainEvent.UPLOAD_INIT:
                    view.onUploadInit();
                    break;
                case MainEvent.UPLOAD_COMPLETE:
                    view.onUploadComplete();
                    break;
                case MainEvent.UPLOAD_ERROR:
                    view.onUploadError(event.getError());
                    break;
            }
        }
    }

    @Override
    public void logout() {
        sessionInteractor.logout();
    }
}