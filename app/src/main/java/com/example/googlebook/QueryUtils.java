package com.example.googlebook;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public  class QueryUtils
{
    public static List<BookInfo> fetchFromServer(URL linking)
    {
       if(linking==null)
       {
           return null;
       }
       else {
           String arc = makeHttpRequest(linking);
           return parsingJSON(arc);
       }
    }

    public static List<BookInfo> parsingJSON(String arc)
    {
        List<BookInfo> infoes=new ArrayList<>();
            try {
                JSONObject bookLearn=new JSONObject(arc);
                JSONArray arrayBook=bookLearn.getJSONArray("items");
               for(int i=0;i<arrayBook.length();i++)
               {
                   JSONObject Ob1=arrayBook.getJSONObject(i);
                   JSONObject Ob2=Ob1.getJSONObject("volumeInfo");
                   String title=Ob2.getString("title");
                   JSONArray Ob3=Ob2.getJSONArray("authors");
                   StringBuilder auth= new StringBuilder();
                   for(int j=0;j<Ob3.length();j++)
                   {
                       if(j>0)
                       {
                           auth = new StringBuilder(" And ");
                       }
                       auth.append(Ob3.getString(j));
                   }
                   String rating=Ob2.getString("maturityRating");
                   String languagee=Ob2.getString("language");
                   int counts=Ob2.getInt("pageCount");
                 infoes.add(new BookInfo(title, auth.toString(),rating,languagee,counts));
                 return infoes;
               }
            } catch (JSONException e) {
               Log.e("QueryUtils","Parsing JSON-EXCEPTION",e);
            }
return null;
    }
    public static URL createUrl(String urls)
    {
        try {
            URL urrl=new URL(urls);
            return urrl;
        } catch (MalformedURLException e) {
            Log.e("QueryUtils","Exception in create url",e);
            return null;
        }
    }
    public static String makeHttpRequest(URL urml)
    {
        String json="";
        if(urml==null)
        {
            return json;
        }
        HttpURLConnection urlConnection=null;
        InputStream streaminput=null;
        try {
            urlConnection=(HttpURLConnection)urml.openConnection();
            urlConnection.setConnectTimeout(1200);
            urlConnection.setReadTimeout(1000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if(urlConnection.getResponseCode()==200)
            {
                streaminput=urlConnection.getInputStream();
                json=ReadFromStream(streaminput);
            }
            else
            {
                Log.e("QueryUtils",urlConnection.getResponseCode()+"");
            }
        }
        catch (IOException e)
        {
        Log.e("Querutils,","makeHttpRequest-- io exception",e);
        }
        finally {
            if(urlConnection!=null)
            {
                urlConnection.disconnect();
            }
            if(streaminput!=null)
            {
                try {
                    streaminput.close();
                } catch (IOException e) {
                   Log.e("QueryUtils","StreamInput close Io exception",e);
                }
            }
        }

return json;
    }
    public static String ReadFromStream(InputStream streamer)
    {
        StringBuilder output=new StringBuilder();
        if(streamer!=null)
        {
            InputStreamReader streaming=new InputStreamReader(streamer, Charset.forName("UTF-8"));
            BufferedReader bufferedReader=new BufferedReader(streaming);
            try {
                String lined=bufferedReader.readLine();
                while (lined!=null)
                {
                    output.append(lined);
                    lined=bufferedReader.readLine();
                }
            } catch (IOException e) {
              Log.e("QueryUtils","ReadFromStream Ioexception",e);
            }
            return output.toString();
        }
        else
        {
            return output.toString();
        }
    }

}
