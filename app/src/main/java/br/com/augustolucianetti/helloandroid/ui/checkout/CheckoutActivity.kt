package br.com.augustolucianetti.helloandroid.ui.checkout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.augustolucianetti.helloandroid.R
import br.com.augustolucianetti.helloandroid.model.Pedido

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val pedido = intent.getParcelableExtra<Pedido>("pedido")
        Toast.makeText(this, pedido.nome, Toast.LENGTH_LONG).show()
    }
}
