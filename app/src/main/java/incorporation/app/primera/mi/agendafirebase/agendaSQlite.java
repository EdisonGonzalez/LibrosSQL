package incorporation.app.primera.mi.agendafirebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class agendaSQlite extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText eID, eName, eAuthor,ePresta, ePhone;
    ContactosSQliteHelper contactosSQliteHelper;
    SQLiteDatabase dbLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        eID = (EditText) findViewById(R.id.eID);
        eName = (EditText) findViewById(R.id.eName);
        eAuthor = (EditText) findViewById(R.id.eAuthor);
        ePresta = (EditText)findViewById(R.id.ePresta);
        ePhone = (EditText) findViewById(R.id.ePhone);


        contactosSQliteHelper = new ContactosSQliteHelper(this, "LibrosBD", null, 1);
        dbLibros = contactosSQliteHelper.getWritableDatabase();
    }

    public void onClick(View view) {

        int id = view.getId();
        String name, author,presta, phone;
        final String uidd;

        name = eName.getText().toString();
        author = eAuthor.getText().toString();
        presta = ePresta.getText().toString();
        phone = ePhone.getText().toString();

        ContentValues data = new ContentValues();

        switch (id) {
            case R.id.bCreate:

                data.put("name", name);
                data.put("author", author);
                data.put("presta",presta);
                data.put("phone", phone);

                dbLibros.insert("libros", null, data);
                clean();

                break;

            case R.id.bRead:

                Cursor cursor = dbLibros.rawQuery("SELECT * FROM libros WHERE name='" + name + "'", null);

                if (cursor.moveToFirst()) {
                    eAuthor.setText(cursor.getString(2));
                    ePresta.setText(cursor.getString(3));
                    ePhone.setText(cursor.getString(4));
                } else {
                    Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.bUpdate:

                data.put("presta", presta);
                data.put("phone", phone);
                dbLibros.update("libros", data, "name = '" + name + "'", null);
                clean();

                break;

            case R.id.bDelete:

                dbLibros.delete("libros","name = '"+name+"'",null);
                clean();

                break;
        }

    }

    private void clean() {
        eID.setText("");
        eName.setText("");
        eAuthor.setText("");
        ePresta.setText("");
        ePhone.setText("");
    }
}
