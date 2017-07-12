package com.example.android.newsapp;

/**
 * Created by Basia on 2017-07-12.
 */

public class News {

    // Title of the news
    private String mWebTitle;

    // Section name of the news (eg. politics)
    private String mSectionName;

    // Publication date
    private String mPublicationDate;

    // Website of the news
    private String mUrl;

    /**
     * Constructs a new {@Link News} object.
     *
     * @param webTitle is the title of the news
     * @param sectionName is the name of the category of the news (eg. politics, culture)
     * @param publicationDate is the time of the publication of the news
     * @param url is the website URL where is a news
     */
    public News(String webTitle, String sectionName, String publicationDate, String url){
        mWebTitle = webTitle;
        mSectionName = sectionName;
        mPublicationDate = publicationDate;
        mUrl = url;
    }

    // Returns the title of the news
    public String getWebTitle() { return mWebTitle; }

    // Returns the section name of the news
    public String getSectionName() { return mSectionName; }

    // Returns the publication date of the news
    public String getPublicationDate() { return  mPublicationDate; }

    // Returns the website url of the news
    public String getUrl() { return mUrl; }

}
