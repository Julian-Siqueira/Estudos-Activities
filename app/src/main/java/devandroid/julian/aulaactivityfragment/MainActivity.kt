package devandroid.julian.aulaactivityfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //crio a variavel que depois vou usar
    lateinit var btnAbrir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Ciclo_Vida", "onCreate Executado")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAbrir = findViewById(R.id.btn_abrir)

        btnAbrir.setOnClickListener {

            //preciso instanciar um objeto do tipo intent, passando no construtor o
            //contexto, Tela a ser aberta
            val intent = Intent(this, DetalhesActivity::class.java)

            //passar parametros para uma nova tela

            /*
            intent.putExtra("Filme", "Cidade_de_Deus")
            intent.putExtra("Classificação", 8)
            intent.putExtra("Avaliação", 7.9)
            */

            val filme = Filme(
                "Sem limites",
                "Teste",
                8.9,
                "Julian",
                "Netflix"
            )

            intent.putExtra("filme", filme)


            //Iniciar nova tela, passando como parametro a intent q criamos
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo_Vida", "onStart Executado")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo_Vida", "onResume Executado")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo_Vida", "onPause Executado")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo_Vida", "onStop Executado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo_Vida", "onRestart Executado")
    }

    override fun onDestroy() {
        Log.i("Ciclo_Vida", "onDestroy Executado")
        super.onDestroy()
    }

}
