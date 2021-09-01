package com.example.googlebook;
import androidx.appcompat.app.AppCompatActivity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<BookInfo>> {
    private BookAdapter adapterss;
    public static final String GOOGLE_BOOK_URL="https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=AIzaSyAajyzH3dKChxNRBw6gH2hQceeFEUTysgU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(1,null,this);
        ListView l1=(ListView)findViewById(R.id.list_view_Id);
        adapterss=new BookAdapter(this,new ArrayList<>());
        l1.setAdapter(adapterss);
    }
    @Override
    public Loader<List<BookInfo>> onCreateLoader(int id, Bundle args) {
    return new BookLoader(this,GOOGLE_BOOK_URL);
    }
    @Override
    public void onLoadFinished(Loader<List<BookInfo>> loader, List<BookInfo> data) {
    adapterss.clear();
    if(data!=null&&!data.isEmpty())
    {
        adapterss.addAll(data);
    }
    }
    @Override
    public void onLoaderReset(Loader<List<BookInfo>> loader) {
        adapterss.clear();
    }
}