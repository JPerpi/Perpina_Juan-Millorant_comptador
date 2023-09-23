# Activitat 1: Millorant el comptador
## 1. Anàlisi de l’estructura del projecte

  El projecte consisteix en un comptador de clics, usa com a llenguatge de programació Kotlin.
  
  La seua estructura aquesta formada per tres carpetes principals que són: 
    -La carpeta manifest, que conté el AndroidManifest.xml
    -la carpeta java que conté l'app i els test 
    -La carpeta res on es troben els recursos que usarà l'aplicació

  #### “Si volguera afegir una nova activitat, sería suficient crear el fitxer de layout i el fitxer Kotlin amb la classe?”
  
  A part de crear els fitxer *layout i el fitxer amb la classe s'hauria de modificar el *AndroidManifest.*xml
  perquè si no l'aplicació no detectaria que has creat una nova activitat.

## 2. Análisi del clicle de vida i el problema de la pèrdua d’estat

El comptador es reinicia al girar la pantalla pel fet que android al girar la pantalla no guarda l'estat de l'app,
a més no s'ha aplicat un control per a evitar que això succeïsca.

## 3. Solució a la pèrdua d’estat

Per a evitar-ho introduirem aquest codi perquè guarde l'estat de l'app abans de girar-lo

      'override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Codi per a guardar l'estat
        estat.putInt("Comptador", comptador)
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        textViewContador.setText(comptador.toString())
    }'

I aquest per a restaurar l'estat guardat

      'override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        // Codi per a guardar l'estat
        comptador=estat.getInt("Comptador")
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        textViewContador.setText(comptador.toString())
    }'

## 4. Ampliant la funcionalitat amb decrements i Reset

En el activity_main s'ha afegit el codi per a dos botons més, un per a restar i un altre per a retornar el comptador a 0, s'ha tingut en compte que el comptador no pot ser negatiu i s'ha fet un control perquè això no passe

Botó de sumar:
```
<Button
            android:id="@+id/btSuma"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="+"
            android:textSize="34sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.198"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textViewComptador"
            app:layout_constraintVertical_bias="0.503" />
```

Botó de restar: 
```
 <Button
            android:id="@+id/btResta"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="-"
            android:textSize="34sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.811"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textViewComptador"
            app:layout_constraintVertical_bias="0.503" />
```
            
Botó de reinicialitzar:
```
<Button
            android:id="@+id/btAdd"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0"
            android:textSize="34sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textViewComptador" />
```

Código de los botones en el main:
```
        val btAdd=findViewById<Button>(R.id.btAdd)
        val btResta=findViewById<Button>(R.id.btResta)
        val btSuma=findViewById<Button>(R.id.btSuma)

        //Botones para sumar, restar y devolver el contador a 0
        btAdd.setOnClickListener {
            comptador=0
            textViewContador.setText(comptador.toString())
        }
        btResta.setOnClickListener {
            //Control para que al restar el contar no pase a negativo
            if (comptador==0){
                comptador=0
            }else{
                comptador--
            }
            textViewContador.setText(comptador.toString())
        }
        btSuma.setOnClickListener {
            comptador++
            textViewContador.setText(comptador.toString())
        }
```

## 5. Canvis per implementar el View Binding

Per a activar el binding hem de fer el següent:

 1. Hem d'anar al build.gradle del mòdul on usarem el binding

```
  buildFeatures{
        viewBinding=true
    }
```

 2. Ara hem d'anar al main declarar la variable binding i en la funció onCreate es modifica el setContentView

```
 private lateinit var binding: ActivityMainBinding
```
```
binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
```

 3. Modificar el main per a usar el binding per a accedir als elements de la interfície




