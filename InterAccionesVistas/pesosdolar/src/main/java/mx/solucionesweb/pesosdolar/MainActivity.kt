package mx.solucionesweb.pesosdolar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    private var txtPeso: EditText? = null;
    private var txtDolar: EditText? = null;
    private var tipoCambio: Double = 17.50;





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPeso = findViewById(R.id.txtPeso) as EditText?
        txtDolar = findViewById(R.id.txtDolar) as EditText?


        txtPeso?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                try {
                    Log.i("entro","1");
                    val d = java.lang.Double.parseDouble(txtPeso?.text.toString())
                    Log.i("entro","2");
                    txtDolar?.text = Editable.Factory.getInstance().newEditable((tipoCambio * d).toString());
                    Log.i("entro","3");
                    return;

                } catch (nfe: Exception) {
                    //return false
                    nfe.printStackTrace()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {



            }


        })

        txtDolar?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                try {
                    val d = java.lang.Double.parseDouble(txtDolar?.text.toString())

                    txtPeso?.text = Editable.Factory.getInstance().newEditable((tipoCambio / d).toString());
                    return;

                } catch (nfe: Exception) {
                    //return false

                }


            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {


            }
        })


    }
}
