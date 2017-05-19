package com.juanjofp.meetup.mylibrary.books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class BooksFactory {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Book> ITEMS = new ArrayList<Book>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Book> ITEM_MAP = new HashMap<String, Book>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createBookItem(i));
        }
    }

    private static void addItem(Book item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Book createBookItem(int position) {
        return new Book(String.valueOf(position), "My book " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Book {
        public final String id;
        public final String title;
        public final String details;

        public Book(String id, String content, String details) {
            this.id = id;
            this.title = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return title;
        }

        public String toData() {
            return id + ":" + title + " > " + details;
        }
    }
}
