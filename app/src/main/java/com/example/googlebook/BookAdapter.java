package com.example.googlebook;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class BookAdapter extends ArrayAdapter<BookInfo> {
    BookAdapter(Activity context, ArrayList<BookInfo> infoBook)
    {
        super(context,0,infoBook);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listView=convertView;
        if(listView==null)
        {
            listView=LayoutInflater.from(getContext()).inflate(R.layout.inflatelist,parent,false);
        }
        BookInfo book=getItem(position);
        TextView t1=(TextView)listView.findViewById(R.id.titlebook);
        t1.setText(book.getTitle());
        TextView t2=(TextView)listView.findViewById(R.id.authorId);
        t2.setText(book.getAuthor());
        TextView t3=(TextView)listView.findViewById(R.id.PageCountId);
        t3.setText(book.getpageCount());
        TextView t4=(TextView)listView.findViewById(R.id.maturityratingId);
        t4.setText(book.getMaturityRating());
        TextView t5=(TextView)listView.findViewById(R.id.LanguageID);
        t5.setText(book.getLanguage());
        return listView;
    }
}
