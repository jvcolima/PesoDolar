package mx.solucionesweb.pesosdolar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast






class MainActivity : AppCompatActivity(), View.OnClickListener {

    public var txtPeso: EditText? = null;
    public var txtDolar: EditText? = null;
    public var TipoCambio: EditText? = null;

    private var buttonADolar: Button? = null;
    private var buttonAPeso: Button? = null;




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPeso = findViewById(R.id.txtPeso) as EditText?
        txtDolar = findViewById(R.id.txtDolar) as EditText?
        TipoCambio = findViewById(R.id.txtTipoCambio) as EditText?

        buttonADolar = findViewById(R.id.buttonADolar) as Button?
        buttonAPeso = findViewById(R.id.buttonAPeso) as Button?



        buttonADolar?.setOnClickListener(this)
        buttonAPeso?.setOnClickListener(this)





        txtPeso?.setOnTouchListener(View.OnTouchListener { arg0, arg1 ->
            txtPeso?.text = Editable.Factory.getInstance().newEditable("")
            txtDolar?.text = Editable.Factory.getInstance().newEditable("")
            false
        })

        txtDolar?.setOnTouchListener(View.OnTouchListener { arg0, arg1 ->
            txtPeso?.text = Editable.Factory.getInstance().newEditable("")
            txtDolar?.text = Editable.Factory.getInstance().newEditable("")
            false
        })

//        txtPeso?.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable) {
//                try {
//                    Log.i("entro","1");
//                    val d = java.lang.Double.parseDouble(txtPeso?.text.toString())
//                    Log.i("entro","2");
//                    txtDolar?.text = Editable.Factory.getInstance().newEditable((tipoCambio * d).toString());
//                    Log.i("entro","3");
//
//
//                } catch (nfe: Exception) {
//                    //return false
//                    nfe.printStackTrace()
//                }
//            }
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//
//            }
//
//        })
//
//        txtDolar?.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable) {
//                try {
//                    val d = java.lang.Double.parseDouble(txtDolar?.text.toString())
//
//                    txtPeso?.text = Editable.Factory.getInstance().newEditable((tipoCambio / d).toString());
//
//                } catch (nfe: Exception) {
//                    //return false
//                }
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//            }
//        })
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.buttonADolar)
        {
            try {
                    val d = java.lang.Double.parseDouble(txtPeso?.text.toString())
                    txtDolar?.text = Editable.Factory.getInstance().newEditable((d/TipoCambio?.text.toString().toDouble()).toString());

                    val toast = Toast.makeText(this, "Convertido a Dolar", Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

            } catch (nfe: Exception) {
                    //return false
                    nfe.printStackTrace()
                }
        }
        if (view?.id == R.id.buttonAPeso)
        {
            try {
                val d = java.lang.Double.parseDouble(txtDolar?.text.toString())

                txtPeso?.text = Editable.Factory.getInstance().newEditable((TipoCambio?.text.toString().toDouble() * d).toString());
                val toast = Toast.makeText(this, "Convertido a Peso", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()

            } catch (nfe: Exception) {
                //return false
            }

        }
    }
}
