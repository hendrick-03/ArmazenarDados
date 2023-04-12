package ac.mz.armazenardados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBase db = new DataBase(this);

    private EditText nome_id, pass_id;
    private Button entrar_btn;
    private TextView tela_de_cadastro;
    boolean verifica = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome_id = findViewById(R.id.nome_id);
        pass_id = findViewById(R.id.pass_id);

        tela_de_cadastro = findViewById(R.id.tela_de_cadastro);

        entrar_btn = findViewById(R.id.Entrar_btn);

        entrar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nome_id.getText().toString();
                String pass = pass_id.getText().toString();


                if(nome.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Preencha os campos vazios", Toast.LENGTH_SHORT).show();
                    return;
                }

                verifica = db.getCustomer(nome, pass);
                if(verifica == true){
                    Toast.makeText(MainActivity.this, "lOGIN COM SUCESSO", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, TelaPrincipal.class);
                    startActivity(i);


                }else{
                    Toast.makeText(MainActivity.this, "Credenciais invalidas", Toast.LENGTH_SHORT).show();
                }



            }
        });

        tela_de_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(intent);
            }
        });

    }
}