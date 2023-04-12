package ac.mz.armazenardados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    private EditText nome_ed, password_ed, passconfirm_ed;
    private Button cadastrarbtn, limparbtn;
    private TextView telaprincipal_tv;

    DataBase db = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);



        nome_ed = findViewById(R.id.nome_ed);
        password_ed = findViewById(R.id.password_ed);
        passconfirm_ed = findViewById(R.id.passwordconfirm_ed);

        cadastrarbtn = findViewById(R.id.cadastrar_btn);
        limparbtn = findViewById(R.id.limpar_btn);

        telaprincipal_tv = findViewById(R.id.telaprincipal_tv);


        cadastrarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = nome_ed.getText().toString();
                String pass = password_ed.getText().toString();
                String pass01 = passconfirm_ed.getText().toString();

                confirmacao(nome, pass, pass01);



            }
        });
        limparbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome_ed.setText("");
                password_ed.setText("");
                passconfirm_ed.setText("");
            }
        });

        telaprincipal_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cadastrar.this, MainActivity.class);
                startActivity(i);
            }
        });




    }
    public void confirmacao(String nome, String password, String password_confirmacao){

        if(nome.isEmpty() || password.isEmpty() || password_confirmacao.isEmpty()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

        }else{
            if(password.equals(password_confirmacao)){

                DataBase db = new DataBase(Cadastrar.this);
                db.inserir(nome, password, password_confirmacao);
            }else{
                Toast.makeText(this, "As passwords, nao coincidem!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}