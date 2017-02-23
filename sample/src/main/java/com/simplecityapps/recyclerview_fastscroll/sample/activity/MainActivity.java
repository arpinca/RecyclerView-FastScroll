/*
 * Copyright (c) 2016 Tim Malseed
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.simplecityapps.recyclerview_fastscroll.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.simplecityapps.recyclerview_fastscroll.sample.R;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final boolean IS_GRID_LAYOUT = true;
    private static final int GRID_SPAN_COUNT = 3;
    private static final int ITEM_COUNT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FastScrollRecyclerView recyclerView = (FastScrollRecyclerView) findViewById(R.id.recycler);

        if (IS_GRID_LAYOUT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, GRID_SPAN_COUNT));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        recyclerView.setAdapter(new RecyclerAdapter(ITEM_COUNT));
    }
}
