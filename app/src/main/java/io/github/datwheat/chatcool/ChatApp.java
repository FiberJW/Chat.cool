package io.github.datwheat.chatcool;

import android.app.Application;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class ChatApp extends Application {
    private static final String BASE_URL = "https://api.graph.cool/simple/v1/cj1l913yd1vp90176qvoh6f5m";
    private ApolloClient apolloClient;

    @Override
    public void onCreate() {
        super.onCreate();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build();

        apolloClient = ApolloClient.<ApolloCall>builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build();
    }

    public ApolloClient apolloClient() {
        return apolloClient;
    }
}
