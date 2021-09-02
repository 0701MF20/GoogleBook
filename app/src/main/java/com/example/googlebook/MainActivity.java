package com.example.googlebook;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
//import android.widget.SearchView;
public class MainActivity extends AppCompatActivity /*implements LoaderManager.LoaderCallbacks<List<BookInfo>> */ {
//"https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=AIzaSyAajyzH3dKChxNRBw6gH2hQceeFEUTysgU"
   // public static String GOOGLE_BOOK_URL1 = " ";
   // public static final String GOOGLE_BOOK_URL = "https://www.googleapis.com/books/v1/volumes?q=" + GOOGLE_BOOK_URL1 + "&key=AIzaSyAajyzH3dKChxNRBw6gH2hQceeFEUTysgU";
    public static final String GOOGLE_BOOK_URL="https://www.googleapis.com/books/v1/volumes?q=fly";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);
   //     SearchView search = (SearchView) findViewById(R.id.search_view_Id);
      //  GOOGLE_BOOK_URL1 = search.toString();
        Button button = (Button) findViewById(R.id.button_view_Id);
        button.setOnClickListener(v -> {
            Intent ii;
            ii = new Intent(MainActivity.this, activity.class);
            startActivity(ii);
        });
    }
}