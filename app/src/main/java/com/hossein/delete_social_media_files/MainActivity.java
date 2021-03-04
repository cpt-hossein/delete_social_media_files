package com.hossein.delete_social_media_files;

import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    File dir = getFilesDir();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deleteDirectory(dir);

}

    static public boolean deleteDirectory(File path) {
        if( path.exists() ) {
            File[] files = path.listFiles();
            if (files == null) {
                return true;
            }
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return( path.delete() );
    }

}