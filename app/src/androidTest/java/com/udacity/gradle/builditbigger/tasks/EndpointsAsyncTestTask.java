package com.udacity.gradle.builditbigger.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EndpointsAsyncTestTask extends EndpointsAsyncTask {

    private AsyncTaskCallBack mCallback;

    public void setAsyncTaskCallback(AsyncTaskCallBack asyncTaskCallback){
        mCallback = asyncTaskCallback;
    }

    public interface AsyncTaskCallBack{
        void onPostExecute(String response);
    }

    @Override
    protected void onPostExecute(String joke) {
       mCallback.onPostExecute(joke);
    }
}
