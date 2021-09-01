package com.example.googlebook;
import androidx.appcompat.app.AppCompatActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<BookInfo>> {
    private BookAdapter adapterss;
    public NetworkInfo network;
    private ProgressBar pbar;
    private  TextView t1;
    public static final String GOOGLE_BOOK_URL="https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=AIzaSyAajyzH3dKChxNRBw6gH2hQceeFEUTysgU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.Empty_and_no_internet_view_Id);
        pbar=(ProgressBar)findViewById(R.id.progress_bar_Id);
        ConnectivityManager cm=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        network=cm.getActiveNetworkInfo();
        getLoaderManager().initLoader(1,null,this);
        ListView l1=(ListView)findViewById(R.id.list_view_Id);
        adapterss=new BookAdapter(this,new ArrayList<>());
        l1.setAdapter(adapterss);
        l1.setEmptyView(t1);
    }
    @Override
    public Loader<List<BookInfo>> onCreateLoader(int id, Bundle args) {
    if(network!=null&&network.isConnectedOrConnecting()) {
        return new BookLoader(this, GOOGLE_BOOK_URL);
    }
    else
    {
        t1.setText("NO INTERNET CONNECTION");
        return null;
    }
    }
    @Override
    public void onLoadFinished(Loader<List<BookInfo>> loader, List<BookInfo> data) {
    adapterss.clear();

    if(data!=null&&!data.isEmpty())
    {
        adapterss.addAll(data);
    }
    else
    {
        t1.setText("NO DATA FOUND");
    }
    }
    @Override
    public void onLoaderReset(Loader<List<BookInfo>> loader) {
        adapterss.clear();
    }
}