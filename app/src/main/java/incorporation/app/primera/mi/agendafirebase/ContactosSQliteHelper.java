package incorporation.app.primera.mi.agendafirebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LENOVO on 25/10/2017.
 */

public class ContactosSQliteHelper extends SQLiteOpenHelper {

    String DATA_BASE_NAME = "LibrosBD";
    int DATA_VERSION = 1;

    String sqlCreate = "CREATE TABLE libros(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," + //0
            "name TEXT," +      //1
            "author TEXT," +     //2
            "presta TEXT," +     //3
            "phone TEXT)";      //4

    public ContactosSQliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS libros");
        sqLiteDatabase.execSQL(sqlCreate);

    }
}
