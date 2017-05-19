package com.juanjofp.meetup.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.juanjofp.meetup.mylibrary.books.BooksFactory;
import com.juanjofp.meetup.mylibrary.helpers.Credentials;

public class BookListActivity extends AppCompatActivity
implements BookListFragment.OnListFragmentInteractionListener{

    private static final int RESULT_LOGIN = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        if(!Credentials.isLogin(this)) {
            startActivityForResult(LoginActivity.newActivity(this), RESULT_LOGIN);
        }
        else {
            loadBooks();
        }
    }

    private void loadBooks() {
        Toast.makeText(this, getString(R.string.msg_loading_books), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOGIN) {
            if(resultCode == RESULT_OK) {
                loadBooks();
            }
            else {
                Toast.makeText(this, getString(R.string.msg_login_required), Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public void onListFragmentInteraction(BooksFactory.Book item) {
        Toast.makeText(this, "book selected: " + item.title, Toast.LENGTH_SHORT).show();
        startActivity(BookDetailsActivity.newActivity(this, item.id));
    }
}
