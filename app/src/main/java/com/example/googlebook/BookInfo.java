package com.example.googlebook;
public class BookInfo {
    public String mTitle;
    public String mAuthor;
    public String mMaturityRating;
    public String mLanguage;
    public long mpageCount;
    BookInfo(String Title,String Author,String MaturityRating,String Language,long pageCount)
    {
        mTitle=Title;
        mAuthor=Author;
        mMaturityRating=MaturityRating;
       mLanguage=Language;
        mpageCount=pageCount;
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
    public long getpageCount()
    {
        return mpageCount;
    }

}
