package com.example.databasesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null);

            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 40)");
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 25)");
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('João', 19)");
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Carlos', 25)");
//            sqLiteDatabase.execSQL("DELETE from pessoas WHERE id = 2");
            sqLiteDatabase.execSQL("UPDATE pessoas SET idade = 19 WHERE id =1");
            //sqLiteDatabase.execSQL("DROP TABLE pessoas");

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT id, nome, idade FROM pessoas ", null);

            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst(); //volta para o primeiro registro

            while (cursor != null) {
                Log.i("RESULTADO: - id", cursor.getString(indiceId) + " nome: " + cursor.getString(indiceNome) + " idade: " + cursor.getString(indiceIdade));

                cursor.moveToNext(); //move para o proximo registro
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}