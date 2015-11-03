package com.couchbase.lite.android;

import com.couchbase.lite.storage.SQLiteStorageEngine;
import com.couchbase.lite.storage.SQLiteStorageEngineFactory;

/**
 * Android SQLiteStorageEngineFactory implementation
 */
public class AndroidSQLiteStorageEngineFactory implements SQLiteStorageEngineFactory {
    private android.content.Context context = null;
    public AndroidSQLiteStorageEngineFactory(android.content.Context context){
        this.context = context;
    }
    @Override
    public SQLiteStorageEngine createStorageEngine() {
        return new AndroidSQLiteStorageEngine(context);
    }
}
