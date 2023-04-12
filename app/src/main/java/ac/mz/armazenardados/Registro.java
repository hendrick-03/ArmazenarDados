package ac.mz.armazenardados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registro extends AppCompatActivity {
    private EditText nome_res, email_res, apelido_res, morada_res;
    private Button registrar_btn, listarbtn;
    private RadioButton masculino_rad, feminino_rad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nome_res = findViewById(R.id.nome_ed);
        email_res = findViewById(R.id.email_res);
        apelido_res = findViewById(R.id.apelido_res);
        morada_res = findViewById(R.id.morada_res);

        registrar_btn = findViewById(R.id.registrarbtn);
        listarbtn = findViewById(R.id.listarbtn);

        masculino_rad = findViewById(R.id.masculino_rad);
        feminino_rad = findViewById(R.id.femino_rad);


    }
}