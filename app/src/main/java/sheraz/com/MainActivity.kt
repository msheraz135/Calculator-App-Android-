package sheraz.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import sheraz.com.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }

    fun buNumberEvent(view: View) {

        if (isNewOp)
        {
            binding.etxtCal.setText("")
        }
        isNewOp=false

        var buClicked :String=binding.etxtCal.text.toString()
        when(view.id)
        {

            binding.button0.id ->{
                buClicked +="0"
                }
            binding.button1.id ->{
                buClicked +="1"
            }
            binding.button2.id ->{
                buClicked +="2"
            }
            binding.button3.id ->{
                buClicked +="3"
            }
            binding.button4.id ->{
                buClicked +="4"
            }
            binding.button5.id ->{
                buClicked +="5"
            }
            binding.button6.id ->{
                buClicked +="6"
            }
            binding.button7.id ->{
                buClicked +="7"
            }
            binding.button8.id ->{
                buClicked +="8"
            }
            binding.button9.id ->{
                buClicked +="9"
            }
            binding.buttonPlusMinus.id ->{
                buClicked = "-$buClicked"

            }
            binding.buttonDecimal.id ->{
                buClicked +="."
            }

        }
        binding.etxtCal.setText(buClicked)
    }
    var op="*"
    var oldNumber=""
    var isNewOp= true
    fun buOpEvent(view: View) {

        //val buSelect= view as Button
        when(view.id) {
            binding.buttonMulti.id -> {

                op="*"

            }
            binding.buttonDivide.id -> {

                op="/"
            }
            binding.buttonMinus.id -> {


                op="-"
            }
            binding.buttonplus.id -> {

                op="+"
            }


        }
        oldNumber= binding.etxtCal.text.toString()
         isNewOp = true

    }

    fun buEqualEvent(view: View) {
        val newNumber = binding.etxtCal.text.toString()
        var finalNumber:Double? =null
        when(op)
        {
            "*"->{
                finalNumber=  oldNumber.toDouble() *newNumber.toDouble()
            }
            "/"->{
                finalNumber=  oldNumber.toDouble() /newNumber.toDouble()
            }
            "+"->{
                finalNumber=  oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber=  oldNumber.toDouble() -newNumber.toDouble()
            }
        }
        binding.etxtCal.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buClean(view:View){
        binding.etxtCal.setText("0")
        isNewOp=true
    }

    fun buPercent(view: View) {
        val number:Double=binding.etxtCal.text.toString().toDouble()/100

        binding.etxtCal.setText(number.toString())
        isNewOp=true

    }

    fun buplusMinus(view: View) {

            val number =binding.etxtCal.text.toString()
            var SignRefactorProcess =""

            SignRefactorProcess = if(number.contains("-"))
            {
                number.drop(1)
            }
            else
            {
                "-$number"
            }
            binding.etxtCal.setText(SignRefactorProcess)

    }

}

