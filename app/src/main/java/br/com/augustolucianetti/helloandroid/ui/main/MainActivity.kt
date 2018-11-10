package br.com.augustolucianetti.helloandroid.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.augustolucianetti.helloandroid.R
import br.com.augustolucianetti.helloandroid.model.Pedido
import br.com.augustolucianetti.helloandroid.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel::class.java)

        cbAtum.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.atumSelecionado = isChecked
        }

        cbBacon.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.baconSelecionado = isChecked
        }

        cbCalabresa.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.calabresaSelecionada = isChecked
        }

        cbMussarela.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.mussarelaSelecionada = isChecked
        }

        mainViewModel.nomeCliente = intent.getStringExtra("nome")
        mainViewModel.telefoneCliente = intent.getStringExtra("telefone")
        tvNome.text = getString(R.string.saudacao, mainViewModel.nomeCliente, mainViewModel.telefoneCliente)

        cbAtum.isChecked = mainViewModel.atumSelecionado
        cbMussarela.isChecked = mainViewModel.mussarelaSelecionada
        cbCalabresa.isChecked = mainViewModel.calabresaSelecionada
        cbBacon.isChecked = mainViewModel.baconSelecionado

        btCalcular.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("pedido", geraPedido())
            startActivity(intent);
        }
    }

    private fun geraPedido(): Pedido? {
        return Pedido (mainViewModel.nomeCliente, mainViewModel.telefoneCliente)
    }
}
