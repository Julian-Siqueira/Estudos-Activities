package devandroid.julian.aulaactivityfragment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var btnFechar : Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFechar = findViewById(R.id.button)
        textView = findViewById(R.id.text_view)

        val bundle = intent.extras //Recuperando todos parametros



        if (bundle != null){

            /*val filme = bundle.getString("Filme")
            val classificacao = bundle.getInt("Classificação")
            val avaliacao = bundle.getDouble("Avaliação")*/

            //val filme = bundle.getSerializable("filme") as Filme
            val filme = bundle.getParcelable<Filme>("filme")

//            val resultado = "filme: $filme \nclassificação: $classificacao \navaliacao: $avaliacao "
//            textView.text = "${filme?.nome} - ${filme?.distribuidor}"
            textView.text = "Filme: ${filme?.nome} \nDiretor: ${filme?.diretor} " +
                    "\nDescrição: ${filme?.descricao} \nAvaliação: ${filme?.avalicoes} " +
                    "\nDistribuidor: ${filme?.distribuidor}"

//            textView.text = resultado

        }
        btnFechar.setOnClickListener {

            finish()

        }
    }
}