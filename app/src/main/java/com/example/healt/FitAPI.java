package com.example.healt;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

//public class FitAPI {
//    private void buildClient() {
//        fitApiClient = new GoogleApiClient.Builder(application)
//                .addApi(Fitness.HISTORY_API)
//                .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
//                .addConnection Callbacks(new GoogleApiClient.ConnectionCallbacks() {
//                    @Override
//                    public void onConnected(@Nullable Bundle bundle) {
//                        connectionResultPublishSubject.onNext(ConnectionUpdate.onConnected());
//                    }
//
//                    @Override
//                    public void onConnectionSuspended(int i) {
//                        connectionResultPublishSubject.onNext(ConnectionUpdate.onSuspended(i));
//                    }
//                })
//                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
//                    @Override
//                    public void onConnectionFailed(@NonNull ConnectionResult result) {
//                        connectionResultPublishSubject.onNext(ConnectionUpdate.onFailed(result));
//                    }
//                })
//                .build();
//    }
//}
