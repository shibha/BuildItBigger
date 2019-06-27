package com.udacity.gradle.builditbigger.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest  {

    @Test
    public void testAsynTask() throws Exception {

        final Object syncObject = new Object();
        Context context = mock(Context.class);
        EndpointsAsyncTestTask task = new EndpointsAsyncTestTask();
        task.execute(new Pair<Context, String>(context, "ManfredTest"));

        task.setAsyncTaskCallback(new EndpointsAsyncTestTask.AsyncTaskCallBack() {
            @Override
            public void onPostExecute(String joke) {
                assertEquals(joke, "This is totally a funny joke");
                synchronized (syncObject){
                    syncObject.notify();
                }
            }
        });

        synchronized (syncObject){
            syncObject.wait();
        }
    }
}