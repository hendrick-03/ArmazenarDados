package ac.mz.armazenardados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CadastroDB.db";
    private static final String TABLE_NAME = "CADASTRO";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_NOME = "Nome";
    private static final String COLUMN_PASSWORDCONFIRM = "Passwordconfirm";
    private static final String COLUMN_PASSWORD = "Password";


    private Context context;

    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    // responsavel por criar tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NOME + " TEXT,"
                + COLUMN_PASSWORDCONFIRM + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void inserir(String nome, String password, String passwordconfirm) {
        SQLiteDatabase db = this.getWritableDatabase();

        if (db != null) {
            ContentValues cv = new ContentValues();


            cv.put(COLUMN_NOME, nome);
            cv.put(COLUMN_PASSWORD, password);
            cv.put(COLUMN_PASSWORDCONFIRM, passwordconfirm);

            long result = db.insert("CADASTRO", null, cv);

            if (result == -1) {
                Toast.makeText(context, "Cliente nao adicionado com sucesso", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "Cliente adicionado com sucesso", Toast.LENGTH_SHORT).show();
            }

        }
        db.close();

    }

    public boolean getCustomer(String nome, String password){
        SQLiteOpenHelper helper = new DataBase(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NOME + " = ? AND " + COLUMN_PASSWORD + " = ?", new String[]{nome, password});
            if(cursor.getCount()>0){
                return  true;

            }
            cursor.close();

        }
        return false;


    }

}
