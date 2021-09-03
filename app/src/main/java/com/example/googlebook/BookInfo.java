package com.example.googlebook;
public class BookInfo {
    public String mTitle;
    public String mAuthor;
    public String mMaturityRating;
    public String mLanguage;
   // public int mpageCount;
    //public String mpublisher;
    BookInfo(String Title,String Author,String MaturityRating,String Language/*,int pageCount*//*,String publisher*/)
    {
        mTitle=Title;
        mAuthor=Author;
        mMaturityRating=MaturityRating;
       mLanguage=Language;
     //   mpageCount=pageCount;
     //   mpublisher=publisher;

    }
   public String getTitle()
    {
        return mTitle;
    }
    public String getAuthor()
    {
        return mAuthor;
    }
    public String getMaturityRating()
    {
        return mMaturityRating;
    }
    public String getLanguage()
    {
        return mLanguage;
    }
  /*  public int getpageCount()
    {
        return mpageCount;
    }*/
 /*   public String getPublisher()
    {
        return mpublisher;
    }
*/
}
