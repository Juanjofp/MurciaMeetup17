package com.juanjofp.meetup.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.juanjofp.meetup.mylibrary.books.BooksFactory;

public class BookDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_BOOK_ID = "extra_book_id";

    private BooksFactory.Book mBook;

    private TextView tvBookData;

    public static Intent newActivity(Context ctx, String idBook){
        Intent it = new Intent(ctx, BookDetailsActivity.class);
        it.putExtra(EXTRA_BOOK_ID, idBook);
        return it;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        String bookId = getIntent().getStringExtra(EXTRA_BOOK_ID);
        if(bookId == null) {
            Toast.makeText(this, getString(R.string.invalid_book_id), Toast.LENGTH_LONG).show();
            finish();
        }

        mBook = BooksFactory.ITEM_MAP.get(bookId);
        if(mBook == null) {
            Toast.makeText(this, getString(R.string.invalid_book_id), Toast.LENGTH_LONG).show();
            finish();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mBook.title);

        tvBookData = (TextView)findViewById(R.id.tvDataBookDetailsActivity);
        tvBookData.setText(mBook.toData());

    }
}
