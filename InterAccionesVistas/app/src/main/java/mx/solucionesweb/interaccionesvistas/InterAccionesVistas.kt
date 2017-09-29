package mx.solucionesweb.interaccionesvistas

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class InterAccionesVistas : AppCompatActivity(), View.OnClickListener{



    private var txtNombre: TextView? = null;
    private var txtResultado: TextView? = null;
    private var btn: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inter_acciones_vistas)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        txtNombre = findViewById(R.id.txtNombre) as TextView?
        txtResultado = findViewById(R.id.txtResultado) as TextView?
        btn = findViewById(R.id.btn) as Button?
        txtResultado?.text = "hola mundo!!!"
        

        btn?.setOnClickListener(this)
        txtResultado?.setOnClickListener(this)


        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_inter_acciones_vistas, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }



    override fun onClick(view: View?) {
        if (view?.id == R.id.btn)
        {
            txtResultado?.text = txtNombre?.text
        }
        if (view?.id == R.id.txtResultado)
        {
            Toast.makeText(this, "Click en resultado", Toast.LENGTH_LONG).show()
        }
    }

}
