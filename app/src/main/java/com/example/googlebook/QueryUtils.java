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

public final class QueryUtils {
    public static List<BookInfo> fetchFromServer(URL linking) {
        if (linking == null) {
            return null;
        } else {
            String arc = null;
            try {
                arc = makeHttpRequest(linking);
            } catch (IOException e) {
                Log.e("QueryUtils", "io exception", e);
            }
            return parsingJSON(arc);
        }
    }

    public static List<BookInfo> parsingJSON(String arcit) {
        List<BookInfo> infoes = new ArrayList<>();
        try {
            JSONObject bookLearn = new JSONObject(arcit);
            JSONArray arrayBook = bookLearn.getJSONArray("items");
            for (int i = 0; i < arrayBook.length(); i++) {
                JSONObject Ob1 = arrayBook.getJSONObject(i);
                JSONObject Ob2 = Ob1.getJSONObject("volumeInfo");
                String title = Ob2.getString("title");
                JSONArray Ob3 = Ob2.getJSONArray("authors");
                StringBuilder auth=new StringBuilder();
                for (int j = 0; j < Ob3.length(); j++) {
                    auth.append(Ob3.getString(j));
                    if(j<=Ob3.length()-2)
                    {
                        auth.append(" And ");
                    }
                }
                String rating = Ob2.getString("maturityRating");
                String languagee = Ob2.getString("language");
              //  int counts = Ob2.getInt("pageCount");

                infoes.add(new BookInfo(title, auth.toString(), rating, languagee/*, counts*/));
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Parsing JSON-EXCEPTION", e);
        }
        return infoes;
    }

    public static URL createUrl(String urls) {
        URL urrl = null;
        try {
            urrl = new URL(urls);

        } catch (MalformedURLException e) {
            Log.e("QueryUtils", "Exception in create url", e);
            //   return null;
        }
        return urrl;
    }

    public static String makeHttpRequest(URL urllss) throws IOException  //REMAIN IN TIS FILE
    {
        String json = "";
        if (urllss == null) {
            return json;
        }
        HttpURLConnection urlConnections = null;
        InputStream inputStreams = null;
        try {
            urlConnections = (HttpURLConnection) urllss.openConnection();
            urlConnections.setReadTimeout(10000);
            urlConnections.setConnectTimeout(15000);
            urlConnections.setRequestMethod("GET");
            urlConnections.connect();
            if (urlConnections.getResponseCode() == 200) {
                inputStreams = urlConnections.getInputStream();
                json = ReadFromStream(inputStreams);
            } else {
                Log.e("QueryUtil", "Error Response Code" + urlConnections.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("QueryUtil", "IOEXCEPTION", e);
        } finally {
            if (urlConnections != null) {
                urlConnections.disconnect();
            }
            if (inputStreams != null) {
                inputStreams.close();
            }
        }
        return json;
    }

    /*
     public static String makeHttpRequest(URL urml) throws IOException
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
             urlConnection.setConnectTimeout(120000);
             urlConnection.setReadTimeout(100000);
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
   */
    public static String ReadFromStream(InputStream streamer) throws IOException {
        StringBuilder output = new StringBuilder();
        if (streamer != null) {
            InputStreamReader streaming = new InputStreamReader(streamer, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(streaming);
            //     try {
            String lined = bufferedReader.readLine();
            while (lined != null) {
                output.append(lined);
                lined = bufferedReader.readLine();
            }
            //    } catch (IOException e) {
            //     Log.e("QueryUtils","ReadFromStream Ioexception",e);
            //     }
       //     return output.toString();
            // }
      /*  else
        {
            return output.toString();
        }  */
        }
        return output.toString();
    }
}

