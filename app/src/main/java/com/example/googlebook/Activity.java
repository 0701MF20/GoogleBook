package com.example.googlebook;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
public class Activity extends AppCompatActivity {
  public SearchView s1;
    public static final String GOOGLE_BOOK_URL1="https://www.googleapis.com/books/v1/volumes?q=";
  public static final String GOOGLE_BOOK_URL3="&key=AIzaSyAajyzH3dKChxNRBw6gH2hQceeFEUTysgU";
  public static String GOOGLE_BOOK_URL=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);
        s1=(SearchView)findViewById(R.id.search_view_Id);
        Button b1=(Button)findViewById(R.id.button_view_Id);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Activity.this,MainActivity.class);
                CharSequence s2=s1.getQuery();
                String s3=s2.toString();
                GOOGLE_BOOK_URL=GOOGLE_BOOK_URL1+s3+GOOGLE_BOOK_URL3;
                startActivity(i);
            }
        });
    }
}
