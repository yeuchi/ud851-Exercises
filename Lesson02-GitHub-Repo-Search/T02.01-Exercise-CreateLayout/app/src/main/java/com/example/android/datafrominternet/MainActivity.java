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
package com.example.android.datafrominternet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.datafrominternet.utilities.NetworkUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // TODO (26) Create an EditText variable called mSearchBoxEditText
    // TODO (27) Create a TextView variable called mUrlDisplayTextView
    // TODO (28) Create a TextView variable called mSearchResultsTextView

    EditText mSearchBoxEditText;
    TextView mUrlDisplayTextView;
    TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (29) Use findViewById to get a reference to mSearchBoxEditText

        // TODO (30) Use findViewById to get a reference to mUrlDisplayTextView
        // TODO (31) Use findViewById to get a reference to mSearchResultsTextView

        mSearchBoxEditText = (EditText)findViewById(R.id.et_search_box);
        mUrlDisplayTextView = (TextView)findViewById(R.id.tv_url_display);
        mSearchResultsTextView = (TextView)findViewById(R.id.tv_github_search_results_json);
    }

    public class GithubQueryTask extends AsyncTask<URL, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String searchResult)
        {

        }

        @Override
        protected String doInBackground(URL...params)
        {
            URL url = params[0];
            String result = null;

            try
            {
                result = NetworkUtils.getResponseFromHttpUrl(url);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            return result;
        }
    }
}
