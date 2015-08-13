package pl.com.wwsis.bazadanych;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewContactActivity extends AppCompatActivity {

    EditText ContactName, ContactNumer, ContactEmail;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        ContactName = (EditText) findViewById(R.id.contactname);
        ContactNumer = (EditText) findViewById(R.id.mobielnr);
        ContactEmail = (EditText) findViewById(R.id.email);
    }

    public void addNewContact(View view) {
        String name = ContactName.getText().toString();
        String number = ContactNumer.getText().toString();
        String email = ContactEmail.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformation(name, number, email, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_SHORT).show();
        userDbHelper.close();

    }
}
