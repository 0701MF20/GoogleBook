package com.example.googlebook;
import android.content.Context;
import android.content.AsyncTaskLoader;
import java.net.URL;
import java.util.List;
public class BookLoader extends AsyncTaskLoader<List<BookInfo>> {
    private final String mURls;
  public List<BookInfo> list_of_book;
    BookLoader(Context context, String url)
    {
        super(context);
        mURls=url;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    @Override
    public List<BookInfo> loadInBackground() {
        URL linkk=QueryUtils.createUrl(mURls);
        if(linkk==null)
        {
            return null;
        }
        else {
        list_of_book=QueryUtils.fetchFromServer(linkk);
        return list_of_book;
        }
    }


}
