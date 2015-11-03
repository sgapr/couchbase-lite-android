package com.couchbase.lite;

import com.couchbase.lite.storage.SQLiteStorageEngineFactory;
import com.couchbase.test.lite.*;
import org.apache.commons.io.*;

import java.io.*;

public class LiteTestContext extends LiteTestContextBase implements Context {

    private File filesDir;

    public LiteTestContext(android.content.Context context, String subdir, boolean deleteSubdirectory) {
        super(context);
        filesDir = new File(getRootDirectory(), subdir);

        if (deleteSubdirectory) {
            try {
                FileUtils.deleteDirectory(filesDir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (filesDir.exists() == false && filesDir.mkdir() == false) {
            throw new RuntimeException("Couldn't create directory " + filesDir.getAbsolutePath());
        }
    }

    public LiteTestContext(android.content.Context context) {
        this(context, true);
    }

    public LiteTestContext(android.content.Context context, String subdir) {
        this(context, subdir, true);
    }
    public LiteTestContext(android.content.Context context, boolean deleteSubdirectory) {
        this(context, "test", deleteSubdirectory);
    }

    @Override
    public File getFilesDir() {
        return filesDir;
    }

    @Override
    public void setNetworkReachabilityManager(NetworkReachabilityManager networkReachabilityManager) {

    }

    @Override
    public SQLiteStorageEngineFactory getSQLiteStorageEngineFactory() {
        return super.getSQLiteStorageEngineFactory();
    }

    @Override
    public NetworkReachabilityManager getNetworkReachabilityManager() {
        return new TestNetworkReachabilityManager();
    }

    class TestNetworkReachabilityManager extends NetworkReachabilityManager {
        @Override
        public void startListening() {

        }

        @Override
        public void stopListening() {

        }
    }

}
