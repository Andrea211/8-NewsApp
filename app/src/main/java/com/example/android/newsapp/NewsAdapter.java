package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Basia on 2017-07-12.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * The part of the location string from the GUARDIAN service that we use to extract
     * publication date
     */
    private static final String PUBLICATION_DATE_SEPARATOR = "T";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        News currentNews = getItem(position);

        // Find the TextView with view ID webTitle
        TextView titleView = (TextView) listItemView.findViewById(R.id.web_title);
        String webTitle = currentNews.getWebTitle();
        // Display the webTitle of the current news in that TextView
        titleView.setText(webTitle);

        // Find the TextView with view ID section name
        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.section_name);
        String sectionName = currentNews.getSectionName();
        // Display the section name of the current news in that TextView
        sectionNameView.setText(sectionName);

        // Get the original date string from the News object,
        // which can be in the format of "2017-04-18T17:20:59Z" or "Pacific-Antarctic Ridge".
        String originalDate = currentNews.getPublicationDate();

        // If the original date string (i.e. "2017-04-18T17:20:59Z") contains
        // a date (2017-04-18) and a time (17:20:59)
        // then store the date separately from the time in 2 Strings,
        // so they can be displayed in 2 TextViews.
        String date;
        String time;

        // Split the string into different parts (as an array of Strings)
        // based on the "T" text. We expect an array of 2 Strings, where
        // the first String will be "2017-04-18" and the second String will be "17:20:59".
        String[] parts = originalDate.split(PUBLICATION_DATE_SEPARATOR);
        // Date should be "2017-04-18"
        date = parts[0];
        // Time should be "17:20:59"
        time = parts[1];
        time = time.substring(0, time.length() - 1);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(date);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display the time of the current news in that TextView
        timeView.setText(time);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
