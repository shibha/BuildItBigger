package com.udacity.gradle.builditbigger.tasks;

import android.content.Context;
import android.util.Pair;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


@RunWith(AndroidJUnit4ClassRunner.class)
public class EndpointsAsyncTaskTest  {

    @Test
    public void testAsynTask() throws Exception {

        final Object syncObject = new Object();
        Context context = mock(Context.class);
        EndpointsAsyncTestTask task = new EndpointsAsyncTestTask();
        task.execute(new Pair<Context, String>(context, "DefaultTest"));


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