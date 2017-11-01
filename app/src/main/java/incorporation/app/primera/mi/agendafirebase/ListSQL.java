package incorporation.app.primera.mi.agendafirebase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class ListSQL extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ContactosSQliteHelper contactosSQliteHelper;
    SQLiteDatabase dbLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_sql);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_list_sql, contentFrameLayout);

        contactosSQliteHelper = new ContactosSQliteHelper(this, "LibrosBD", null, 1);
        dbLibros = contactosSQliteHelper.getWritableDatabase();

        ArrayList<User> userArrayList = new ArrayList<User>();

        Cursor cursor = dbLibros.rawQuery("SELECT * FROM libros", null);

        if (cursor.moveToFirst()) {

            do {
                User user = new User(String.valueOf(cursor.getInt(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                userArrayList.add(user);
            } while (cursor.moveToNext());

        } else {
            Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
        }

        ContactosAdapter contactosAdapter = new ContactosAdapter(this, userArrayList);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recicler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactosAdapter);
    }
}
