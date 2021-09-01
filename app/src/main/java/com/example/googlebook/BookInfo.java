package com.example.googlebook;
public class BookInfo {
    public String mTitle;
    public String mAuthor;
    public String mMaturityRating;
    public String mLanguage;
    public int mpageCount;
    BookInfo(String Title,String Author,String MaturityRating,String Language,int pageCount)
    {
        this.mTitle=Title;
        this.mAuthor=Author;
        this.mMaturityRating=MaturityRating;
        this.mLanguage=Language;
        this.mpageCount=pageCount;
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
    public int getpageCount()
    {
        return mpageCount;
    }

}
