/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.background.sync;

import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.firebase.jobdispatcher.RetryStrategy;

import android.content.Context;
import android.os.AsyncTask;

/*
 * Service runs on main thread ... not async
 */
public class WaterReminderFirebaseJobService extends JobService {

    /*
     * aync task to handle long processing
     */

    // TODO (3) WaterReminderFirebaseJobService should extend from JobService
    AsyncTask mBackgroundTask;

    // TODO (4) Override onStartJob
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {

        // TODO (5) By default, jobs are executed on the main thread, so make an anonymous class extending
        //  AsyncTask called mBackgroundTask.

        mBackgroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Context context = WaterReminderFirebaseJobService.this;
                ReminderTasks.executeTask(context, ReminderTasks.ACTION_CHARGING_REMINDER);
                return null;
            }

            // TODO (8) Override onPostExecute and called jobFinished. Pass the job parameters
            @Override
            protected void onPostExecute(Object obj)
            {
                jobFinished(jobParameters, false);
            }
        };

        mBackgroundTask.execute();
        return true;
    }


    // TODO (6) Override doInBackground

        // TODO (7) Use ReminderTasks to execute the new charging reminder task you made, use
        // this service as the context (WaterReminderFirebaseJobService.this) and return null
        // when finished.



    // and false to jobFinished. This will inform the JobManager that your job is done
            // and that you do not want to reschedule the job.

        // TODO (9) Execute the AsyncTask
        // TODO (10) Return true

    /*
     * call stop when executing criterion fails
     * example: start job with wi-fi... then wi-fi becomes unavaialble
     */
    // TODO (11) Override onStopJob
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        // TODO (12) If mBackgroundTask is valid, cancel it
        if(mBackgroundTask!=null)
            mBackgroundTask.cancel(true);
        // TODO (13) Return true to signify the job should be retried
        return true;
    }
}
