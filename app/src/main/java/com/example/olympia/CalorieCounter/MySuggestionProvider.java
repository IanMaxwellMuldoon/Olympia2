package com.example.olympia.CalorieCounter;

import android.content.SearchRecentSuggestionsProvider;

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "com.example.olympia.CalorieCounter.MySuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;
    public MySuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

    @Override
    protected void setupSuggestions(String authority, int mode) {
        super.setupSuggestions(authority, mode);
    }
}
